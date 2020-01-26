package util;

import util.CustomIterator;

/**
 * This CustomList data structure uses the bare essentials to make a List using the custom defined Node class that will be compatible with the CustomIterator
 * <p>
 * Using this will allow for efficient traversal through the CustomList for data that is adjecent or extremely close to each other without having to start from the head or tail of the CustomList
 * <p>
 * (Specifically Tailored for the Bowling Technical Exercise)
 * @author Derrick Lemmon
 *
 * @param <E> Generic Class reference to the type of data being added to the CustomList
 */
public class CustomList<E> implements Iterable<E> {
	Node<E> head, tail;
	int size = 0;
	
	/**
	 * Creates a Node with the data provided and appends it to the end of the CustomList
	 * @param data The information being stored within the CustomList
	 */
	public void add(E data) {
		Node<E> node = new Node<E>(data, null, null);
		if(head == null)
			tail = head = node;
		else {
			node.setPrev(tail);
			tail.setNext(node);
			tail = node;
		}
		size++;
	}
	
	/**
	 * Returns the head of the CustomList
	 * @return the head of the CustomList
	 */
	public Node<E> getHead(){
		return head;
	}
	
	/**
	 * Returns the tail of the CustomList
	 * @return the tail of the CustomList
	 */
	public Node<E> getTail(){
		return tail;
	}
	
	/**
	 * Returns the size of the CustomList
	 * @return the size of the CustomList
	 */
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		Node<E> current = head;
		String string = current.getData().toString();
		while(current.getNext() != null) {
			current = current.getNext();
			string += (", " + current.getData().toString());
		}
		return string;
	}
	
	public CustomIterator<E> iterator() {
		return new CustomIterator<E>(this);
	} 
}
