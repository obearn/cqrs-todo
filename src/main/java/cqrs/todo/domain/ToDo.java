package cqrs.todo.domain;

public class ToDo {

	private String title;
	private boolean started = false;
	private boolean completed;

	public ToDo(String title) {
		this.title = title;
	}

	public void start() {
		this.started  = true;
	}

	public String getTitle() {
		return title;
	}

	public void complete() {
		this.started = false;
		this.completed = true;
	}

	public boolean isStarted() {
		return started;
	}

	public boolean isCompleted() {
		return completed;
	}
}
