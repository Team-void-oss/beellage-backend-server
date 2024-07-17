package com.oss.beellage.user.repository;

import com.oss.beellage.user.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByNickname(String nickname);

    Optional<User> findByIdAndDeletedAtIsNull(Long id);
}
