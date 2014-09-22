package cqrs.todo.domain;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import cqrs.todo.repository.TODOListRepository;
import cqrs.todo.service.ToDoListService;

public class ToDoListTest {

	private TODOListRepository todoRepository = new TODOListRepository();
	private ToDoListService todoListService;

	@Before
	public void setUp() {
		todoListService = new ToDoListService(todoRepository);
	}
	
	@Test
	public void testCreateTodoList() {
		//When
		todoListService.create("MyToDoList");
		
		//Then		
		List<String> toDoList = todoListService.getToDoListTitles("MyToDoList");
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
	
	@Test
	public void testRemoveToDo() {
		//Given
		todoListService.create("MyToDoList");
		
		//When
		todoListService.removeToDo("MyToDoList", "Start Ekito Presentation");
		
		//Then
		List<String> toDoTitles = todoListService.getToDoTitles("MyToDoList");
		assertThat(toDoTitles).isNotNull().isEmpty();;
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
		assertThat(toDoTitles).isNotNull().containsOnly("Start Ekito Presentation");
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
		assertThat(toDoTitles).isNotNull().containsOnly("Start Ekito Presentation");
	}
}
