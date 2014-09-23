package cqrs.todo.queries;

import java.util.LinkedList;
import java.util.List;

public class ToDoListReadModel {

	public final String name;
	private List<String> todos = new LinkedList<String>();

	public ToDoListReadModel(String name) {
		this.name = name;
	}

	public List<String> getAllToDoTiles() {
		return this.todos;
	}

	public void addTitle(String todo) {
		this.todos.add(todo);
	}
}
