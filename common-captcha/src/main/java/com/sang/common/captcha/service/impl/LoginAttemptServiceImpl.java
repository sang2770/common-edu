package com.sang.common.captcha.service.impl;

import com.sang.common.captcha.repository.LoginFailedRepository;
import com.sang.common.captcha.service.LoginAttemptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginAttemptServiceImpl implements LoginAttemptService {

    private final LoginFailedRepository loginFailedRepository;

    @Value("${security.login.max-attempt-time:2}")
    private int loginMaxAttemptTime;

    @Override
    public void loginSucceeded(String key) {
        this.loginFailedRepository.invalidate(key);
    }

    @Override
    public void loginFailed(String key) {
        int attempts = this.getAttempts(key);
        attempts++;
        log.warn("User with key {} login failure for {} times", key, attempts);
        this.loginFailedRepository.put(key, attempts);
    }

    @Override
    public boolean isRequiredCaptcha(String key) {
        return this.getAttempts(key) > loginMaxAttemptTime;
    }

    private int getAttempts(String key) {
        Integer attempts = this.loginFailedRepository.getIfPresent(key);
        return Objects.nonNull(attempts) ? attempts : 0;
    }
}
