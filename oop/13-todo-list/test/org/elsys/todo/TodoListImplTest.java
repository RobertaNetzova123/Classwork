package org.elsys.todo;

import static org.junit.Assert.*;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

public class TodoListImplTest {

	private TodoList todoList = TodoList.parse(
			"TODO    | Do OOP homework              | Low    | school, programming\r\n" + 
			"TODO    | Get 8 hours of sleep.        | Low    | health\r\n" + 
			"DOING   | Party hard.                  | Normal | social\r\n" + 
			"DONE    | Netflix and chill.           | Normal | tv shows\r\n" + 
			"TODO    | Find missing socks.          | Low    | meh\r\n" + 
			"");
	
	private TodoList doneList = TodoList.parse(
			"DONE    | Do OOP homework              | Low    | school, programming\r\n" + 
			"DONE    | Get 8 hours of sleep.        | Low    | health\r\n" + 
			"DONE   | Party hard.                  | Normal | social\r\n" + 
			"DONE    | Netflix and chill.           | Normal | tv shows\r\n" + 
			"DONE    | Find missing socks.          | Low    | meh\r\n" + 
			"");
	// TODO implement tests
	
	@Test
	public void testIsCompleted () {
		assertEquals(false,todoList.isCompleted());
		assertEquals (true,doneList.isCompleted());
	}
	
	@Test 
	public void testCompletedPercentage() {
		assertEquals(Double.valueOf(20.00),todoList.completedPercentage());
		assertEquals(Double.valueOf(100.00),doneList.completedPercentage());
	}
	
	@Test 
	public void testStatusPercentage() {
		assertEquals(Double.valueOf(20.00),todoList.statusPercentage(Status.DONE));
	}

	@Test
	public void testStatusCriteriaFilter() {
		
		TodoList filtered = todoList
				.filter(Criteria.status(Status.DONE));
		assertEquals(1,filtered.getTasks().size());
	}
	
	@Test
	public void testPriorityCriteriaFilter() {
		TodoList filtered = todoList.filter(Criteria.priority(Priority.LOW));
		assertEquals(3,filtered.getTasks().size());
	}
	
	@Test
	public void testJoin() {
		assertEquals(9,todoList.join(doneList).getTasks().size());
	}
	
	@Test
	public void testFilterByTag() {
		assertEquals(0, todoList
						.filter(Criteria.tags(new String[] {"school", "fun"}))
						.getTasks().size());
		
		assertEquals(1, todoList
						.filter(Criteria.tags(new String[] {"school"}))
						.getTasks().size());
		
		assertEquals(1, todoList
						.filter(Criteria.tags(new String[] {"school", "programming"}))
						.getTasks().size());
	}
	
	@Test
	public void testAndOrNotXorFilter() {
		
		assertEquals(1,todoList
				.filter(Criteria.tags(new String[] {"meh"})
				.and(Criteria.priority(Priority.LOW)))
				.getTasks()
				.size());
		
		assertEquals(1, todoList
				.filter(Criteria.tags(new String[] { "school" })
				.or(Criteria.priority(Priority.HIGH)))
				.getTasks()
				.size());

		assertEquals (5,todoList
				.filter(Criteria.priority(Priority.HIGH).not())
				.getTasks()
				.size());
		
		assertEquals(3, doneList
				.filter(Criteria.status(Status.DONE)
				.xor(Criteria.priority(Priority.NORMAL)))
				.getTasks().size());
	}
	
	@Test
	public void testCountCriteria() {
		
		assertEquals(3, todoList.count(Criteria.status(Status.TODO)));
	}
	
	@Test
	public void testMatchPercentage() {
		assertEquals(60.00,todoList.matchingPercentage(Criteria.status(Status.TODO)),0);
	}
	
//	@Test
//	public void testEach() {
//		Consumer<Task> consumer = ;
//		todoList.each(consumer);
//	}
}
