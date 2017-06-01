package com.example.github.entity.dto;

import com.example.github.entity.GitProject;
import com.example.github.entity.GitUser;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GitProjectDto {

	private String name;
	private String full_name;
	private GitUser owner;

	public GitProject toEntity() {
		return GitProject.builder()
				.name(name)
				.full_name(full_name)
				.owner(owner)
				.build();
	}
}
