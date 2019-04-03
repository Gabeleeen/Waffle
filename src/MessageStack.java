import java.util.ArrayList;

public class MessageStack
{
	Message[] elements = new Message[1];
	int topStack = - 1; 
	
	public void Push(Message message)
	{
		if(topStack + 1 >= elements.length)
			elements = DoubleLength();
			
		topStack++;
		elements[topStack] = message;
	}
	
	/** 
		Adds an array of messages to the top of the stack.
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
		@postcondition DoubleLength().length != 0
	*/
	private Message[] DoubleLength()
	{
		assert Size() != 0: "Precondition 'Size() != 0' failed, can't double a length of 0";
		Message[] newStack = new Message[elements.length*2];
		
		for(int i = 0; i < elements.length; i++)
		{
			newStack[i] = elements[i];
		}
		
		return newStack;
	}
	
	/** 
    	Pops the item on the top of the stack and returns it.
    	@precondition Size() != 0
    	@postcondition Pop() != null
	*/
	public Message Pop()
	{
		assert Size() != 0: "Precondition 'Size() != 0' failed, can't remove from empty stack";
		topStack--;
		return elements[topStack + 1];
	}
	
	/**
	 	Returns the size of the MessageStack.
	 	@return Non-negative Integer
	 	@postcondition Size() >= 0
	 */
	public int Size()
	{
		return topStack + 1;
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
		
		
		return popped;
	}
}