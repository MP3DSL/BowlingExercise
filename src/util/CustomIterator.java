package util;

import java.util.Iterator;

import util.Node;

/**
 * This CustomIterator has the basic functions of a normal Iterator, but also allows traversing to the previous Node
 * <p>
 * This allows for quick moving back and forth between data that is adjacent to each other and not on complete opposite ends of the List without having to Iterate from the head or tail to search for the data
 * <p>
 * (Specifically Tailored for the Bowling Technical Exercise)
 * @author Derrick Lemmon
 *
 * @param <E> Generic Class reference to the type of data stored in the List
 */
public class CustomIterator<E> implements Iterator<E>{
	Node<E>	current;
	
	/**
	 * The same as a the default Iterator, but with the added functionality to traverse backwards
	 * @param list is a CustomList made for this CustomIterator
	 */
	public CustomIterator(CustomList<E> list) {
		current = list.getHead();
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}
	
	/**
	 * Returns true if the iteration has previous elements (In other words, returns true if prev() would return an element rather than throwing an exception)
	 * @return true if the iteration has a previous element
	 */
	public boolean hasPrev() {
		return current.getPrev() != null;
	}

	@Override
	public E next() {
		E data = current.getData();
		current = current.getNext();
		return data;
	}
	
	/**
	 * Returns the previous element in the iteration 
	 * @return the previous element in the iteration
	 */
	public E prev() {
		current = current.getPrev();
		E data = current.getData();
		return data;
	}
	
}
