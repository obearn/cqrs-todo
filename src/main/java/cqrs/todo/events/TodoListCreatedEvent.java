package cqrs.todo.events;


public class TodoListCreatedEvent extends ToDoListEvent {
	public TodoListCreatedEvent(String todoListName) {
		super(todoListName);
	}
}