package com.example.github;

import com.example.github.entity.GitUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GitUserRepository extends JpaRepository<GitUser, Long> {

	Optional<GitUser> findByLogin(String login);
}
