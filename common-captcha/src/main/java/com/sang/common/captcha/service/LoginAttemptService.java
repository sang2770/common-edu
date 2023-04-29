package com.sang.common.captcha.service;

public interface LoginAttemptService {
    void loginSucceeded(String key);

    void loginFailed(String key);

    boolean isRequiredCaptcha(String key);
}
