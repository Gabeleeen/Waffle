package Assignment3;

import java.lang.reflect.Method;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

public class Saver 
{
	
	public String save(Object o)
	{
		Class<?> c = o.getClass();
		Annotation e = c.getAnnotation(Element.class);
		
		if(e == null)
			throw new NullPointerException();
		
		Method[] m = c.getMethods();
		Annotation[] a = new Annotation[2];
		for(int i = 0; i < m.length; i++)
		{
			if(a[0] == null)
			{
				a[0] = m[i].getAnnotation(SubElements.class);
				if(a[0] == null)
					a[0]= m[i].getAnnotation(ElementField.class);
			}
			
			else
			{
				a[11] = m[i].getAnnotation(SubElements.class);
				if(a[1] == null)
					a[1]= m[i].getAnnotation(ElementField.class);
			}
				
				
		}
				
		
		return null;
	}
	
	public static void main(String[] args)
	{
		Tree<String> t = new Tree<String>("top", new Tree[] { new Tree("sub1"), new Tree("sub2") });
		Saver s = new Saver();
		String r = s.save(t);
		//System.out.print(r);
	}
}
