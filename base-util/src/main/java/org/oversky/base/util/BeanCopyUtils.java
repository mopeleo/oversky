package org.oversky.base.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oversky.base.exception.BaseUtilException;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

public class BeanCopyUtils {

    private static final Map<String, BeanCopier> BEANCOPIER_CACHE = new HashMap<String, BeanCopier>();
    private static final SameNameTypeConverter convert = new SameNameTypeConverter();
    private BeanCopyUtils(){}
    
    public static <S, T> void copy(final S source, final T target) {
        if(source == null || target == null){
            throw new BaseUtilException("参数错误：参数为空");
        }
        BeanCopier copier = getBeanCopier(source.getClass(), target.getClass());
        //考虑到性能，尽量不要用convert
//        copier.copy(source, target, convert);
        copier.copy(source, target, null);
    }
    
    public static <S, T> T convert(S source, Class<T> target) {
        BeanCopier copier = getBeanCopier(source.getClass(), target);
        T obj = getInstance(target);
        copier.copy(source, obj, null);
        return obj;
    }

    public static <S, T> List<T> convertList(List<S> sourceList, Class<T> target) {
        if(sourceList == null || sourceList.size() == 0){
            return new ArrayList<T>();
        }
        
        List<T> result = new ArrayList<T>(sourceList.size());        
        for(S source : sourceList){
            T t = convert(source, target);
            result.add(t);
        }
        return result;
    }
    
    private static <S, T> BeanCopier getBeanCopier(Class<S> source, Class<T> target){
        String key = source.getName() + target.getName();
        BeanCopier copier = BEANCOPIER_CACHE.get(key);
        if(copier == null){
            copier = BeanCopier.create(source, target, false);
            BEANCOPIER_CACHE.put(key, copier);
        }
        return copier;
    }
    
    //可以替换为反射性能更高的工具reflectasm包下的ConstructorAccess类
    private static <T> T getInstance(Class<T> target) {
		try {
			T obj = target.newInstance();
			return obj;
		} catch (InstantiationException | IllegalAccessException e) {
        	throw new BaseUtilException(String.format("目标对象[%s]实例化失败: %s", target.getName(), e.getMessage()));
		}
    }
    
    //可以增加转换器
    private static class SameNameTypeConverter implements Converter {
		@Override
		// value 源对象属性，target 目标对象属性类，context 目标对象setter方法名 
		public Object convert(Object value, Class target, Object context) {
			if (value instanceof Integer) {  
	            return (Integer) value; 
			}
			if (value instanceof Long) {  
	            return (Long) value; 
			}
			return value;
		}    	
    }
}
