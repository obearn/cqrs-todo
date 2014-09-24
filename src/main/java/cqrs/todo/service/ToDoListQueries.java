package cqrs.todo.service;

import java.util.List;

import cqrs.todo.repository.ReadModelRepository;

public class ToDoListQueries {

	private ReadModelRepository readModelRepository;

	public ToDoListQueries(ReadModelRepository readModelRepository) {
		this.readModelRepository = readModelRepository;
	}

	public List<String> getToDoTitles(String todoListName) {
		return this.readModelRepository.findToDoTitles(todoListName);
	}

	public List<String> getStartedToDoTitles(String todoListName) {
		return this.readModelRepository.findStartedToDoTitles(todoListName);
	}
}
