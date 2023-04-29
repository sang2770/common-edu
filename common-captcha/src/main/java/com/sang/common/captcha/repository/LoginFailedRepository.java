package com.sang.common.captcha.repository;

import com.sang.common.captcha.utils.CaptchaConstants;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public interface LoginFailedRepository {

    /**
     * @param key
     * @param data
     */
    @CachePut(
            cacheNames = CaptchaConstants.CACHE_LOGIN_FAILED,
            key = "#key",
            unless = "#result == null")
    default Integer put(String key, Integer value) {
        return value;
    }

    /**
     * @param key
     * @return
     */
    @Cacheable(
            cacheNames = CaptchaConstants.CACHE_LOGIN_FAILED,
            key = "#key",
            unless = "#result == null")
    default Integer getIfPresent(String key) {
        return null;
    }

    /**
     * @param key
     */
    @CacheEvict(cacheNames = CaptchaConstants.CACHE_LOGIN_FAILED, key = "#key")
    default String invalidate(String key) {
        return key;
    }
}
