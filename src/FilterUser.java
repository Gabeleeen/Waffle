
public class FilterUser implements Filter
{

	@Override
	public boolean accept(String x) 
	{
		if(x.length() >= 3)
			return true;
		
		return false;
	}
	
	public static void main(String[] args)
	{
		Filter f = new FilterUser();
		String[] filtered = filter(args,f);
		for(String s : filtered)
			System.out.println(s);
	}
	
	
	public static String[] filter(String[] a, Filter f)
	{
		String[] accepted = new String[a.length];
		
		int amt = 0;
		for(int i = 0; i < a.length; i++)
			if(f.accept(a[i]))
			{
				accepted[amt] = a[i];
				amt++;
			}
		
		String[] toReturn = new String[amt];
		for(int i = 0; i < amt; i++)
			toReturn[i] = accepted[i];
		
		return toReturn;
	}
}
