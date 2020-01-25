package util;

import java.util.Iterator;

import util.CustomIterator;

public class CustomList<T> implements Iterable<T> {
	Node<T> head, tail;
	
	public void add(T data) {
		Node<T> node = new Node<T>(data, null, null);
		if(head == null)
			tail = head = node;
		else {
			node.setPrev(tail);
			tail.setNext(node);
			tail = node;
		}
	}
	
	public Node<T> getHead(){
		return head;
	}
	
	public Node<T> getTail(){
		return tail;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new CustomIterator<T>(this);
	} 
}