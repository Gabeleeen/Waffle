package Assignment3;

@Element(name="node")
public class Tree<T>
{
	private Tree<T>[] children = null;
	private T value;
	
	public Tree(T v, Tree<T>[] trees)
	{
		children = trees;
		value = v;
	}
	
	public Tree(T v)
	{
		value = v;
	}
	
	@SubElements(name="subnodes")
	public Tree<T>[] getChildren()
	{
		return children;
	}
	
	@ElementField(name="values")
	public T getValue()
	{
		return value;
	}
	
	@ElementField(name="Weow")
	public String getValue2()
	{
		return value.toString() + 123;
	}
}
