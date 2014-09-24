package cqrs.todo.repository;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class ReadModelRepository {

	private final Map<String, List<String>> todoTitles = new LinkedHashMap<String, List<String>>();
	private final Map<String, List<String>> startedToDoTitles = new LinkedHashMap<String, List<String>>();
	
	public void create(String todoListName) {
		this.todoTitles.put(todoListName, new LinkedList<String>());
		this.startedToDoTitles.put(todoListName, new LinkedList<String>());
	}

	public List<String> findToDoTitles(String todoListName) {
		return this.todoTitles.get(todoListName);
	}

	public List<String> findStartedToDoTitles(String todoListName) {
		return this.startedToDoTitles.get(todoListName);
	}
}
