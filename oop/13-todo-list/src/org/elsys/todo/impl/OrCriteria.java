package org.elsys.todo.impl;

import org.elsys.todo.Criteria;
import org.elsys.todo.Task;

public class OrCriteria extends CriteriaImpl {

	private Criteria criteria;
	private Criteria otherCriteria;
	
	public OrCriteria(Criteria criteria, Criteria otherCriteria) {
		super();
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	@Override
	public boolean DoesEqual(Task task) {
		return ((CriteriaImpl) criteria).DoesEqual(task) 
				|| ((CriteriaImpl) otherCriteria).DoesEqual(task);
	}

}
