package com.oss.beellage.auth.collection;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import org.springframework.stereotype.Component;

@Component
public class EmailCodeTable {
    private static final Integer LIMIT_TIME = 3;
    private final HashMap<String, EmailCode> emailCodeTable = new HashMap<>();

    public void add(String email, EmailCode emailCode) {
        emailCodeTable.put(email, emailCode);
    }

    public boolean contains(String email) {
        return emailCodeTable.containsKey(email);
    }

    public boolean isTimeout(String email) {
        // 여기서 시간 지난 데이터들모두 삭제

        return Duration.between(
                emailCodeTable.get(email).time(),
                LocalDateTime.now()).toMinutes() >= LIMIT_TIME;
    }

    public boolean isValidCode(String email, String code) {
        return emailCodeTable.get(email).code().equals(code);
    }

    public record EmailCode(
            String code,
            LocalDateTime time
    ) {
    }
}
