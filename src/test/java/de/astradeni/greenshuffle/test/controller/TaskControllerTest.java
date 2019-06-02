package de.astradeni.greenshuffle.test.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import de.astradeni.greenshuffle.controller.TaskController;
import de.astradeni.greenshuffle.models.Task;
import de.astradeni.greenshuffle.services.ITaskService;

@WebMvcTest(TaskController.class)
@RunWith(SpringRunner.class)
public class TaskControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ITaskService taskService;

	@Test
	public void givenTasks_whenGetTasks_thenReturnTasks() throws Exception {

		Task task = new Task();
		task.setId(3l);
		task.setName("Pflanzen giessen");
		Mockito.when(taskService.getRandomTask()).thenReturn(task);
		MvcResult result = mvc.perform(get("/tasks")).andExpect(status().isOk()).andReturn();
		assertEquals("Tasks should return", "{\"id\":3,\"name\":\"Pflanzen giessen\"}",
				result.getResponse().getContentAsString());
	}

}
