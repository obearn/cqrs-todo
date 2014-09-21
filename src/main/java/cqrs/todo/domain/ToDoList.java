package cqrs.todo.domain;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
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

	public String getName() {
		return name;
	}

	public List<String> getTitles() {
		List<String> titles = new LinkedList<String>();
		for (ToDo todo : todos.values()) {
			titles.add(todo.getTitle());
		}
		return titles;
	}

	public void removeTodo(String todo) {
		todos.remove(todo);
	}

	public void startTodo(String todo) {
		todos.get(todo).start();
	}

	public List<String> getStartedTitles() {
		List<String> titles = new LinkedList<String>();
		for (ToDo todo : todos.values()) {
			if (todo.isStarted()) {
				titles.add(todo.getTitle());
			}
		}
		return titles;
	}
}
