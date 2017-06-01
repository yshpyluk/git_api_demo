package com.example.github.entity.dto;

import com.example.github.entity.GitUser;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GitUserDto {
	public String login;

	public GitUser toEntity() {
		return GitUser.builder()
				.login(login)
				.build();
	}
}
