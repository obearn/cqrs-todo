package cqrs.todo.events;

public class ToDoAdded {

	public final String todoListName;
	public final String todo;

	public ToDoAdded(String todoListName, String todo) {
		this.todoListName = todoListName;
		this.todo = todo;
	}
}
