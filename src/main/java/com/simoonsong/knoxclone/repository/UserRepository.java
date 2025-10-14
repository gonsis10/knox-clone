package com.simoonsong.knoxclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simoonsong.knoxclone.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
