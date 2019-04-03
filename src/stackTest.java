import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class stackTest {
	
	@Test
	public void testPushAndPopSingle()
	{
		Stack stik = new Stack();
		stik.Push(1);
		assertEquals(1,stik.Pop());
		stik.Push(1);
		stik.Push(2);
		stik.Push(3);
		assertEquals(3,stik.Pop());
		stik.Pop();
		stik.Pop();
	}
	
	@Test
	public void testPushMulti()
	{
		Stack stik = new Stack();
		int[] nummer = new int[] {1,2,3,4,5};
		stik.Push(nummer);
		assertEquals(5, stik.Pop());
		assertEquals(4, stik.Pop());
		assertEquals(3, stik.Pop());
		assertEquals(2, stik.Pop());
		assertEquals(1, stik.Pop());
	}
	
	@Test
	public void testPopMulti()
	{
		Stack stik = new Stack();
		int[] nummer = new int[] {1,2,3,4,5};
		stik.Push(nummer);
		ArrayList<Integer> popped = stik.Pop(5);
		assertEquals(1, popped.get(0));
		assertEquals(2, popped.get(1));
		assertEquals(3, popped.get(2));
		assertEquals(4, popped.get(3));
		assertEquals(5, popped.get(4));
	}
	
	@Test
	public void testDoubleLength() 
	{
		Stack stik = new Stack();
		assertEquals(1,stik.elements.length);
		stik.Push(1);
		assertEquals(1,stik.elements.length);
		stik.Push(2);
		assertEquals(2,stik.elements.length);
		stik.Push(3);
		assertEquals(4,stik.elements.length);
		stik.Push(4);
		stik.Push(5);
		assertEquals(8,stik.elements.length);
		stik.Pop();
		assertEquals(8,stik.elements.length);
		assertEquals(4,stik.Pop());
		stik.Pop();
		stik.Pop();
		assertEquals(1,stik.Pop());
		
	}

}
