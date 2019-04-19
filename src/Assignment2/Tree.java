package lecture7.visitorpassres;

public interface Tree<T> {
	<R> R accept(TreeVisitor<T, R> v, R initialResult);

}