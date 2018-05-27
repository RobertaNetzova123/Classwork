package org.elsys.todo.impl;

import org.elsys.todo.Priority;
import org.elsys.todo.Task;

public class CriteriaPriority extends CriteriaImpl {

private Priority priority;
	
	public CriteriaPriority(Priority priority) {
		super();
		this.priority = priority;
	}

	@Override
	public boolean DoesEqual(Task task) {
		return priority.equals(task.getPriority());
	}

}
