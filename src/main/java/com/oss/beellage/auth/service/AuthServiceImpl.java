package com.oss.beellage.auth.service;

import static com.oss.beellage.auth.constant.ConstantsUtils.ENCODING;
import static com.oss.beellage.auth.constant.ConstantsUtils.GMAIL_POSTFIX;
import static com.oss.beellage.auth.constant.ConstantsUtils.MAIL_AUTH_TITLE;
import static com.oss.beellage.auth.constant.ConstantsUtils.RANDOM_NUMBER_RANGE;
import static com.oss.beellage.auth.constant.ConstantsUtils.RANDOM_NUMBER_START;
import static com.oss.beellage.auth.constant.ConstantsUtils.createAuthMail;
import static com.oss.beellage.auth.constant.ConstantsUtils.createGoogleAuthMail;
import static com.oss.beellage.auth.exception.Message.EMAIL_ERROR_MESSAGE;
import static com.oss.beellage.auth.exception.Message.NICKNAME_ERROR_MESSAGE;
import static java.lang.Boolean.TRUE;

import com.oss.beellage.auth.collection.EmailCodeTable;
import com.oss.beellage.auth.collection.EmailCodeTable.EmailCode;
import com.oss.beellage.auth.dto.EmailAuthRequest;
import com.oss.beellage.auth.dto.EmailResponse;
import com.oss.beellage.auth.exception.AuthException;
import com.oss.beellage.user.User;
import com.oss.beellage.user.repository.UserRepository;
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
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

    //TODO: 디테일한 에러처리 해야됨

    private final JavaMailSender javaMailSender;
    private final UserRepository userRepository;
    private final EmailCodeTable emailCodeTable;

    @Override
    public void validateEmail(EmailAuthRequest emailAuthRequest) {
        String email = emailAuthRequest.email();

        if (userRepository.findByEmail(email).isPresent()) {
            throw new AuthException(EMAIL_ERROR_MESSAGE + email, HttpStatus.CONFLICT);
        }

        try {
            String code = sendMail(email);
            emailCodeTable.add(email, new EmailCode(code, LocalDateTime.now()));
        } catch (MessagingException messagingException) {
            throw new AuthException(
                    EMAIL_ERROR_MESSAGE,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    public void validateEmailCode(String email, String code) {

        if (!emailCodeTable.contains(email)) {
            throw new AuthException(
                    EMAIL_ERROR_MESSAGE,
                    HttpStatus.NOT_FOUND
            );
        }

        if (emailCodeTable.isTimeout(email)) {
            throw new AuthException(
                    EMAIL_ERROR_MESSAGE,
                    HttpStatus.REQUEST_TIMEOUT
            );
        }

        if (!emailCodeTable.isValidCode(email, code)) {
            throw new AuthException(
                    EMAIL_ERROR_MESSAGE,
                    HttpStatus.UNAUTHORIZED
            );
        }
    }

    @Override
    public void validateNickname(String nickname) {
        userRepository.findByNickname(nickname)
                .ifPresent(user -> {
                            throw new AuthException(
                                    NICKNAME_ERROR_MESSAGE,
                                    HttpStatus.CONFLICT
                            );
                        }
                );
    }

    @Override
    public EmailResponse findEmailByNickname(String nickname) {
        User user = userRepository.findByNickname(nickname)
                .orElseThrow(() ->
                        new AuthException(
                                NICKNAME_ERROR_MESSAGE,
                                HttpStatus.NOT_FOUND
                        )
                );

        return new EmailResponse(user.getEmail());
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

        helper.setText(htmlContent, TRUE);
        javaMailSender.send(message);

        return code;
    }

    private String generateRandomCode() {
        Random random = new SecureRandom();
        int randomNumber = RANDOM_NUMBER_START + random.nextInt(RANDOM_NUMBER_RANGE);
        return String.valueOf(randomNumber);
    }
}