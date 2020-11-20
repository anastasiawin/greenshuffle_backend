package de.astradeni.greenshuffle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.astradeni.greenshuffle.models.Task;
import de.astradeni.greenshuffle.services.ITaskService;

@RestController
public class TaskController {

	@Autowired
	private ITaskService taskService;

	@GetMapping("/tasks")
	public Task getTasks() {
		return taskService.getRandomTask();
	}

}
