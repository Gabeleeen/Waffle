package Assignment2;

public class FilterTest extends Filter
{

	@Override
	boolean accept(String condition) 
	{
		if(condition.length() >= 3)
			return true;
		
		return false;
	}
	
	public static void main(String[] args)
	{
		Filter f = new FilterTest();
		String[] filtered = f.filter(args);
		for(String s : filtered)
			System.out.println(s);
	}

}
