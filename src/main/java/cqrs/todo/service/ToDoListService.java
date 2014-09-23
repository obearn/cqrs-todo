package cqrs.todo.service;

import cqrs.todo.domain.ToDoList;
import cqrs.todo.events.ToDoAdded;
import cqrs.todo.events.ToDoCompleted;
import cqrs.todo.events.ToDoListCreated;
import cqrs.todo.events.ToDoStarted;
import cqrs.todo.queries.ToDoListQueriesHandler;
import cqrs.todo.repository.TODOListRepository;

public class ToDoListService {

	private TODOListRepository repository;
	private ToDoListQueriesHandler todoListTitlesHandler;

	public ToDoListService(TODOListRepository repository, ToDoListQueriesHandler todoListTitlesHandler) {
		this.repository = repository;
		this.todoListTitlesHandler = todoListTitlesHandler;
	}
	
	
	public void create(String name) {
		repository.create(name);
		this.todoListTitlesHandler.handle(new ToDoListCreated(name));
	}

	
	public void addToDo(String todoListName, String todo) {
		ToDoList todoList = repository.find(todoListName);
		todoList.add(todo);
		this.todoListTitlesHandler.handle(new ToDoAdded(todoListName, todo));
		repository.save(todoList);
	}

	
	public void removeToDo(String todoListName, String todo) {
		ToDoList todoList = repository.find(todoListName);
		todoList.removeTodo(todo);
		repository.save(todoList);
	}

	
	public void startToDo(String todoListName, String todo) {
		ToDoList todoList = repository.find(todoListName);
		todoList.startTodo(todo);
		this.todoListTitlesHandler.handle(new ToDoStarted(todoListName, todo));
		repository.save(todoList);
	}

	
	public void completeToDo(String todoListName, String todo) {
		ToDoList todoList = repository.find(todoListName);
		this.todoListTitlesHandler.handle(new ToDoCompleted(todoListName, todo));
		todoList.completeToDo(todo);
	}
}
