package com.sang.common.captcha.repository;

import com.sang.common.captcha.utils.CaptchaConstants;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public interface CaptchaRepository {

    /**
     * @param key
     * @param data
     */
    @CachePut(cacheNames = CaptchaConstants.CACHE_CAPTCHA, key = "#key", unless = "#result == null")
    default String put(String key, String data) {
        return data;
    }

    /**
     * @param key
     * @return
     */
    @Cacheable(
            cacheNames = CaptchaConstants.CACHE_CAPTCHA,
            key = "#key",
            unless = "#result == null")
    default String getIfPresent(String key) {
        return null;
    }

    /**
     * @param key
     */
    @CacheEvict(cacheNames = CaptchaConstants.CACHE_CAPTCHA, key = "#key")
    default String invalidate(String key) {
        return key;
    }
}
