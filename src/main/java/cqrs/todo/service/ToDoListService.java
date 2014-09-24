package cqrs.todo.service;

import com.google.common.eventbus.EventBus;

import cqrs.todo.domain.ToDoList;
import cqrs.todo.events.ToDoStartedEvent;
import cqrs.todo.events.TodoAddedEvent;
import cqrs.todo.events.TodoListCreatedEvent;
import cqrs.todo.query.ReadModelHandler;
import cqrs.todo.repository.ToDoListRepository;

public class ToDoListService {

	private ToDoListRepository repository;
	private EventBus eventBus;
	
	public ToDoListService(ToDoListRepository repository, EventBus eventBus) {
		this.repository = repository;
		this.eventBus = eventBus;
	}

	public void create(String todoListName) {
		ToDoList todoList = new ToDoList(todoListName);
		repository.create(todoList);
		eventBus.post(new TodoListCreatedEvent(todoListName));
	}

	public void addToDo(String todoListName, String todo) {
		ToDoList todoList = repository.find(todoListName);
		todoList.addToDo(todo);
		eventBus.post(new TodoAddedEvent(todoListName, todo));
		repository.save(todoList);
	}

	public void startToDo(String todoListName, String todo) {
		ToDoList todoList = repository.find(todoListName);
		todoList.startToDo(todo);
		eventBus.post(new ToDoStartedEvent(todoListName, todo));
		repository.save(todoList);
	}
}
