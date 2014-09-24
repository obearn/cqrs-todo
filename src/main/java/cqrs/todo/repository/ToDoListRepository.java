package cqrs.todo.repository;

import java.util.LinkedHashMap;
import java.util.Map;

import cqrs.todo.domain.ToDoList;

public class ToDoListRepository {

	private Map<String, ToDoList> todoLists = new LinkedHashMap<String, ToDoList>();

	public void create(ToDoList todoList) {
		todoLists.put(todoList.name, todoList);
	}

	public ToDoList find(String todoListName) {
		return todoLists.get(todoListName);
	}

	public void save(ToDoList todoList) {
		todoLists.put(todoList.name, todoList);
	}
}
