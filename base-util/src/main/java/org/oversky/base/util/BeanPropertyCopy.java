package org.oversky.base.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

public class BeanPropertyCopy {

    private static final Map<String, BeanCopier> BEANCOPIER_CACHE = new HashMap<String, BeanCopier>();
    private static final SameNameTypeConverter convert = new SameNameTypeConverter();
    private BeanPropertyCopy(){}
    
    private static <S, T> BeanCopier getBeanCopier(Class<S> source, Class<T> target){
        String key = source.getName() + target.getName();
        BeanCopier copier = BEANCOPIER_CACHE.get(key);
        if(copier == null){
            copier = BeanCopier.create(source, target, false);
            BEANCOPIER_CACHE.put(key, copier);
        }
        return copier;
    }
    
    public static <S, T> void copy(final S source, final T target) {
        if(source == null || target == null){
            throw new IllegalArgumentException("参数错误：参数为空");
        }
        BeanCopier copier = getBeanCopier(source.getClass(), target.getClass());
        //考虑到性能，尽量不要用convert
//        copier.copy(source, target, convert);
        copier.copy(source, target, null);
    }
    
    public static <S, T> T convert(S source, Class<T> target) {
        BeanCopier copier = getBeanCopier(source.getClass(), target);
        try {
            T obj = target.newInstance();
            copier.copy(source, obj, null);
            return obj;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static <S, T> List<T> convertList(List<S> sourceList, Class<T> target) {
        List<T> result = new ArrayList<T>();
        if(sourceList == null || sourceList.size() == 0){
            return result;
        }
        
        for(S source : sourceList){
            T t = convert(source, target);
            result.add(t);
        }
        return result;
    }
    
    static class SameNameTypeConverter implements Converter {

		@Override
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
