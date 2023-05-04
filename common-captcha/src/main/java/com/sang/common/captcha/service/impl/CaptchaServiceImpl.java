package com.sang.common.captcha.service.impl;

import com.google.code.kaptcha.Producer;
import com.sang.common.captcha.dto.CaptchaDTO;
import com.sang.common.captcha.repository.CaptchaRepository;
import com.sang.common.captcha.service.CaptchaService;
import com.sang.common.captcha.utils.CaptchaConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CaptchaServiceImpl implements CaptchaService {
    private final Producer captchaProducer;
    private final PasswordEncoder encoder;
    private final CaptchaRepository captchaRepository;

    @Override
    public CaptchaDTO generate() {
        String capText = captchaProducer.createText();
        String transactionId = this.encoder.encode(capText);
        captchaRepository.put(transactionId, capText);
        return new CaptchaDTO(transactionId, this.getImageSrcBase64String(capText));
    }

    @Override
    public Map<String, Object> generateRequired() {
        String capText = captchaProducer.createText();

        String transactionId = this.encoder.encode(capText);
        captchaRepository.put(transactionId, capText);
        Map<String, Object> data = new HashMap<>();
        data.put(CaptchaConstants.CAPTCHA, this.getImageSrcBase64String(capText));
        data.put(CaptchaConstants.TRANSACTION_ID, transactionId);
        data.put(CaptchaConstants.CAPTCHA_REQUIRED, Boolean.TRUE);
        return data;
    }

    @Override
    public boolean validate(String transactionId, String text) {
        String textInCache = captchaRepository.getIfPresent(transactionId);
        if (Objects.nonNull(textInCache) && textInCache.equals(text)) {
            // invalidate captcha - xóa cache
            captchaRepository.invalidate(transactionId);
            return true;
        }
        return false;
    }

    public String getImageSrcBase64String(String capText) {
        BufferedImage bi = captchaProducer.createImage(capText);
        StringBuilder sb = new StringBuilder("data:image");
        sb.append("/");
        sb.append(CaptchaConstants.FILE_IMAGE_EXTENSION);
        sb.append(";base64,");
        sb.append(encodeToString(bi, CaptchaConstants.FILE_IMAGE_EXTENSION));
        return sb.toString();
    }

    public String encodeToString(BufferedImage image, String type) {
        String imgStr = "";

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);

            byte[] imageBytes = bos.toByteArray();

            imgStr = Base64.getEncoder().encodeToString(imageBytes);

            bos.close();
        } catch (IOException ioe) {
            log.error("Encode image to string fail: ", ioe);
        }
        return imgStr;
    }
}
