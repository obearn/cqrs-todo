package cqrs.todo.events;


public class ToDoStartedEvent extends ToDoEvent {
	public ToDoStartedEvent(String todoListName, String todo) {
		super(todoListName, todo);
	}
}