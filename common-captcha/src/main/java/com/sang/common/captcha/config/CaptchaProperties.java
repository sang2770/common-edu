package com.sang.common.captcha.config;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Data
@Component
@ConfigurationProperties(prefix = "captcha.config")
public class CaptchaProperties {
    private String imageWidth;
    private String imageHeight;
    private String textProducerCharString;
    private String textProducerCharLength;
    private String textProducerFontSize;
    private String textProducerCharSpace;
    private String textProducerFontNames;
    private String textProducerFontColor;
    private String backgroundClearFrom;
    private String backgroundClearTo;
    private String useBorder;
    private String headerTransactionId;

    @Bean
    public Producer createCaptchaProducer() {
        DefaultKaptcha captcha = new DefaultKaptcha();

        Properties properties = new Properties();

        properties.put(Constants.KAPTCHA_IMAGE_HEIGHT, imageHeight);
        properties.put(Constants.KAPTCHA_IMAGE_WIDTH, imageWidth);
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, textProducerCharLength);
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, textProducerCharString);
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, textProducerFontSize);
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, textProducerCharSpace);
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, textProducerFontNames);
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, textProducerFontColor);
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_FROM, backgroundClearFrom);
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_TO, backgroundClearTo);
        properties.put(Constants.KAPTCHA_BORDER, useBorder);

        properties.put(Constants.KAPTCHA_NOISE_COLOR, textProducerFontColor);

        captcha.setConfig(new Config(properties));

        return captcha;
    }
}
