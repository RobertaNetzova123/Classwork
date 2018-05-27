package org.elsys.todo.impl;

import org.elsys.todo.Criteria;
import org.elsys.todo.Task;

public class XorCriteria extends CriteriaImpl {

	private Criteria criteria;
	private Criteria otherCriteria;
	
	
	public XorCriteria(Criteria criteria, Criteria otherCriteria) {
		super();
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}


	@Override
	public boolean DoesEqual(Task task) {

		return ((CriteriaImpl) criteria).DoesEqual(task) 
				^ ((CriteriaImpl) otherCriteria).DoesEqual(task);
	}

}
