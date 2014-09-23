package cqrs.todo.service;

import java.util.List;

import cqrs.todo.queries.ToDoListReadModel;
import cqrs.todo.repository.QueriesRepository;

public class ToDoQueryService {

	private QueriesRepository queryRepository;

	public ToDoQueryService(QueriesRepository queriesRepository) {
		queryRepository = queriesRepository;
	}

	public List<String> getToDoTitles(String name) {
		ToDoListReadModel toDoListReadModel = this.queryRepository.find(name);
		return toDoListReadModel.getAllToDoTiles();
	}

}
