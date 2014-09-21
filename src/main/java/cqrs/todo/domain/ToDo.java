package cqrs.todo.domain;

public class ToDo {

	private String title;
	private boolean isStarted = false;

	public ToDo(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void start() {
		this.isStarted  = true;
	}

	public boolean isStarted() {
		return isStarted;
	}
}
