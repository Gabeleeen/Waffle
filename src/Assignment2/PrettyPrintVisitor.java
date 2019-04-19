package Assignment2;

public class PrettyPrintVisitor<T> implements TreeVisitor<T, String> 
{
	private int row = 0;
	
	@Override
	public String visit(Tree<T> t, String initialResult) 
	{
		return t.accept(this, initialResult);
	}

	@Override
	public String visit(Leaf<T> l, String initialResult) 
	{
		return l.getValue().toString() + "\n";
	}

	@Override
	public String visit(Node<T> n, String initialResult) 
	{
		StringBuilder stringbuilder = new StringBuilder();
		if(row == 0)
		{
			stringbuilder.append("\n"+"Root" + "\n");
		}
		else
		{
			stringbuilder.append("Node" + "\n");
		}
		row++;
		for(Tree<T> child: n.getChildren())
		{
			for(int i = 0; i < row; i++)
			{
				stringbuilder.append("\t");
			}
			stringbuilder.append(child.accept(this, initialResult));
		}
		row--;
		return stringbuilder.toString();
	}

}
