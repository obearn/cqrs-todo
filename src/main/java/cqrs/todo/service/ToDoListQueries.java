package cqrs.todo.service;

import java.util.List;

public interface ToDoListQueries {

	public abstract List<String> getToDoListTitles(String string);

	public abstract List<String> getToDoTitles(String todoListName);

	public abstract List<String> getStartedToDoTitles(String todoListName);

	public abstract List<String> getCompletedToDoTitles(String todoListName);

}