package de.astradeni.greenshuffle.services;

import de.astradeni.greenshuffle.exceptions.GeneralException;
import de.astradeni.greenshuffle.models.Task;

public interface ITaskService {
	public Task getRandomTask() throws GeneralException;
}
