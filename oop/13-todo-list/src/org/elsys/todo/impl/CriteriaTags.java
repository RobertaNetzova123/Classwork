package org.elsys.todo.impl;

import org.elsys.todo.Task;

public class CriteriaTags extends CriteriaImpl {

	private String[] tags;
	
	public CriteriaTags(String[] tags) {
		super();
		this.tags = tags;
	}
	
	@Override
	public boolean DoesEqual(Task task) {
		
		int count = 0;
		String[] taskTags = task.getTags();
		for (String taskTag : taskTags) {
			for (String tagTemplate : tags) {
				if(taskTag.equals(tagTemplate)) {
					count++;
				}
			}
		}
		return count == tags.length;
	}

}
