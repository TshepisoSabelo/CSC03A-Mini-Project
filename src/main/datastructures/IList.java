package datastructures;
public interface IList<T> 
{
  public int size();
  public boolean isEmpty();
  public T get(int i);
  public T set(int i , T item);
  public void add(int i ,T item);
  public T remove(int i);
}
