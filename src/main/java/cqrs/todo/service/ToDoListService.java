package cqrs.todo.service;

import cqrs.todo.domain.ToDoList;
import cqrs.todo.query.ReadModelHandler;
import cqrs.todo.repository.ToDoListRepository;

public class ToDoListService {

	private ToDoListRepository repository;
	private ReadModelHandler readModelHandler;
	
	public ToDoListService(ToDoListRepository repository, ReadModelHandler readModelHandler) {
		this.repository = repository;
		this.readModelHandler = readModelHandler;
	}

	public void create(String todoListName) {
		ToDoList todoList = new ToDoList(todoListName);
		repository.create(todoList);
		readModelHandler.handleTodoListCreated(todoListName);
	}

	public void addToDo(String todoListName, String todo) {
		ToDoList todoList = repository.find(todoListName);
		todoList.addToDo(todo);
		readModelHandler.handleTodoAdded(todoListName, todo);
		repository.save(todoList);
	}

	public void startToDo(String todoListName, String todo) {
		ToDoList todoList = repository.find(todoListName);
		todoList.startToDo(todo);
		readModelHandler.handleTodoStarted(todoListName, todo);
		repository.save(todoList);
	}
}
