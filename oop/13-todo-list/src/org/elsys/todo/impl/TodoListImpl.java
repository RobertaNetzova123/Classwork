package org.elsys.todo.impl;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.elsys.todo.Criteria;
import org.elsys.todo.Priority;
import org.elsys.todo.Status;
import org.elsys.todo.Task;
import org.elsys.todo.TodoList;

public class TodoListImpl implements TodoList {

	private List<Task> tasks;

	/**
	 * TODO    | Do OOP homework              | Low    | school, programming
	 * TODO    | Get 8 hours of sleep.        | Low    | health
	 * DOING   | Party hard.                  | Normal | social
	 * DONE    | Netflix and chill.           | Normal | tv shows
	 * TODO    | Find missing socks.          | Low    | meh

	 * @param input
	 */
	public TodoListImpl(String input) {
		tasks = Arrays.stream(input.split("\n")).map(line -> {
			String[] splitted = Arrays.stream(line.split("\\|"))
				.map(String::trim)
				.toArray(size -> new String[size]);
			return new TaskImpl(
					Status.valueOf(splitted[0].toUpperCase()),
					splitted[1],
					Priority.valueOf(splitted[2].toUpperCase()),
					splitted[3].split(", "));
		}).collect(Collectors.toList());
	}

	public TodoListImpl(List<Task> list) {
		tasks = list;
	}

	@Override
	public Boolean isCompleted() {
		// TODO Auto-generated method stub
		return completedPercentage().equals(100.00);
	}

	@Override
	public Double completedPercentage() {
		// TODO Auto-generated method stub
		return matchingPercentage(new StatusImpl(Status.DONE));
	}

//	@Override
//	public Double statusPercentage(Status status) {
//		// TODO Auto-generated method stub
//		List<Task> filtered = tasks.stream()
//				.filter(t -> t.getStatus().equals(status))
//				.collect(Collectors.toList());
//		return sumPercentage(filtered);
//	}
//
//	@Override
//	public Double matchingPercentage(Criteria criteria) {
//		TodoList list = new TodoListImpl(tasks);
//		List<Task> filtered = list.filter(criteria).getTasks();
//		
//		return sumPercentage(filtered);
//	}
	
	@Override
	public Double statusPercentage(Status status) {
		// TODO Auto-generated method stub
		return matchingPercentage(new StatusImpl(status));
	}

	@Override
	public Double matchingPercentage(Criteria criteria) {

		List<Task> filtered = new TodoListImpl(tasks)
				.filter(criteria)
				.getTasks();
		
		return (double) (Math.round ((filtered.size()*100/tasks.size())*100)/100);
	}

	@Override
	public List<Task> getTasks() {
		return tasks;
	}

	@Override
	public TodoList filter(Criteria criteria) {
		// TODO Auto-generated method stub
		List<Task> filtered = tasks.stream()
				.filter(t -> ((CriteriaImpl) criteria).DoesEqual(t))
				.collect(Collectors.toList());
		return new TodoListImpl(filtered);
	}

	@Override
	public int count(Criteria criteria) {
		// TODO Auto-generated method stub
		
		return new TodoListImpl(tasks).filter(criteria).getTasks().size();
	}

	@Override
	public void each(Consumer<Task> consumer) {
		consumer = (t) ->
		System.out.println(t);
		consumer.accept(tasks.get(0));
	}

		@Override
	public TodoList join(TodoList other) {
		// TODO Auto-generated method stub
		List<Task> finalList = other.getTasks();
		finalList.addAll(tasks);
		return new TodoListImpl ( finalList.stream()
				.distinct()
				.collect(Collectors.toList()));
	}
}
