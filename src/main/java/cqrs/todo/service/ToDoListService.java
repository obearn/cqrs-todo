package cqrs.todo.service;

import java.util.List;

import cqrs.todo.domain.ToDoList;
import cqrs.todo.repository.TODOListRepository;

public class ToDoListService implements ToDoListCommandProcessor, ToDoListQueries {

	private TODOListRepository repository;

	public ToDoListService(TODOListRepository repository) {
		this.repository = repository;
	}
	
	/* (non-Javadoc)
	 * @see cqrs.todo.service.TOTOListCommandProcessor#create(java.lang.String)
	 */
	@Override
	public void create(String name) {
		repository.create(name);
	}

	/* (non-Javadoc)
	 * @see cqrs.todo.service.TOTOListCommandProcessor#addToDo(java.lang.String, java.lang.String)
	 */
	@Override
	public void addToDo(String todoListName, String todo) {
		ToDoList todoList = repository.find(todoListName);
		todoList.add(todo);
		repository.save(todoList);
	}

	/* (non-Javadoc)
	 * @see cqrs.todo.service.TOTOListCommandProcessor#removeToDo(java.lang.String, java.lang.String)
	 */
	@Override
	public void removeToDo(String todoListName, String todo) {
		ToDoList todoList = repository.find(todoListName);
		todoList.removeTodo(todo);
		repository.save(todoList);
	}

	/* (non-Javadoc)
	 * @see cqrs.todo.service.TOTOListCommandProcessor#startToDo(java.lang.String, java.lang.String)
	 */
	@Override
	public void startToDo(String todoListName, String todo) {
		ToDoList todoList = repository.find(todoListName);
		todoList.startTodo(todo);
		repository.save(todoList);
	}

	/* (non-Javadoc)
	 * @see cqrs.todo.service.TOTOListCommandProcessor#completeToDo(java.lang.String, java.lang.String)
	 */
	@Override
	public void completeToDo(String todoListName, String todo) {
		ToDoList todoList = repository.find(todoListName);
		todoList.completeToDo(todo);
	}
	
	/* (non-Javadoc)
	 * @see cqrs.todo.service.ToDoListQueries#getToDoListTitles(java.lang.String)
	 */
	@Override
	public List<String> getToDoListTitles(String todoListName) {
		ToDoList todoList = this.repository.find(todoListName);
		return todoList.getTitles();
	}			
	
	/* (non-Javadoc)
	 * @see cqrs.todo.service.ToDoListQueries#getToDoTitles(java.lang.String)
	 */
	@Override
	public List<String> getToDoTitles(String todoListName) {
		ToDoList todoList = repository.find(todoListName);
		return todoList.getTitles();
	}
	
	/* (non-Javadoc)
	 * @see cqrs.todo.service.ToDoListQueries#getStartedToDoTitles(java.lang.String)
	 */
	@Override
	public List<String> getStartedToDoTitles(String todoListName) {
		ToDoList todoList = repository.find(todoListName);
		return todoList.getStartedTitles();
	}

	/* (non-Javadoc)
	 * @see cqrs.todo.service.ToDoListQueries#getCompletedToDoTitles(java.lang.String)
	 */
	@Override
	public List<String> getCompletedToDoTitles(String todoListName) {
		ToDoList todoList = repository.find(todoListName);
		return todoList.getCompletedToDoTitles();
	}

}
