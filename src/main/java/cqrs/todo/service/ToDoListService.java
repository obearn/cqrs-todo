package cqrs.todo.service;

import java.util.List;

import cqrs.todo.domain.ToDoList;
import cqrs.todo.query.ReadModelHandler;
import cqrs.todo.repository.ReadModelRepository;
import cqrs.todo.repository.ToDoListRepository;

public class ToDoListService {

	private ToDoListRepository repository = new ToDoListRepository();
	private ReadModelRepository readModelRepository = new ReadModelRepository();
	private ReadModelHandler readModelHandler = new ReadModelHandler(readModelRepository);
	
	public ToDoListService(ToDoListRepository repository) {
		this.repository = repository;
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
	}

	public void startToDo(String todoListName, String todo) {
		ToDoList todoList = repository.find(todoListName);
		todoList.startToDo(todo);
		readModelHandler.handleTodoStarted(todoListName, todo);
	}

	public List<String> getToDoTitles(String todoListName) {
		return readModelRepository.findToDoTitles(todoListName);
	}
	
	public List<String> getStartedToDoTitles(String todoListName) {
		return readModelRepository.findStartedToDoTitles(todoListName);
	}
}
