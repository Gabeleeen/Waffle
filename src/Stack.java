import java.util.ArrayList;
import java.util.Collections;

public class Stack
{
	int[] elements = new int[1];
	int topStack = -1; 
	
	public void Push(int value)
	{
		if(topStack + 1 >= elements.length)
			elements = DoubleLength();
			
		topStack++;
		elements[topStack] = value;
	}
	
	public void Push(int[] values)
	{
		for(int e : values)
			Push(e);
	}
	
	private int[] DoubleLength()
	{
		int[] newStack = new int[elements.length*2];
		
		for(int i = 0; i < elements.length; i++)
		{
			newStack[i] = elements[i];
		}
		
		return newStack;
	}
	
	public int Pop()
	{
		topStack--;
		return elements[topStack + 1];
	}
	
	public ArrayList<Integer> Pop(int n)
	{
		ArrayList<Integer> popped = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++)
			popped.add(Pop());
		
		Collections.reverse(popped);
		return popped;
	}
}