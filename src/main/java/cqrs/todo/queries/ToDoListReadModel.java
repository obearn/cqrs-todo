package cqrs.todo.queries;

import java.util.LinkedList;
import java.util.List;

public class ToDoListReadModel {

	public final String name;
	private List<String> todos = new LinkedList<String>();
	private List<String> startedTodos = new LinkedList<String>();
	private List<String> completedTodos = new LinkedList<String>();

	public ToDoListReadModel(String name) {
		this.name = name;
	}

	public List<String> getAllToDoTiles() {
		return this.todos;
	}

	public void addTitle(String todo) {
		this.todos.add(todo);
	}

	public List<String> getStartedToDos() {
		return this.startedTodos;
	}

	public void addStartedTitle(String todo) {
		this.startedTodos.add(todo);
	}

	public void removeStartedTitle(String todo) {
		this.startedTodos.remove(this.startedTodos.indexOf(todo));
	}

	public void addCompletedTitle(String todo) {
		this.completedTodos.add(todo);
	}

	public List<String> getCompletedToDos() {
		return this.completedTodos;
	}
}
