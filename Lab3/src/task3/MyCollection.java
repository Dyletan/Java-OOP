package task3;


public interface MyCollection<E> extends Iterable<E>{
	void add(Object o);
	void remove(Object o);
	int size();
	boolean isEmpty();
	void empty();
	int hashCode();
	boolean equals(Object o);
	boolean contains(Object o);
}
