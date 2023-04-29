package com.sang.common.captcha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CaptchaDTO {

    private String transactionId;

    private String captcha;
}
