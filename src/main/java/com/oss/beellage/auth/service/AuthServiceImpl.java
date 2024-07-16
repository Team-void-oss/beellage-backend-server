package com.oss.beellage.auth.service;

import static com.oss.beellage.auth.constant.ConstantsUtils.ENCODING;
import static com.oss.beellage.auth.constant.ConstantsUtils.GMAIL_POSTFIX;
import static com.oss.beellage.auth.constant.ConstantsUtils.MAIL_AUTH_TITLE;
import static com.oss.beellage.auth.constant.ConstantsUtils.RANDOM_NUMBER_RANGE;
import static com.oss.beellage.auth.constant.ConstantsUtils.RANDOM_NUMBER_START;
import static com.oss.beellage.auth.constant.ConstantsUtils.createAuthMail;
import static com.oss.beellage.auth.constant.ConstantsUtils.createGoogleAuthMail;
import static com.oss.beellage.auth.exception.Message.AUTH_ERROR_MESSAGE;
import static java.lang.Boolean.TRUE;

import com.oss.beellage.auth.collection.EmailCodeTable;
import com.oss.beellage.auth.collection.EmailCodeTable.EmailCode;
import com.oss.beellage.auth.dto.EmailAuthRequest;
import com.oss.beellage.auth.exception.AuthException;
import com.oss.beellage.auth.repository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Random;
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
            throw new AuthException(AUTH_ERROR_MESSAGE + email, HttpStatus.CONFLICT);
        }

        try {
            String code = sendMail(email);
            emailCodeTable.add(email, new EmailCode(code, LocalDateTime.now()));
        } catch (MessagingException messagingException) {
            throw new AuthException(
                    AUTH_ERROR_MESSAGE,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    public void validateEmailCode(String email, String code) {

        if (!emailCodeTable.contains(email)) {
            throw new AuthException(
                    AUTH_ERROR_MESSAGE,
                    HttpStatus.NOT_FOUND
            );
        }

        if (emailCodeTable.isTimeout(email)) {
            throw new AuthException(
                    AUTH_ERROR_MESSAGE,
                    HttpStatus.REQUEST_TIMEOUT
            );
        }

        if (!emailCodeTable.isValidCode(email, code)) {
            throw new AuthException(
                    AUTH_ERROR_MESSAGE,
                    HttpStatus.UNAUTHORIZED
            );
        }
    }

    private String sendMail(String email) throws MessagingException {
        String code = generateRandomCode();
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, TRUE, ENCODING);

        helper.setTo(email);
        helper.setSubject(MAIL_AUTH_TITLE);

        String htmlContent;
        if (email.contains(GMAIL_POSTFIX)) {
            htmlContent = createGoogleAuthMail((code));
        } else {
            htmlContent = createAuthMail((code));
        }

        helper.setText(htmlContent, true);
        javaMailSender.send(message);

        return code;
    }

    private String generateRandomCode() {
        Random random = new SecureRandom();
        int randomNumber = RANDOM_NUMBER_START + random.nextInt(RANDOM_NUMBER_RANGE);
        return String.valueOf(randomNumber);
    }
}
