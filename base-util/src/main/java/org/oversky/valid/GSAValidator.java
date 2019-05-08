package org.oversky.valid;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.oversky.util.bean.ReflectionUtils;
import org.oversky.valid.GSAValid.FilterType;
import org.oversky.valid.GSAValidRule.Rule;

public class GSAValidator {

	public static String serverValid(String clzName, String[] props, FilterType filter, Object o){
		Map<String, List<GSAValidRule>> rules = GSAValidConfig.getBeanRules(clzName, props, filter);
		//若没有配置规则，则不验证
		if(rules == null || rules.size() == 0){
			return null;
		}
		
		StringBuffer sb = new StringBuffer(2048);
		for(Map.Entry<String, List<GSAValidRule>> entry : rules.entrySet()) {
			String field = entry.getKey();
			String fieldValue = null;
			Object vo = ReflectionUtils.recGetPropertyValue(o, field);
			if(vo != null) {
				fieldValue = vo.toString();
			}
			
		    //检查是否存在非空规则，若没有，值为空可以不必验证
		    boolean allowEmpty = true;
		    List<GSAValidRule> list = entry.getValue();
		    for(GSAValidRule g : list){
		        Rule r = Enum.valueOf(Rule.class, g.getType());
		        if(r == Rule.NotNull){
		            allowEmpty = false;
		            break;
		        }
		    }
		    if(allowEmpty && StringUtils.isBlank(fieldValue)){
		        continue;
		    }
		    
		    //验证规则
		    for(GSAValidRule g : list){
		    	g.setFieldName(field);
    			if(!g.validField(fieldValue)){
    				sb.append(g.getMsg()).append(",");
    			}
		    }			
		}
		
		if(sb.length() > 1){
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
	
	public static String script(String clzName){
		return script(clzName, "_validForm");
	}
	
	public static String script(String clzName, String formId){
		return script(clzName, formId, null);
	}
	
	public static String script(String clzName, String formId, String[] props){
		return script(clzName, formId, props, FilterType.INCLUDE);
	}
	
	public static String script(String clzName, String formId, String[] props, FilterType filter){
		StringBuffer script = new StringBuffer();
		script.append("<script>");

		try{
			Map<String, List<GSAValidRule>> rules = GSAValidConfig.getBeanRules(clzName, props, filter);
			
			GSAValidRule temp = new GSAValidRule();
			for(List<GSAValidRule> list : rules.values()){
			    for(GSAValidRule g : list){
			        temp.addScript(g);
			    }
			}
			script.append(temp.getScript());
			script.append("function _validForm(){");
			script.append(temp.getScript());
			script.append("var validform=document.getElementById('").append(formId).append("');");
			script.append("return LiveValidationForm.getInstance(validform).validForm();}");
		}catch(Exception e){
			script.append("function _getScriptException(){alert(\"");
			script.append(e.getMessage());
			script.append("\");} _getScriptException();");
		}
		script.append("</script>");
		return script.toString();
	}
}
