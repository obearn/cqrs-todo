package cqrs.todo.service;

import java.util.Arrays;
import java.util.List;

import cqrs.todo.domain.ToDoList;
import cqrs.todo.repository.TODOListRepository;

public class TODOListService {

	private TODOListRepository repository;

	public TODOListService(TODOListRepository repository) {
		this.repository = repository;
	}
	
	public void create(String name) {
		repository.create(name);
	}

	public void addToDo(String todoListName, String todo) {
		ToDoList todoList = repository.find(todoListName);
		todoList.add(todo);
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
		repository.save(todoList);
	}
	
	public List<String> getToDoListTitles(String string) {
		return Arrays.asList("MyToDoList");
	}			
	
	public List<String> getToDoTitles(String todoListName) {
		ToDoList todoList = repository.find(todoListName);
		return todoList.getTitles();
	}
	
	public List<String> getStartedToDoTitles(String todoListName) {
		ToDoList todoList = repository.find(todoListName);
		return todoList.getStartedTitles();
	}
}
