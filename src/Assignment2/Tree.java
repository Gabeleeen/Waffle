package Assignment2;

public interface Tree<T> {
	<R> R accept(TreeVisitor<T, R> v, R initialResult);

}