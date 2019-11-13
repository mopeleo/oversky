package org.oversky.base.service;

import java.util.HashMap;
import java.util.Map;

public class BaseResMapDto<K, V> extends BaseResDto{

	private static final long serialVersionUID = 1L;
	
	private Map<K, V> results = new HashMap<>();
	
	public Map<K, V> getResults() {
		return results;
	}
	public void setResults(Map<K, V> results) {
		this.results = results;
	}
	public void putMap(K key, V val) {
		results.put(key, val);
	}
	public V get(K key) {
		return results.get(key);
	}
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
        return sb.toString();
	}
}
