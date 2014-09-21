package cqrs.todo.repository;

import java.util.HashMap;
import java.util.Map;

import cqrs.todo.domain.ToDoList;

public class TODOListRepository {

	private Map<String, ToDoList> todoLists = new HashMap<String, ToDoList>();

	public void create(String name) {
		todoLists.put(name, new ToDoList(name));
	}

	public ToDoList find(String name) {
		return todoLists.get(name);
	}

	public void save(ToDoList todoList) {
		todoLists.put(todoList.getName(), todoList);
	}
}
