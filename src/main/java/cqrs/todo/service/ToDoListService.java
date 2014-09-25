package cqrs.todo.service;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import cqrs.todo.commands.AddTodoCommand;
import cqrs.todo.commands.CreateTodoListCommand;
import cqrs.todo.commands.StartTodoCommand;
import cqrs.todo.domain.ToDoList;
import cqrs.todo.events.ToDoStartedEvent;
import cqrs.todo.events.TodoAddedEvent;
import cqrs.todo.events.TodoListCreatedEvent;
import cqrs.todo.repository.ToDoListRepository;

public class ToDoListService {

	private ToDoListRepository repository;
	private EventBus eventBus;
	
	public ToDoListService(ToDoListRepository repository, EventBus eventBus) {
		this.repository = repository;
		this.eventBus = eventBus;
	}

	@Subscribe public void create(CreateTodoListCommand parameterObject) {
		ToDoList todoList = new ToDoList(parameterObject.todoListName);
		repository.create(todoList);
		eventBus.post(new TodoListCreatedEvent(parameterObject.todoListName));
	}

	@Subscribe public void addToDo(AddTodoCommand parameterObject) {
		ToDoList todoList = repository.find(parameterObject.todoListName);
		todoList.addToDo(parameterObject.todo);
		eventBus.post(new TodoAddedEvent(parameterObject.todoListName, parameterObject.todo));
		repository.save(todoList);
	}

	@Subscribe public void startToDo(StartTodoCommand parameterObject) {
		ToDoList todoList = repository.find(parameterObject.todoListName);
		todoList.startToDo(parameterObject.todo);
		eventBus.post(new ToDoStartedEvent(parameterObject.todoListName, parameterObject.todo));
		repository.save(todoList);
	}
}
