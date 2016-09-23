package datastructures;

public interface Iterator<T>
	extends java.util.Iterator<T>
{
	public void append(T valor);
	
	public void insert(T valor);
}
