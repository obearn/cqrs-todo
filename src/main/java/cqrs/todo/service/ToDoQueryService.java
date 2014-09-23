package cqrs.todo.service;

import java.util.List;

import cqrs.todo.queries.ToDoListReadModel;
import cqrs.todo.repository.QueriesRepository;

public class ToDoQueryService {

	private QueriesRepository queryRepository;

	public ToDoQueryService(QueriesRepository queriesRepository) {
		queryRepository = queriesRepository;
	}

	public List<String> getToDoTitles(String todoListName) {
		ToDoListReadModel toDoListReadModel = this.queryRepository.find(todoListName);
		return toDoListReadModel.getAllToDoTiles();
	}

	public List<String> getStartedToDoTitles(String todoListName) {
		ToDoListReadModel toDoListReadModel = this.queryRepository.find(todoListName);
		return toDoListReadModel.getStartedToDos();
	}

	public List<String> getCompletedToDoTitles(String todoListName) {
		ToDoListReadModel toDoListReadModel = this.queryRepository.find(todoListName);
		return toDoListReadModel.getCompletedToDos();
	}
}
