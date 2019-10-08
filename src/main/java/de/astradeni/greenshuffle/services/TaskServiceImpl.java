package de.astradeni.greenshuffle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.astradeni.greenshuffle.commons.IRandomInteger;
import de.astradeni.greenshuffle.exceptions.GeneralException;
import de.astradeni.greenshuffle.models.Task;
import de.astradeni.greenshuffle.repositories.TaskDao;

@Service
public class TaskServiceImpl implements ITaskService {

	@Autowired
	private TaskDao dao;

	@Autowired
	private IRandomInteger randomInteger;

	public Task getRandomTask() {
		List<Task> tasks = dao.findAll();
		if ((tasks == null) || (tasks.isEmpty())) {
			throw new GeneralException();
		}
		int index = randomInteger.nextInt(tasks.size());
		return tasks.get(index);

	}
}
