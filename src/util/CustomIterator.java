package util;

import java.util.Iterator;

import util.Node;

public class CustomIterator<T> implements Iterator<T>{
	Node<T>	current;
	
	public CustomIterator(CustomList<T> list) {
		current = list.getHead();
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}
	
	public boolean hasPrev() {
		return current.getPrev() != null;
	}

	@Override
	public T next() {
		T data = current.getData();
		current = current.getNext();
		return data;
	}
	
	public T prev() {
		current = current.getPrev();
		T data = current.getData();
		return data;
	}
	
}
