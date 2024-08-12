package com.oss.beellage.auth.repository;

import com.oss.beellage.auth.RefreshToken;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    void deleteByUserId(Long userId);

    Optional<RefreshToken> findByUserId(Long userId);
}
