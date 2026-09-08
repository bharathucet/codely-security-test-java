package com.codely.securitytest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * INTENTIONALLY VULNERABLE TEST CASE.
 * Demonstrates logging personally identifiable information.
 */
public final class PiiLoggingExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(PiiLoggingExample.class);

    private PiiLoggingExample() {
    }

    public static void logCustomer(String name, String email, String phone) {
        // INTENTIONAL: PII is written directly to application logs.
        LOGGER.info("Customer profile name={}, email={}, phone={}", name, email, phone);
    }
}
