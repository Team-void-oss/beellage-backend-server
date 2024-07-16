package com.oss.beellage.auth.service;

import com.oss.beellage.auth.collection.EmailCodeTable;
import com.oss.beellage.auth.collection.EmailCodeTable.EmailCode;
import com.oss.beellage.auth.dto.EmailAuthRequest;
import com.oss.beellage.auth.exception.AuthException;
import com.oss.beellage.auth.repository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.time.LocalDateTime;
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
    private final EmailCodeTable emailCodeTable;

    @Override
    public void validateEmail(EmailAuthRequest emailAuthRequest) {
        String email = emailAuthRequest.email();

        if (userRepository.findByEmail(email).isPresent()) {
            throw new AuthException("A user with " + email + " already exists", HttpStatus.CONFLICT);
        }

        try {
            String code = sendMail(email);
            emailCodeTable.add(email, new EmailCode(code, LocalDateTime.now()));
        } catch (MessagingException messagingException) {
            System.out.println("메일전송 에러");
        }
    }

    @Override
    public void validateEmailCode(String email, String code) {

        if (!emailCodeTable.contains(email)) {
            throw new AuthException(
                    "인증테이블에 존재하지 않음",
                    HttpStatus.NOT_FOUND
            );
        }

        if (emailCodeTable.isTimeout(email)) {
            throw new AuthException(
                    "인증 코드 시간이 유효하지 않음",
                    HttpStatus.REQUEST_TIMEOUT
            );
        }

        if (!emailCodeTable.isValidCode(email, code)) {
            throw new AuthException(
                    "인증 코드가 유효하지 않음",
                    HttpStatus.UNAUTHORIZED
            );
        }
    }


    private String sendMail(String email) throws MessagingException {
        UUID code = UUID.randomUUID();
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(email);
        // 귀꿀쉐 ㄱㄱ
        helper.setSubject("이메일 인증");
        helper.setText(code.toString(), true);

        javaMailSender.send(message);

        return code.toString();
    }
}
