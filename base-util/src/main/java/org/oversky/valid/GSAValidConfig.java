package org.oversky.valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.oversky.util.json.JacksonUtils;
import org.oversky.valid.GSAValid.FilterType;

public class GSAValidConfig {
	
    private static final ResourceBundle RESOURCE = ResourceBundle.getBundle("gsa-validate");
    private static final Set<String> RESOURCE_KEYSET = RESOURCE.keySet();
    private static final String ALIAS_PREFIX = "prefix.";
    
    private static Map<String, Map<String,List<GSAValidRule>>> RULE_MAP = initRuleConfig();
    
    private GSAValidConfig(){}
    
    public static boolean enable() {
    	String enable = RESOURCE.getString("enable.valid");
    	if(enable != null && "false".equals(enable)) {
    		return false;
    	}
    	return true;
    }
    
    private static Map<String, Map<String, List<GSAValidRule>>> initRuleConfig() {
    	//找出所有别名映射关系
		Map<String, Map<String,List<GSAValidRule>>> map = new HashMap<>();
    	for(String aliasKey : RESOURCE_KEYSET){
    		if(aliasKey.startsWith(ALIAS_PREFIX)){
    			String clzName = RESOURCE.getString(aliasKey);
    			String alias = aliasKey.substring(ALIAS_PREFIX.length());
    			
    			Map<String,List<GSAValidRule>> fieldMap = new HashMap<>();
    	    	for(String fieldKey : RESOURCE_KEYSET){
    	    		String aliasPrex = alias + ".";
    	    		if(fieldKey.startsWith(aliasPrex)){
    	    			String fieldRule = RESOURCE.getString(fieldKey);
    	    			String field = fieldKey.substring(aliasPrex.length());
    	    			List<GSAValidRule> ruleList = JacksonUtils.jsonArray2List(fieldRule, GSAValidRule.class);
    	    			fieldMap.put(field, ruleList);
    	    		}
    	    	}
    			
    	    	map.put(clzName, fieldMap);
    		}
    	}
    	
    	return map;
    }
    
    /**
     *	根据类名，获得全部属性的效验规则
     * @param className 类名
     * @return ArrayList<GASValidRule>
     */
    public static Map<String, List<GSAValidRule>> getBeanRules(String className){
    	return getBeanRules(className, null, null);
    }
    
    /**
     * 	根据类名，获得全部属性的效验规则
     * @param className 类名
     * @param props 属性集合
     * @return ArrayList<GASValidRule>
     */
    public static Map<String, List<GSAValidRule>> getBeanRules(String className, String[] props, FilterType filter){
    	Map<String, List<GSAValidRule>> rules = RULE_MAP.get(className);

		if(props == null || props.length == 0){
			return rules;			
		}else{
			Map<String, List<GSAValidRule>> fileterRules = new HashMap<>();
			if(filter == FilterType.EXCLUDE){
				for(Map.Entry<String, List<GSAValidRule>> entry : rules.entrySet()) {
					fileterRules.put(entry.getKey(), entry.getValue());
				}
				for(String field : props){
					if(rules.containsKey(field)) {
						fileterRules.remove(field);
					}
				}
			}else{
				for(String field : props){
					if(rules.containsKey(field)) {
						fileterRules.put(field, rules.get(field));
					}
				}
			}
			return fileterRules;
		}
    }
    
}
