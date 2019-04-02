
public class Matrix 
{
	
	double[][] elements;
	
	public Matrix(int cols, int rows)
	{
		elements = new double[cols][rows];
	}
	
	public double Get(int row, int col) { return elements[row][col]; }
	
	public void Set(int row, int col, double value) { elements[row][col] = value; }
	
	public int ColCount() { return elements.length; }
	
	public int RowCount() { return elements[0].length; }
	
	public Matrix Multiply(Matrix other)
	{
		Matrix newMat = new Matrix(this.ColCount(), other.RowCount());
		
		for(int i = 0; i < this.RowCount(); i++)
			for(int j = 0; j < other.ColCount(); j++)
			{
				double val = 0;
				for(int k = 0; k < this.ColCount(); k++)
				{
					val += this.Get(i, k) * other.Get(k, j);
				}
				newMat.Set(i, j, val);
			}
			
		return newMat;
	}
}
