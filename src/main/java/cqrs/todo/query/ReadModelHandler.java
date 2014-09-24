package cqrs.todo.query;

import java.util.List;

import cqrs.todo.repository.ReadModelRepository;

public class ReadModelHandler {

	private ReadModelRepository readModelRepository;

	public ReadModelHandler(ReadModelRepository readModelRepository) {
		this.readModelRepository = readModelRepository;
	}

	public void handleTodoListCreated(String todoListName) {
		this.readModelRepository.create(todoListName);
	}

	public void handleTodoAdded(String todoListName, String todoTitle) {
		List<String> todoTitles = this.readModelRepository.findToDoTitles(todoListName);
		todoTitles.add(todoTitle);
	}

	public void handleTodoStarted(String todoListName, String todo) {
		List<String> startedTodoTitles = this.readModelRepository.findStartedToDoTitles(todoListName);
		startedTodoTitles.add(todo);
	}

}
