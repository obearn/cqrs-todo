package cqrs.todo.events;

public class ToDoStarted {

	public final String todoListName;
	public final String todo;

	public ToDoStarted(String todoListName, String todo) {
		this.todoListName = todoListName;
		this.todo = todo;
	}
}
