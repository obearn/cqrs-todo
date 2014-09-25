package cqrs.todo.commands;

public class AddTodoCommand {
	public String todoListName;
	public String todo;

	public AddTodoCommand(String todoListName, String todo) {
		this.todoListName = todoListName;
		this.todo = todo;
	}
}