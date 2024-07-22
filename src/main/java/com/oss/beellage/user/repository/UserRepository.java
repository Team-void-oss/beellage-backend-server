package com.oss.beellage.user.repository;

import com.oss.beellage.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
