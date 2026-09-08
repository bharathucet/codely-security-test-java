package com.codely.securitytest;

/**
 * INTENTIONALLY VULNERABLE TEST CASE.
 * The value below is a fake, non-functional fixture secret and must never be used as a real credential.
 */
public final class HardcodedSecretExample {

    // INTENTIONAL: fake credential embedded directly in source code.
    private static final String API_KEY = "codely-test-secret-DO-NOT-USE-123456789";

    private HardcodedSecretExample() {
    }

    public static String getApiKeyForTestOnly() {
        return API_KEY;
    }
}
