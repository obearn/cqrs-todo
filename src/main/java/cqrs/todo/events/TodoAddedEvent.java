package cqrs.todo.events;


public class TodoAddedEvent extends ToDoEvent {

	public TodoAddedEvent(String todoListName, String todoTitle) {
		super(todoListName, todoTitle);
	}
}