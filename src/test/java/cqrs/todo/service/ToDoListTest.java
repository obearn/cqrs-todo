package cqrs.todo.service;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.eventbus.EventBus;

import cqrs.todo.commands.AddTodoCommand;
import cqrs.todo.commands.CreateTodoListCommand;
import cqrs.todo.commands.StartTodoCommand;
import cqrs.todo.infrastructure.LoggerEventHandler;
import cqrs.todo.query.ReadModelHandler;
import cqrs.todo.repository.ReadModelRepository;
import cqrs.todo.repository.ToDoListRepository;
import static org.assertj.core.api.Assertions.assertThat;

public class ToDoListTest {

	private ToDoListQueries todoListQueries;
	private EventBus eventBus = new EventBus();
	private EventBus commandBus = new EventBus();

	@Before
	public void setUp() {
		ReadModelRepository readModelRepository = new ReadModelRepository();
		ReadModelHandler readModelHandler = new ReadModelHandler(readModelRepository);
		eventBus.register(readModelHandler);
		LoggerEventHandler eventLoggerHandler = new LoggerEventHandler();
		eventBus.register(eventLoggerHandler );
		commandBus.register(new ToDoListService(new ToDoListRepository(), eventBus ));
		todoListQueries = new ToDoListQueries(readModelRepository);
	}
	
	@Test
	public void testCreateTodoList() {
		//When
		commandBus.post(new CreateTodoListCommand("MyToDoList"));
		
		//Then		
		List<String> toDoList = todoListQueries.getToDoTitles("MyToDoList");
		assertThat(toDoList).isNotNull().isEmpty();
	}
	
	@Test
	public void testAddToDo() {
		//Given
		commandBus.post(new CreateTodoListCommand("MyToDoList"));
		
		//When
		commandBus.post(new AddTodoCommand("MyToDoList", "Start Ekito Presentation"));
		
		//Then
		List<String> toDoTitles = todoListQueries.getToDoTitles("MyToDoList");
		assertThat(toDoTitles).isNotNull().containsOnly("Start Ekito Presentation");
	}
	
	@Test
	public void testStartedToDo() {
		//Given
		commandBus.post(new CreateTodoListCommand("MyToDoList"));
		commandBus.post(new AddTodoCommand("MyToDoList", "Start Ekito Presentation"));
		
		//When
		commandBus.post(new StartTodoCommand("MyToDoList", "Start Ekito Presentation"));
				
		//Then
		List<String> toDoTitles = todoListQueries.getStartedToDoTitles("MyToDoList");
		assertThat(toDoTitles).isNotNull().containsOnly("Start Ekito Presentation");
	}
}
