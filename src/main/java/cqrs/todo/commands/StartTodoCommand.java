package cqrs.todo.commands;

public class StartTodoCommand {
	public String todoListName;
	public String todo;

	public StartTodoCommand(String todoListName, String todo) {
		this.todoListName = todoListName;
		this.todo = todo;
	}
}