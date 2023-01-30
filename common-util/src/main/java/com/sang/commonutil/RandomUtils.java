package com.sang.commonutil;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public final class RandomUtils {
    private static final int SEC_COUNT = 100;
    private static final int DEF_COUNT = 20;
    private static final int SALT_COUNT = 10;
    private static final String ID_DATETIME_PATTERN = "yyyyMMddSSSHHssmm";
    private static final AtomicLong LAST_TIME_MS = new AtomicLong();
    private static final Random RANDOM = new SecureRandom();

    private RandomUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String generateSecret() {
        return RandomStringUtils.randomAlphanumeric(SEC_COUNT);
    }

    public static String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(DEF_COUNT);
    }


    public static String generateActivationKey() {
        return RandomStringUtils.randomNumeric(DEF_COUNT);
    }

    public static int generateRandom(int size) {
        return RANDOM.nextInt(size);
    }

    public static String generateResetKey() {
        return RandomStringUtils.randomNumeric(DEF_COUNT);
    }

}
