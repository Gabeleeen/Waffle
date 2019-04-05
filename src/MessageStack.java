import java.util.ArrayList;

public class MessageStack
{
	Message[] elements = new Message[1];
	int topStack = 0; 
	
	/*
	 * elements.length >= 0
	 * 0 <= topStack < elements.length
	 */
	
	
	/**
	 * 
	 * @param message the message to be added
	 * @postcondition message != null
	 */
	public void Push(Message message)
	{
		if(topStack >= elements.length)
			elements = DoubleLength();
			
		elements[topStack] = message;
		topStack++;
	}
	
	public static void main()
	{
		
	}
	
	/** 
		Adds an array of messages to the top of the stack.
		@param messages array of messages to be added
		@precondition messages.length > 0
	*/
	public void Push(Message[] messages)
	{
		assert messages.length > 0: "Precondition 'messages.length > 0' failed, no messages to add";
		for(Message e : messages)
			Push(e);
	}
	
	/** 
		Doubles the length of the stack.
		@precondition Size() != 0
		@postcondition newStack.length >= 2
	*/
	private Message[] DoubleLength()
	{
		assert Size() != 0: "Precondition 'Size() != 0' failed, can't double a length of 0";
		Message[] newStack = new Message[elements.length*2];
		
		for(int i = 0; i < elements.length; i++)
		{
			newStack[i] = elements[i];
		}
		
		assert newStack.length >= 2: "Postcondition failed";
		
		return newStack;
	}
	
	/** 
    	Pops the item on the top of the stack and returns it.
    	@precondition Size() != 0
    	@postcondition elements[topStack] != null
	*/
	public Message Pop()
	{
		assert Size() != 0: "Precondition 'Size() != 0' failed, can't remove from empty stack";
		assert elements[topStack] != null: "Postcondition failed, element is null";
		return elements[topStack];
	}
	
	/**
	 	Returns the size of the MessageStack.
	 	@return Non-negative Integer
	 	@postcondition Size() >= 0
	 */
	public int Size()
	{
		assert (topStack) >= 0: "Postcondition failed, size is negative?";
		return topStack;
	}
	
	/** 
		Pops n items from the stack and returns them as a list.
		@precondition Size() > n > 0
		@postcondition popped.size() > 0
	*/
	public ArrayList<Message> Pop(int n)
	{
		assert n > 0: "Precondition 'Size() n > 0' failed";
		ArrayList<Message> popped = new ArrayList<Message>();
		
		for(int i = 0; i < n; i++)
			popped.add((n - 1) - i,Pop());
		
		assert popped.size() > 0: "Postcondition failed, no elements popped";
		return popped;
	}
}