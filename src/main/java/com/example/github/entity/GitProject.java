package com.example.github.entity;

import com.example.github.entity.dto.GitProjectDto;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "git_projects")
public class GitProject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String full_name;

	@ManyToOne
	private GitUser owner;

	public GitProjectDto toDto() {
		return GitProjectDto.builder()
				.name(name)
				.full_name(full_name)
				.owner(owner)
				.build();
	}
}
