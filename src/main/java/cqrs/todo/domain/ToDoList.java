package cqrs.todo.domain;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ToDoList {

	public final String name;
	private Map<String, ToDo> todos = new LinkedHashMap<String, ToDo>();

	public ToDoList(String toDoList) {
		this.name = toDoList;
	}

	public void addToDo(String title) {
		this.todos.put(title, new ToDo(title));
	}

	public void startToDo(String title) {
		ToDo todo = this.todos.get(title);
		todo.start();
	}

	public List<String> getToDoTitles() {
		List<String> todoTitles = new LinkedList<String>();
		for (ToDo todo: todos.values()) {
			todoTitles.add(todo.getTitle());
		}
		return todoTitles;
	}

	public List<String> getStartedToDoTitles() {
		List<String> todoTitles = new LinkedList<String>();
		for (ToDo todo: todos.values()) {
			if (todo.isStarted) {
				todoTitles.add(todo.getTitle());	
			}
		}
		return todoTitles;
	}
}
