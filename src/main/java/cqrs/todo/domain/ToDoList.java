package cqrs.todo.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class ToDoList {

	private String name;
	private Map<String, ToDo> todos = new LinkedHashMap<String, ToDo>();

	public ToDoList(String name) {
		this.name = name;
	}

	public void add(String todo) {
		todos.put(todo, new ToDo(todo));
	}

	public void removeTodo(String todo) {
		todos.remove(todo);
	}
	
	public void startTodo(String todo) {
		todos.get(todo).start();
	}
	
	public void completeToDo(String todo) {
		todos.get(todo).complete();
	}
	
	public String getName() {
		return name;
	}
}
