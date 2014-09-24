package cqrs.todo.events;

public class TodoListCreatedEvent {
	public String todoListName;

	public TodoListCreatedEvent(String todoListName) {
		this.todoListName = todoListName;
	}
}