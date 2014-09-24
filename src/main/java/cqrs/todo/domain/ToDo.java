package cqrs.todo.domain;

public class ToDo {

	private final String title;
	boolean isStarted = false;

	public ToDo(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void start() {
		this.isStarted  = true;
	}

}
