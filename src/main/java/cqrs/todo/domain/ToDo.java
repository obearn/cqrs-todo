package cqrs.todo.domain;

public class ToDo {

	private String title;
	private boolean started = false;
	private boolean completed = false;

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
}
