package com.example.github;

import com.example.github.entity.GitProject;
import com.example.github.entity.GitUser;
import com.example.github.entity.dto.GitProjectDto;
import com.example.github.entity.dto.GitUserDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/github")
public class GitController {

	@Autowired
	private GitUserRepository userRepository;

	@Autowired
	protected GitProjectRepository projectRepository;

	@Autowired
	private GitClient gitClient;

	@GetMapping(value = "/users")
	public List<GitUserDto> getUsers() {
		List<GitUserDto> usersDtos;
		List<GitUser> users = userRepository.findAll();

		if (users.isEmpty()) {
			usersDtos = gitClient.getUsers();
			usersDtos.forEach(u -> {
				userRepository.save(u.toEntity());
			});

		} else {
			usersDtos = new ArrayList<>();
			users.forEach(u -> usersDtos.add(u.toDto()));
		}

		return usersDtos;
	}

	@GetMapping(value = "/users/{username}")
	public GitUserDto getUser(@PathVariable("username") String login) {
		Optional<GitUser> user = userRepository.findByLogin(login);
		if (!user.isPresent()) {
			GitUserDto userDto = gitClient.getUser(login);
			user = Optional.of(userRepository.save(userDto.toEntity()));
		}
		return user.get().toDto();
	}

	@GetMapping(value = "/users/{username}/repos")
	public List<GitProjectDto> getUserRepos(@PathVariable("username") String login) {
		List<GitProjectDto> projectsDto;

		GitUser owner = userRepository.findByLogin(login).orElseThrow(RuntimeException::new);

		List<GitProject> projects = projectRepository.findByOwnerLogin(login);
		if (projects.size() == 0) {
			projectsDto = gitClient.getUserRepos(login);
			projectsDto.forEach(p ->
					{
						GitProject project = p.toEntity();
						project.setOwner(owner);
						projects.add(project);
					}
			);
			projectRepository.save(projects);
		} else {
			projectsDto = new ArrayList<>();
			projects.forEach(p -> projectsDto.add(p.toDto()));
		}
		return projectsDto;
	}
}

