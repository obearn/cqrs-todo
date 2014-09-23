package cqrs.todo.events;

public class ToDoListCreated {
	public final String name;

	public ToDoListCreated(String name) {
		this.name = name;
	}
}
