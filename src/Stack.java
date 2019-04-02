public class Stack
{
	int[] elements = new int[1];
	int topStack = 1; 
	
	public void Push(int value)
	{
		if(topStack > elements.length)
			elements = DoubleLength();
			
		elements[topStack] = value;
		topStack++;
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
}