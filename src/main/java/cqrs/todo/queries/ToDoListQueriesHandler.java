package cqrs.todo.queries;

import cqrs.todo.events.ToDoAdded;
import cqrs.todo.events.ToDoListCreated;
import cqrs.todo.repository.QueriesRepository;

public class ToDoListQueriesHandler {

	private QueriesRepository queriesRepository;

	public ToDoListQueriesHandler(QueriesRepository queriesRepository) {
		this.queriesRepository = queriesRepository;
	}

	public void handle(ToDoListCreated toDoListCreated) {
		this.queriesRepository.create(new ToDoListReadModel(toDoListCreated.name));
	}

	public void handle(ToDoAdded toDoAdded) {
		ToDoListReadModel toDoListReadModel = this.queriesRepository.find(toDoAdded.todoListName);
		toDoListReadModel.addTitle(toDoAdded.todo);
	}
}
