package org.elsys.todo.impl;

import org.elsys.todo.Status;
import org.elsys.todo.Task;

public class CriteriaStatus extends CriteriaImpl {

	private Status status;
	
	public CriteriaStatus(Status status) {
		super();
		this.status = status;
	}

	@Override
	public boolean DoesEqual(Task task) {
		
		return status.equals(task.getStatus());
	}

}
