package util;

public class Node<T> { 
    T data; 
    Node<T> next, prev;
    public Node(T data, Node<T> next, Node<T> prev) { 
        this.data = data; 
        this.next = next; 
        this.prev = prev;
    } 
      
    public void setData(T data) { 
        this.data = data; 
    } 
      
    public void setNext(Node<T> next) { 
        this.next = next; 
    } 
    
    public void setPrev(Node<T> prev) {
    	this.prev = prev;
    }
      
    public T getData() { 
        return data; 
    } 
      
    public Node<T> getNext() { 
        return next; 
    } 
    
    public Node<T> getPrev(){
    	return prev;
    }
}
