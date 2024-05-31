package com.henrique.auth_test.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
