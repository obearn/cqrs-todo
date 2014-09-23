package cqrs.todo.domain;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import cqrs.todo.queries.ToDoListQueriesHandler;
import cqrs.todo.repository.QueriesRepository;
import cqrs.todo.repository.TODOListRepository;
import cqrs.todo.service.ToDoListService;
import cqrs.todo.service.ToDoQueryService;

public class ToDoListTest {

	private TODOListRepository todoRepository = new TODOListRepository();
	private ToDoListService todoListService;
	private ToDoQueryService todoQueryService;

	@Before
	public void setUp() {
		QueriesRepository queriesRepository = new QueriesRepository();
		todoQueryService = new ToDoQueryService(queriesRepository);
		ToDoListQueriesHandler todoListTitlesHandler = new ToDoListQueriesHandler(queriesRepository);
		todoListService = new ToDoListService(todoRepository, todoListTitlesHandler);
	}
	
	@Test
	public void testCreateTodoList() {
		//When
		todoListService.create("MyToDoList");
		
		//Then		
		List<String> toDoList = todoQueryService.getToDoTitles("MyToDoList");
		assertThat(toDoList).isNotNull().isEmpty();
	}
	
	@Test
	public void testAddToDo() {
		//Given
		todoListService.create("MyToDoList");
		
		//When
		todoListService.addToDo("MyToDoList", "Start Ekito Presentation");
		
		//Then
		List<String> toDoTitles = todoQueryService.getToDoTitles("MyToDoList");
		assertThat(toDoTitles).isNotNull().containsOnly("Start Ekito Presentation");
	}
	
	@Test
	public void testRemoveToDo() {
		//Given
		todoListService.create("MyToDoList");
		
		//When
		todoListService.removeToDo("MyToDoList", "Start Ekito Presentation");
		
		//Then
		List<String> toDoTitles = todoQueryService.getToDoTitles("MyToDoList");
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
		List<String> toDoTitles = todoQueryService.getStartedToDoTitles("MyToDoList");
		assertThat(toDoTitles).isNotNull().containsOnly("Start Ekito Presentation");
	}
	
	@Test
	public void testCompleteToDo() {
		//Given
		todoListService.create("MyToDoList");
		todoListService.addToDo("MyToDoList", "Start Ekito Presentation");
		todoListService.startToDo("MyToDoList", "Start Ekito Presentation");
				
		//When
		todoListService.completeToDo("MyToDoList", "Start Ekito Presentation");
		
		//Then
		List<String> completedTodos = todoQueryService.getCompletedToDoTitles("MyToDoList");
		assertThat(completedTodos).isNotNull().containsOnly("Start Ekito Presentation");
		List<String> startedTodos = todoQueryService.getStartedToDoTitles("MyToDoList");
		assertThat(startedTodos).isNotNull().isEmpty();
	}
}
