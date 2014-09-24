package cqrs.todo.events;

public class ToDoEvent extends ToDoListEvent {

	public final String todo;

	public ToDoEvent(String todoListName, String todo) {
		super(todoListName);
		this.todo = todo;
	}

	@Override
	public String toString() {
		return toStringHelper.add("todo", todo).toString();
	}
}