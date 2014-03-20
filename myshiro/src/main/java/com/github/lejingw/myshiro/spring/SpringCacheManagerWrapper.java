package com.github.lejingw.myshiro.spring;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sf.ehcache.Ehcache;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.cache.support.SimpleValueWrapper;

/**
 * 包装Spring cache抽象
 * @author wanglj
 */
public class SpringCacheManagerWrapper implements CacheManager{

	private org.springframework.cache.CacheManager targetCacheManager;

	public void setTargetCacheManager(org.springframework.cache.CacheManager targetCacheManager) {
		this.targetCacheManager = targetCacheManager;
	}

	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		org.springframework.cache.Cache cache = targetCacheManager.getCache(name);
		return new SpringCacheWrapper(cache);
	}
	
	private class SpringCacheWrapper implements Cache{
		private org.springframework.cache.Cache cache;
		
		public SpringCacheWrapper(org.springframework.cache.Cache cache){
			this.cache = cache;
		}

		@Override
		public Object get(Object key) throws CacheException {
			Object value = cache.get(key);
			if(value instanceof SimpleValueWrapper){
				return ((SimpleValueWrapper)value).get();
			}
			return value;
		}

		@Override
		public Object put(Object key, Object value) throws CacheException {
			cache.put(key, value);
			return value;
		}

		@Override
		public Object remove(Object key) throws CacheException {
			cache.evict(key);
			return null;
		}

		@Override
		public void clear() throws CacheException {
			cache.clear();
		}

		@Override
		public int size() {
			if(cache.getNativeCache() instanceof Ehcache){
				Ehcache ehcache = (Ehcache) cache.getNativeCache();
				return ehcache.getSize();
			}
			throw new UnsupportedOperationException("invoke spring cache abstract size method not supported");
		}
		

		@Override
		public Set keys() {
			if(cache.getNativeCache() instanceof Ehcache){
				Ehcache ehcache = (Ehcache) cache.getNativeCache();
				return new HashSet(ehcache.getKeys());
			}
			throw new UnsupportedOperationException("invoke spring cache abstract keys method not supported");
		}

		@Override
		public Collection values() {
			if(cache.getNativeCache() instanceof Ehcache){
				Ehcache ehcache = (Ehcache) cache.getNativeCache();
				List keys = ehcache.getKeys();
				if(CollectionUtils.isNotEmpty(keys)){
					List values = new ArrayList();
					for(Object key : keys){
						Object value = get(key);
						if(null != value){
							values.add(value);
						}
					}
					return Collections.unmodifiableList(values);
				}else{
					return Collections.emptyList();
				}
			}
			throw new UnsupportedOperationException("invoke spring cache abstract values method not supported");
		}
		
	}
}
