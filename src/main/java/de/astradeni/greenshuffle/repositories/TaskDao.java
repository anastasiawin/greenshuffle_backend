package de.astradeni.greenshuffle.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.astradeni.greenshuffle.models.Task;

public interface TaskDao extends CrudRepository<Task, Long> {

	public List<Task> findAll();

}
