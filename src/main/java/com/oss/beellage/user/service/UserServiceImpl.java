package com.oss.beellage.user.service;

import static com.oss.beellage.user.exception.Message.USER_NOT_FOUND;

import com.oss.beellage.user.dto.JoinRequest;
import com.oss.beellage.user.dto.UserResponse;
import com.oss.beellage.user.exception.UserException;
import com.oss.beellage.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(JoinRequest joinRequest) {
        userRepository.save(joinRequest.toEntity(passwordEncoder));
    }

    @Override
    public UserResponse findById(Long id) {
        return UserResponse.from(userRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new UserException(
                        USER_NOT_FOUND,
                        HttpStatus.NOT_FOUND
                )));
    }
}
