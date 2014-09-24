package cqrs.todo.query;

import java.util.List;

import com.google.common.eventbus.Subscribe;

import cqrs.todo.events.ToDoEvent;
import cqrs.todo.events.TodoAddedEvent;
import cqrs.todo.events.TodoListCreatedEvent;
import cqrs.todo.repository.ReadModelRepository;

public class ReadModelHandler {

	private ReadModelRepository readModelRepository;

	public ReadModelHandler(ReadModelRepository readModelRepository) {
		this.readModelRepository = readModelRepository;
	}

	@Subscribe public void handleTodoListCreated(TodoListCreatedEvent parameterObject) {
		this.readModelRepository.create(parameterObject.todoListName);
	}

	@Subscribe public void handleTodoAdded(TodoAddedEvent todoAddedEvent) {
		List<String> todoTitles = this.readModelRepository.findToDoTitles(todoAddedEvent.todoListName);
		todoTitles.add(todoAddedEvent.todo);
	}

	@Subscribe public void handleTodoStarted(ToDoEvent todoStartedEvent) {
		List<String> startedTodoTitles = this.readModelRepository.findStartedToDoTitles(todoStartedEvent.todoListName);
		startedTodoTitles.add(todoStartedEvent.todo);
	}
}
