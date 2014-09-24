package cqrs.todo.service;

import java.util.List;

import cqrs.todo.domain.ToDoList;
import cqrs.todo.repository.ToDoListRepository;

public class ToDoListService {

	private ToDoListRepository repository = new ToDoListRepository();
	
	public ToDoListService(ToDoListRepository repository) {
		this.repository = repository;
	}

	public void create(String toDoList) {
		ToDoList toDoList2 = new ToDoList(toDoList);
		repository.create(toDoList2);
	}

	public List<String> getToDoTitles(String todoListName) {
		ToDoList toDoList = repository.find(todoListName);
		return toDoList.getToDoTitles();
	}

	public void addToDo(String todoListName, String todo) {
		ToDoList todoList = repository.find(todoListName);
		todoList.addToDo(todo);
	}

	public void startToDo(String todoListName, String todo) {
		ToDoList todoList = repository.find(todoListName);
		todoList.startToDo(todo);
	}

	public List<String> getStartedToDoTitles(String todoListName) {
		ToDoList toDoList = repository.find(todoListName);
		return toDoList.getStartedToDoTitles();
	}
}
