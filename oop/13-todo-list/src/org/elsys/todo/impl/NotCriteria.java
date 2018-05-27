package org.elsys.todo.impl;

import org.elsys.todo.Criteria;
import org.elsys.todo.Task;

public class NotCriteria extends CriteriaImpl {

	private Criteria criteria;
	
	
	public NotCriteria(Criteria criteria) {
		super();
		this.criteria = criteria;
	}


	@Override
	public boolean DoesEqual(Task task) {
		// TODO Auto-generated method stub
		return !((CriteriaImpl) criteria).DoesEqual(task);
	}

}
