package cqrs.todo.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cqrs.todo.repository.TODOListRepository;
import cqrs.todo.service.TODOListService;

public class ToDoListTest {

	private TODOListRepository todoRepository = new TODOListRepository();
	private TODOListService todoListService;

	@Before
	public void setUp() {
		todoListService = new TODOListService(todoRepository);
	}
	
	@Test
	public void testCreateTodoList() {
		//When
		todoListService.create("MyToDoList");
		
		//Then
		List<String> toDoList = todoListService.getToDoListTitles("MyToDoList");
		assertNotNull(toDoList);
		assertTrue(toDoList.contains("MyToDoList"));
	}
	
	@Test
	public void testAddToDo() {
		//Given
		todoListService.create("MyToDoList");
		
		//When
		todoListService.addToDo("MyToDoList", "Start Ekito Presentation");
		
		//Then
		List<String> toDoTitles = todoListService.getToDoTitles("MyToDoList");
		assertNotNull(toDoTitles);
		assertTrue(toDoTitles.contains("Start Ekito Presentation"));
	}
	
	@Test
	public void testRemoveToDo() {
		//Given
		todoListService.create("MyToDoList");
		
		//When
		todoListService.removeToDo("MyToDoList", "Start Ekito Presentation");
		
		//Then
		List<String> toDoTitles = todoListService.getToDoTitles("MyToDoList");
		assertNotNull(toDoTitles);
		assertTrue(toDoTitles.isEmpty());
	}
	
	@Test
	public void testStartToDo() {
		//Given
		todoListService.create("MyToDoList");
		todoListService.addToDo("MyToDoList", "Start Ekito Presentation");
				
		//When
		todoListService.startToDo("MyToDoList", "Start Ekito Presentation");
		
		//Then
		List<String> toDoTitles = todoListService.getStartedToDoTitles("MyToDoList");
		assertNotNull(toDoTitles);
		assertTrue(toDoTitles.contains("Start Ekito Presentation"));
	}
	
	@Test
	public void testCompleteToDo() {
		//Given
		todoListService.create("MyToDoList");
		todoListService.addToDo("MyToDoList", "Start Ekito Presentation");
				
		//When
		todoListService.completeToDo("MyToDoList", "Start Ekito Presentation");
		
		//Then
		List<String> toDoTitles = todoListService.getCompletedToDoTitles("MyToDoList");
		assertNotNull(toDoTitles);
		assertTrue(toDoTitles.contains("Start Ekito Presentation"));
	}
}
