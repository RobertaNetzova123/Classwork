package org.elsys.todo.impl;

import org.elsys.todo.Criteria;
import org.elsys.todo.Task;

abstract class CriteriaImpl implements Criteria {

	@Override
	public Criteria and(Criteria other) {
		// TODO Auto-generated method stub
		return new AndCriteria(this, other);
	}

	@Override
	public Criteria or(Criteria other) {
		return new OrCriteria(this,other);
	}

	@Override
	public Criteria xor(Criteria other) {
		// TODO Auto-generated method stub
		return new XorCriteria(this, other);
	}

	@Override
	public Criteria not() {
		// TODO Auto-generated method stub
		return new NotCriteria(this);
	}

	abstract public boolean DoesEqual(Task task);
}
