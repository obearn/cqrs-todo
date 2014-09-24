package cqrs.todo.events;

public class TodoAddedEvent {
	public String todoListName;
	public String todoTitle;

	public TodoAddedEvent(String todoListName, String todoTitle) {
		this.todoListName = todoListName;
		this.todoTitle = todoTitle;
	}
}