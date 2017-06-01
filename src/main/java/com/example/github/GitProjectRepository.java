package com.example.github;

import com.example.github.entity.GitProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GitProjectRepository extends JpaRepository<GitProject, Long> {

	List<GitProject> findByOwnerLogin(String login);
}
