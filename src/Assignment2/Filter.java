package Assignment2;

public abstract class Filter
{
	public String[] filter(String[] arr)
	{
		int count = 0;
		String[] accepted = new String[arr.length];
		for(int i = 0; i < arr.length; i++)
			if(accept(arr[i]))
			{
				accepted[count] = arr[i];
				count++;
			}
		
		String[] toReturn = new String[count];
		for(int i = 0; i < count; i++)
			toReturn[i] = accepted[i];
		return toReturn;
	}
	
	abstract boolean accept(String condition);
}
