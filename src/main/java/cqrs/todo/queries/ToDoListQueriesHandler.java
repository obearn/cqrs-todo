package cqrs.todo.queries;

import cqrs.todo.events.ToDoAdded;
import cqrs.todo.events.ToDoCompleted;
import cqrs.todo.events.ToDoListCreated;
import cqrs.todo.events.ToDoStarted;
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
		this.queriesRepository.save(toDoListReadModel);
	}

	public void handle(ToDoStarted toDoStarted) {
		ToDoListReadModel toDoListReadModel = this.queriesRepository.find(toDoStarted.todoListName);
		toDoListReadModel.addStartedTitle(toDoStarted.todo);
		this.queriesRepository.save(toDoListReadModel);
	}

	public void handle(ToDoCompleted toDoCompleted) {
		ToDoListReadModel toDoListReadModel = this.queriesRepository.find(toDoCompleted.todoListName);
		toDoListReadModel.removeStartedTitle(toDoCompleted.todo);
		toDoListReadModel.addCompletedTitle(toDoCompleted.todo);
		this.queriesRepository.save(toDoListReadModel);
	}
}
