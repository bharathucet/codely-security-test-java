package com.codely.securitytest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * INTENTIONALLY VULNERABLE TEST CASE.
 * Do not use this pattern in production code.
 */
public final class SqlInjectionExample {

    private SqlInjectionExample() {
    }

    public static String findUser(Connection connection, String username) throws SQLException {
        // INTENTIONAL: untrusted input is concatenated into SQL.
        String sql = "SELECT id, username FROM users WHERE username = '" + username + "'";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getString("username");
            }
            return null;
        }
    }
}
