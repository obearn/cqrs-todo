package cqrs.todo.service;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cqrs.todo.query.ReadModelHandler;
import cqrs.todo.repository.ReadModelRepository;
import cqrs.todo.repository.ToDoListRepository;
import static org.assertj.core.api.Assertions.assertThat;

public class ToDoListTest {

	private ToDoListService todoListService;
	private ToDoListQueries todoListQueries;

	@Before
	public void setUp() {
		ReadModelRepository readModelRepository = new ReadModelRepository();
		ReadModelHandler readModelHandler = new ReadModelHandler(readModelRepository);
		todoListQueries = new ToDoListQueries(readModelRepository);
		todoListService = new ToDoListService(new ToDoListRepository(), readModelHandler );
	}
	
	@Test
	public void testCreateTodoList() {
		//When
		todoListService.create("MyToDoList");
		
		//Then		
		List<String> toDoList = todoListQueries.getToDoTitles("MyToDoList");
		assertThat(toDoList).isNotNull().isEmpty();
	}
	
	@Test
	public void testAddToDo() {
		//Given
		todoListService.create("MyToDoList");
		
		//When
		todoListService.addToDo("MyToDoList", "Start Ekito Presentation");
		
		//Then
		List<String> toDoTitles = todoListQueries.getToDoTitles("MyToDoList");
		assertThat(toDoTitles).isNotNull().containsOnly("Start Ekito Presentation");
	}
	
	@Test
	public void testStartedToDo() {
		//Given
		todoListService.create("MyToDoList");
		todoListService.addToDo("MyToDoList", "Start Ekito Presentation");
		
		//When
		todoListService.startToDo("MyToDoList", "Start Ekito Presentation");
				
		//Then
		List<String> toDoTitles = todoListQueries.getStartedToDoTitles("MyToDoList");
		assertThat(toDoTitles).isNotNull().containsOnly("Start Ekito Presentation");
	}
	
}
