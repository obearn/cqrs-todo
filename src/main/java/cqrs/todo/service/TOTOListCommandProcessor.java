package cqrs.todo.service;

public interface TOTOListCommandProcessor {

	public abstract void create(String name);

	public abstract void addToDo(String todoListName, String todo);

	public abstract void removeToDo(String todoListName, String todo);

	public abstract void startToDo(String todoListName, String todo);

	public abstract void completeToDo(String todoListName, String todo);

}