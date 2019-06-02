package de.astradeni.greenshuffle.test.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import de.astradeni.greenshuffle.commons.IRandomInteger;
import de.astradeni.greenshuffle.exceptions.GeneralException;
import de.astradeni.greenshuffle.models.Task;
import de.astradeni.greenshuffle.repositories.TaskDao;
import de.astradeni.greenshuffle.services.TaskServiceImpl;

@RunWith(SpringRunner.class)
public class ServiceTest {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public TaskServiceImpl taskService() {
			return new TaskServiceImpl();
		}
	}

	@Autowired
	private TaskServiceImpl taskService;

	@MockBean
	private TaskDao dao;

	@MockBean
	private IRandomInteger randomInteger;

	@Test
	public void givenList_whenGetRandomTask_thenReturnTask() throws Exception {

		Task task = new Task();
		task.setId(3l);
		task.setName("Pflanzen giessen");

		Task task1 = new Task();
		task1.setId(2l);
		task1.setName("Jemandem helfen");

		List<Task> list = new ArrayList<>();
		list.add(task);
		list.add(task1);

		Mockito.when(dao.findAll()).thenReturn(list);

		Mockito.when(randomInteger.nextInt(2)).thenReturn(1);

		Task istTask = taskService.getRandomTask();
		assertEquals("Assert Task Name", task1.getName(), istTask.getName());
		assertEquals("Assert Task Id", task1.getId(), istTask.getId());
	}

	@Test(expected = GeneralException.class)
	public void givenEmptyList_whenGetRandomTask_thenReturnException() throws Exception {

		Mockito.when(dao.findAll()).thenReturn(new ArrayList<Task>());
		taskService.getRandomTask();
	}

	@Test(expected = GeneralException.class)
	public void givenNullList_whenGetRandomTask_thenReturnNull() throws Exception {

		Mockito.when(dao.findAll()).thenReturn(null);
		taskService.getRandomTask();
	}
}
