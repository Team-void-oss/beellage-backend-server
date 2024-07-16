package com.oss.beellage.auth.service;

import com.oss.beellage.auth.dto.EmailAuthRequest;
import com.oss.beellage.auth.exception.AuthException;
import com.oss.beellage.auth.repository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JavaMailSender javaMailSender;
    private final UserRepository userRepository;
    private final HashMap<String, EmailCode> emailCodeTable = new HashMap<>();

    @Override
    public void validateEmail(EmailAuthRequest emailAuthRequest) {
        String email = emailAuthRequest.email();

        if (userRepository.findByEmail(email).isPresent()) {
            throw new AuthException("A user with " + email + " already exists", HttpStatus.CONFLICT);
        }

        try {
            String code = sendMail(email);
            emailCodeTable.put(email, new EmailCode(code, LocalDateTime.now()));
        } catch (MessagingException messagingException) {
            System.out.println("메일전송 에러");
        }
    }
    // 확인 메서드에서 3분지난 코드들 모두 삭제
    // 이메일 키 있는지확인, 코드 맞는지 확인


    private String sendMail(String email) throws MessagingException {
        UUID code = UUID.randomUUID();
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(email);
        helper.setSubject("이메일 인증");
        helper.setText(code.toString(), true);

        javaMailSender.send(message);

        return code.toString();
    }

    private record EmailCode(
            String code,
            LocalDateTime time
    ) {
    }
}
