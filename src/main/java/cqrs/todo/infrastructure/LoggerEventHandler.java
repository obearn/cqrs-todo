package cqrs.todo.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.Subscribe;

import cqrs.todo.events.ToDoListEvent;

public class LoggerEventHandler {
	private Logger logger = LoggerFactory.getLogger(LoggerEventHandler.class);

	@Subscribe public void logEvent(ToDoListEvent todoEvent) {
		logger.info(todoEvent.toString());
	}
}
