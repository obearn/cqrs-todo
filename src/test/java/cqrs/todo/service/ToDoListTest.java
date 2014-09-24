package cqrs.todo.service;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cqrs.todo.domain.ToDoListService;
import static org.assertj.core.api.Assertions.assertThat;

public class ToDoListTest {

	private ToDoListService todoListService;

	@Before
	public void setUp() {
		todoListService = new ToDoListService();
	}
	
	@Test
	public void testCreateTodoList() {
		//When
		todoListService.create("MyToDoList");
		
		//Then		
		List<String> toDoList = todoListService.getToDoTitles("MyToDoList");
		assertThat(toDoList).isNotNull().isEmpty();
	}
	
	@Test
	public void testAddToDo() {
		//Given
		todoListService.create("MyToDoList");
		
		//When
		todoListService.addToDo("MyToDoList", "Start Ekito Presentation");
		
		//Then
		List<String> toDoTitles = todoListService.getToDoTitles("MyToDoList");
		assertThat(toDoTitles).isNotNull().containsOnly("Start Ekito Presentation");
	}
	
}
