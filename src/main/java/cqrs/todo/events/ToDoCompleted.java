package cqrs.todo.events;

public class ToDoCompleted {

	public final String todoListName;
	public final String todo;

	public ToDoCompleted(String todoListName, String todo) {
		this.todoListName = todoListName;
		this.todo = todo;
	}

}
