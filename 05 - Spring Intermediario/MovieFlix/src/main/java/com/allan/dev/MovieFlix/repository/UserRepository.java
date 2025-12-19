package com.allan.dev.MovieFlix.repository;

import com.allan.dev.MovieFlix.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}