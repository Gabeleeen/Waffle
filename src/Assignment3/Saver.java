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
		
		String s = "<node";
		Method[] m = c.getMethods();
		for(Method met : m)
			if(met.getAnnotation(ElementField.class) != null) {
				String data = "";
				try {
					data = met.invoke(o).toString();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				s = s + " " + met.getAnnotation(ElementField.class).name() + "=" + '"' + data + '"';
			}
		s = s + ">\n";
		
		s = s + walk(o,"");
		s = s + "</node>\n";
		
		return s;
	}
	
	public String walk(Object t, String s)
	{
		s = s + "   ";
		String output = "";
		Object[] childs = new Object[0];
		for(Method m : t.getClass().getMethods())
			if(m.getAnnotation(SubElements.class) != null)
			{
				try 
				{
					childs = (Object[]) m.invoke(t);
				} 
				catch (IllegalAccessException e) 
				{
					e.printStackTrace();
				} 
				catch (IllegalArgumentException e) 
				{
					e.printStackTrace();
				} 
				catch (InvocationTargetException e) 
				{
					e.printStackTrace();
				}
			}
		
		if(childs == null || childs.length == 0)
			return output;
		
		
		
		String indent = s;
		output = s + "<subnodes>\n";
		s = s + "   ";
		for(Object child : childs)
		{
			Class<?> c = child.getClass();
			Method[] m = c.getMethods();
			output =  output + s + "<node";
			for(Method met : m)
				if(met.getAnnotation(ElementField.class) != null) 
				{
					String data = "";
					try 
					{
						data = met.invoke(child).toString();
					} 
					catch (IllegalAccessException e1) 
					{
						e1.printStackTrace();
					} 
					catch (IllegalArgumentException e1) 
					{
						e1.printStackTrace();
					} 
					catch (InvocationTargetException e1) 
					{
						e1.printStackTrace();
					}
					output = output + " " + met.getAnnotation(ElementField.class).name() + "=" + '"' + data + '"';
				}
			
			output = output + ">\n";
			output = output + walk(child,s);
		}
		
		output = output + indent + "</subnodes>\n";
		
		return output;
	}
	
	public static void main(String[] args)
	{
		Tree<String> t = new Tree<String>("top", new Tree[] { 
				new Tree("sub1", new Tree[] {
						new Tree("sub11"),
						new Tree("sub12"),
						new Tree("sub13")
				}), 
				new Tree("sub2") });
		Saver s = new Saver();
		String r = s.save(t);
		System.out.print(r);
	}
}
