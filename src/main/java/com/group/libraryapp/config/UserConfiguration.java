package com.group.libraryapp.config;

import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserConfiguration {

    public UserJdbcRepository userRepository(JdbcTemplate jdbcTemplate) {
        return new UserJdbcRepository(jdbcTemplate);
    }
}
