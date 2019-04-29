package org.oversky.code.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.oversky.code.model.Column;
import org.oversky.code.model.Model;
import org.oversky.code.model.Table;
import org.oversky.code.parser.config.DataType;

public class PDMParser {

	private static final String ATTR_ID = "Id";
	private static final String ATTR_REF = "Ref";
    private static final String ELEMENT_NAME = "Name";
    private static final String ELEMENT_CODE = "Code";
    private static final String ELEMENT_COMMENT = "Comment";
    private static final String ELEMENT_DATATYPE = "DataType";
    private static final String ELEMENT_LENGTH = "Length";
    private static final String ELEMENT_PRECISION = "Precision";
    private static final String ELEMENT_DEFAULTVALUE = "DefaultValue";
    private static final String ELEMENT_IDENTITY = "Identity";
    private static final String ELEMENT_MANDATORY = "Column.Mandatory";
    private static final String ELEMENT_COLUMNS = "Columns";
    private static final String ELEMENT_SEQUENCES = "Sequences";
    private static final String ELEMENT_SEQUENCE = "Sequence";
    private static final String ELEMENT_TABLES = "Tables";
    private static final String ELEMENT_TABLE = "Table";
    private static final String ELEMENT_KEY = "Key";
    private static final String ELEMENT_KEYS = "Keys";
    private static final String ELEMENT_KEY_COLUMN = "Key.Columns";
    private static final String ELEMENT_PRIMARYKEY = "PrimaryKey";
    private static final String NODE_ROOT = "//Model";
    private static final String NODE_DBMS = NODE_ROOT + "/o:RootObject/c:Children/o:Model/c:DBMS/o:Shortcut";
    private static final String NODE_TABLE = NODE_ROOT + "/o:RootObject/c:Children/o:Model/c:Tables/o:Table";
    private static final String NODE_SEQUENCE = NODE_ROOT + "/o:RootObject/c:Children/o:Model/c:Sequences/o:Sequence";
    private static final String NODE_PACKAGE = NODE_ROOT + "/o:RootObject/c:Children/o:Model/c:Packages/o:Package";
    
	private static final Map<String, String> SEQMAP = new HashMap<>();
	
    private PDMParser(){}
	
	public static Model parse(File cdm){
		return parse(cdm, null, null);
	}

	public static Model parse(File pdm, String modelPackage, String excludePattern){
		Model model = new Model();
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(pdm);
			//跳到c:DBMS解析数据库类型
			Element shortcut = (Element)document.selectSingleNode(NODE_DBMS);
			String dbms = shortcut.element(ELEMENT_NAME).getTextTrim().toUpperCase();
			DataType.SourceType type = DataType.getSourceType(dbms);
			
			//所有o:Table节点列表，对应表属性
			List oTableList = null;
			//所有o:Sequence节点列表，对应序列属性
			List oSequenceList = null;
			//先判断是否有package存在
			List<Element> packages = document.selectNodes(NODE_PACKAGE);
			if(packages == null || packages.size() == 0) {
				//直接跳到o:Table节点解析
				oTableList = document.selectNodes(NODE_TABLE);				
				oSequenceList = document.selectNodes(NODE_SEQUENCE);				
				System.out.println("不存在package节点");
			}else {
				oTableList = new ArrayList();				
				oSequenceList = new ArrayList();				
				for(Element pkg : packages) {
					String pkgCode = pkg.element(ELEMENT_CODE).getTextTrim();
					//如果配置文件有配置package名字
					if(modelPackage != null && !"".equals(modelPackage)) {
						//检查是否配置了多个package
						pkgCode = "," + pkgCode.toLowerCase() + ",";
						String tmpPackage = "," + modelPackage.toLowerCase() + ",";
						if(tmpPackage.indexOf(pkgCode) < 0) {
							continue;
						}
					}
					
					//找o:package节点下面的o:Table
					oTableList.addAll(pkg.element(ELEMENT_TABLES).elements(ELEMENT_TABLE));
					//找o:package节点下面的o:Sequence
					if(pkg.element(ELEMENT_SEQUENCES) != null) {
						oSequenceList.addAll(pkg.element(ELEMENT_SEQUENCES).elements(ELEMENT_SEQUENCE));
					}
				}
				System.out.println("package节点个数：" + packages.size());
			}

			//开始解析o:Table节点
			if(oTableList == null || oTableList.size() == 0){
				return model;
			}

			//开始解析o:Sequence节点
			if(oSequenceList != null && oSequenceList.size() > 0){
				for(int i = 0; i < oSequenceList.size(); i++) {
					Element elementSeq = (Element)oSequenceList.get(i);
					Attribute attrId = elementSeq.attribute(ATTR_ID);
					
					Element elementCode = elementSeq.element(ELEMENT_CODE);
	                String origincode = elementCode.getTextTrim().toLowerCase();
	                
	                SEQMAP.put(attrId.getValue(), origincode);
				}
			}
			
			for(int i = 0; i < oTableList.size(); i++){
				Table table = new Table();
				table.setDbms(dbms);
				Element elementTable = (Element)oTableList.get(i);
				
                Element elementCode = elementTable.element(ELEMENT_CODE);
                String origincode = elementCode.getTextTrim().toLowerCase();
				boolean exclude = false;
				if(excludePattern != null && !"".equals(excludePattern)) {
					String[] regPatterns = excludePattern.split(",");
					for(String regEx : regPatterns) {
						Pattern pattern = Pattern.compile(regEx);
						exclude = pattern.matcher(origincode).matches();
						System.out.println("pattern : " + regEx + ", table code : " + origincode + ", exclude : " + exclude);
						if(exclude) {
							break;
						}
					}
				}
				//若存在排除的table，则跳过
				if(exclude) {
					continue;
				}

				table.setOriginCode(origincode);
                String code = "";
                if(origincode.indexOf(DataType.CODE_SEP) > 0){
                    String[] parts = origincode.split(DataType.CODE_SEP);
                    table.setGroup(parts[0]);
                    for(int p = 0; p < parts.length; p++){
                        code += parts[p].substring(0, 1).toUpperCase() + parts[p].substring(1);
                    }
                }else{
                    code = origincode;
                }
                table.setCode(code);

				Attribute attrId = elementTable.attribute(ATTR_ID);
				table.setId(attrId.getValue());
				
				Element elementName = elementTable.element(ELEMENT_NAME);
				table.setName(elementName.getTextTrim());

				Element elementCommont = elementTable.element(ELEMENT_COMMENT);
				if(elementCommont == null){
					table.setComment(elementName.getTextTrim());
				}else{
					table.setComment(elementCommont.getTextTrim());
                    if(table.getComment().toLowerCase().indexOf("[cache]") >= 0) {
                    	table.setCache(true);
                    }
				}
				
				//解析c:PrimaryKey节点
				Element elementPKNode = elementTable.element(ELEMENT_PRIMARYKEY);
				List<String> keyList = new ArrayList<String>();
				if(elementPKNode != null){
				    Element elementPK = elementPKNode.element(ELEMENT_KEY);
				    String keyRefId = elementPK.attribute(ATTR_REF).getValue();
	                
	                //解析c:Keys节点
	                List keys = elementTable.element(ELEMENT_KEYS).elements();
	                for(int j = 0; j < keys.size(); j++){
	                    Element elementKey = (Element)keys.get(j);                  
	                    String keyId = elementKey.attribute(ATTR_ID).getValue();
	                    if(keyId.equals(keyRefId)){
	                        //解析c:Key.Columns节点
	                        List refCols = elementKey.element(ELEMENT_KEY_COLUMN).elements();
	                        for(int k = 0; k < refCols.size(); k++){
	                            Element elementRefCol = (Element)refCols.get(k);                            
	                            String colRefId = elementRefCol.attribute(ATTR_REF).getValue();
	                            keyList.add(colRefId);
	                        }                       
	                        break;
	                    }                   
	                }
				}
				
				//解析c:Columns节点
				List columns = elementTable.element(ELEMENT_COLUMNS).elements();
				for(int j = 0; j < columns.size(); j++){
					Column column = new Column();
					Element elementColumn = (Element)columns.get(j);
					
					attrId = elementColumn.attribute(ATTR_ID);
					column.setId(attrId.getValue());
					
					elementName = elementColumn.element(ELEMENT_NAME);
					column.setName(elementName.getTextTrim());

					elementCode = elementColumn.element(ELEMENT_CODE);
	                String colOrigincode = elementCode.getTextTrim().toLowerCase();
	                column.setOriginCode(colOrigincode);
	                String colCode = "";
	                if(colOrigincode.indexOf(DataType.CODE_SEP) > 0){
	                    String[] parts = colOrigincode.split(DataType.CODE_SEP);
	                    colCode = parts[0];
	                    for(int p = 1; p < parts.length; p++){
	                        colCode += parts[p].substring(0, 1).toUpperCase() + parts[p].substring(1);
	                    }
	                }else{
	                    colCode = colOrigincode;
	                }
	                column.setCode(colCode);
//	                System.out.println("column : id = " + column.getId() + ", name = " + column.getName() + ", code = " + column.getCode());

					elementCommont = elementColumn.element(ELEMENT_COMMENT);
					if(elementCommont == null){
						column.setComment("");
					}else{
						column.setComment(elementCommont.getTextTrim());
					}

					Element elementDataType = elementColumn.element(ELEMENT_DATATYPE);
					String origintype = elementDataType.getTextTrim().toUpperCase();
	                column.setOriginDatatype(origintype);
	                column.setDatatype(DataType.convertType(origintype, type));

					Element elementLength = elementColumn.element(ELEMENT_LENGTH);
					if(elementLength == null){
						column.setLength("");
					}else{
						column.setLength(elementLength.getTextTrim());
					}

					Element elementPrecision = elementColumn.element(ELEMENT_PRECISION);
					if(elementPrecision == null){
						column.setPrecision("");
					}else{
						column.setPrecision(elementPrecision.getTextTrim());
					}

					Element elementMandatory = elementColumn.element(ELEMENT_MANDATORY);
					if(elementMandatory == null){
						column.setMandatory("0");
					}else{
						column.setMandatory(elementMandatory.getTextTrim());
					}
					
					//oracle的pdm没有identity属性
					Element elementIdentity = elementColumn.element(ELEMENT_IDENTITY);
					if(elementIdentity == null){
						column.setIdentity("0");
					}else{
						column.setIdentity(elementIdentity.getTextTrim());
					}
					
					//mysql没有sequence属性
					Element elementSequence = elementColumn.element(ELEMENT_SEQUENCE);
					if(elementSequence != null) {
						String seqRefId = elementSequence.element(ELEMENT_SEQUENCE).attribute(ATTR_REF).getValue();
						//只有对应的列指定了sequence，自动生成的sql才会生成带seq.nextval
						if(SEQMAP.containsKey(seqRefId)) {
							column.setSequence(SEQMAP.get(seqRefId));
							column.setIdentity("1");
						}
					}
					
	                Element elementDefaultValue = elementColumn.element(ELEMENT_DEFAULTVALUE);
	                if(elementDefaultValue != null){
	                    column.setDefaultValue(elementDefaultValue.getTextTrim());
	                }
					
	                //添加column，如果有自增主键，添加到最前面
	                if("0".equals(column.getIdentity())) {
	                	table.addColumn(column);	                	
	                }else {
						table.setIdentityCol(column);
	                	table.getColumns().add(0, column);
	                }
	                
					if(keyList.contains(column.getId())){
						table.addKey(column);
					}else{
					    table.addColsExceptKey(column);
					}
				}

				model.addTable(table);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		return model;
	}
}
