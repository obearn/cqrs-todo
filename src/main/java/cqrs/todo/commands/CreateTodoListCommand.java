package cqrs.todo.commands;

public class CreateTodoListCommand {
	public String todoListName;

	public CreateTodoListCommand(String todoListName) {
		this.todoListName = todoListName;
	}
}