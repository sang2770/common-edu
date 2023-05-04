package com.sang.common.captcha.service;

import com.sang.common.captcha.dto.CaptchaDTO;

import java.util.Map;

public interface CaptchaService {

    CaptchaDTO generate();

    Map<String, Object> generateRequired();

    boolean validate(String transactionId, String text);
}
