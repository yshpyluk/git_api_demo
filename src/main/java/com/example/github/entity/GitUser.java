package com.example.github.entity;

import com.example.github.entity.dto.GitUserDto;
import lombok.*;

import javax.persistence.*;

/**
 * Created by yshpyluk on 5/9/17.
 */
@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "git_users")
public class GitUser {

	@Id
	@GeneratedValue
	private long id;

	private String login;

	public GitUserDto toDto() {
		return GitUserDto.builder()
				.login(login)
				.build();
	}
}
