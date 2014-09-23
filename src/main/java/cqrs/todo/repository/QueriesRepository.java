package cqrs.todo.repository;

import java.util.HashMap;
import java.util.Map;

import cqrs.todo.queries.ToDoListReadModel;

public class QueriesRepository {

	private Map<String, ToDoListReadModel> todoListReadModels = new HashMap<String, ToDoListReadModel>();
	
	public void create(ToDoListReadModel toDoListReadModel) {
		todoListReadModels.put(toDoListReadModel.name, toDoListReadModel);
	}

	public ToDoListReadModel find(String name) {
		return todoListReadModels.get(name);
	}

	public void save(ToDoListReadModel toDoListReadModel) {
		todoListReadModels.put(toDoListReadModel.name, toDoListReadModel);
	}
}
