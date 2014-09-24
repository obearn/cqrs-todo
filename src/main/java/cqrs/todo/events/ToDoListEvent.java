package cqrs.todo.events;

import java.util.Date;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

public class ToDoListEvent {
	
	private Date creationDate;
	public final String todoListName;
	protected ToStringHelper toStringHelper;

	ToDoListEvent(String todoListName) {
		this.todoListName = todoListName;
		creationDate = new Date();
		toStringHelper = Objects.toStringHelper(this).add("created", creationDate);
	}

	@Override
	public String toString() {
		return toStringHelper.toString();
	}

}
