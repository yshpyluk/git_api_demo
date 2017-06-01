package com.example.github;

import com.example.github.entity.dto.GitProjectDto;
import com.example.github.entity.dto.GitUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class GitClient {

	private RestTemplate restTemplate;

	public GitClient() {
		restTemplate = new RestTemplate();
	}

	public List<GitUserDto> getUsers() {
		ResponseEntity<GitUserDto[]> responseEntity = restTemplate.getForEntity("https://api.github.com/users", GitUserDto[].class);
		return Arrays.asList(responseEntity.getBody());
	}

	public GitUserDto getUser(String login) {
		ResponseEntity<GitUserDto> responseEntity = restTemplate.getForEntity("https://api.github.com/users/{login}", GitUserDto.class, login);
		return responseEntity.getBody();
	}

	public List<GitProjectDto> getUserRepos(String login) {
		ResponseEntity<GitProjectDto[]> responseEntity = restTemplate.getForEntity("https://api.github.com/users/{login}/repos", GitProjectDto[].class, login);
		return Arrays.asList(responseEntity.getBody());
	}
}
