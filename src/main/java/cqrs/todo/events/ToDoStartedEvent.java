package cqrs.todo.events;

public class ToDoStartedEvent {
	public String todoListName;
	public String todo;

	public ToDoStartedEvent(String todoListName, String todo) {
		this.todoListName = todoListName;
		this.todo = todo;
	}
}