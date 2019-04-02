/** 
    A first-in, first-out bounded collection of messages. 
*/ 
public class MessageQueue 
{ 
   /** 
       Constructs an empty message queue. 
       @param capacity the maximum capacity of the queue 
       @precondition capacity > 0
   */ 
   public MessageQueue(int capacity) 
   { 
	   assert capacity > 0: "Failed precondition, queue is empty";
	   elements = new Message[capacity]; 
	   count = 0; 
	   head = 0; 
	   tail = 0; 
   } 

   /** 
       Remove message at head. 
       @return the message that has been removed from the queue
       @precondition size() > 0 
   */ 
   public Message remove() 
   { 
	   assert count > 0: "Failed precondition, queue is empty";
	   Message r = elements[head]; 
	   head = (head + 1) % elements.length; 
	   count--; 
	   return r; 
   } 

   /** 
       	Append a message at tail. 
     	@param aMessage the message to be appended
   */ 
   public void add(Message aMessage) 
   { 
	   if(tail + 1 == head)
    	  elements = DoubleLength();
    	  
	   
	   elements[tail] = aMessage; 
	   tail = (tail + 1) % elements.length; 
	   count++; 
   } 
   
   private Message[] DoubleLength()
   {
	   assert count > 0: "Failed precondition, queue is empty";
	   Message[] newElem = new Message[elements.length * 2];
 	   for(int i = head; i < elements.length; i = (i + 1) % elements.length)
 	  		newElem[i] = elements[i];
 	  count *= 2;
 	  
 	  return newElem;
   }

   /** 
       Get the total number of messages in the queue. 
       @return the total number of messages in the queue 
   */ 
   public int size() 
   { 
      return count; 
   } 

   /** 
       Checks whether this queue is full
       @return true if the queue is full
   */ 
   public boolean isFull()
   { 
      return count == elements.length; 
   } 

   /** 
       Get message at head. 
       @return the message that is at the head of the queue 
       @precondition size() > 0 
   */ 
   public Message peek() 
   { 
	   assert count > 0: "Failed precondition, queue is empty";  
	   return elements[head]; 
   }

   private Message[] elements; 
   private int head; 
   private int tail; 
   private int count; 
}
