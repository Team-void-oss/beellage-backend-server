package com.oss.beellage.user_haisley.repository;

import com.oss.beellage.user_haisley.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
