package com.simoonsong.knoxclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simoonsong.knoxclone.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
