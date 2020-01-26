package util;

/**
 * The Node Class is the basic building blocks for all data structures
 * <p>
 * This Class was specifically created with the intention of traversing forwards and backwards in a custom iterator to save time when searching for data
 * <p>
 * (Specifically Tailored for the Bowling Technical Exercise)
 * @author Derrick Lemmon
 *
 * @param <E> Generic Class reference to the type of data within the Node
 */
public class Node<E> { 
    E data; 
    Node<E> next, prev;
    public Node(E data, Node<E> next, Node<E> prev) { 
        this.data = data; 
        this.next = next; 
        this.prev = prev;
    } 
    
    /**
     * Sets the data within the Node
     * @param data the data being set in the Node
     */
    public void setData(E data) { 
        this.data = data; 
    }
    
    /**
     * Links this Node to the Node after it
     * @param next the Node after this
     */
    public void setNext(Node<E> next) { 
        this.next = next; 
    } 
    
    /**
     * Links this Node to the Node before it
     * @param prev the Node before this
     */
    public void setPrev(Node<E> prev) {
    	this.prev = prev;
    }
    
    /**
     * Gets the data from this Node
     * @return the data from this Node
     */
    public E getData() { 
        return data; 
    }
    
    /**
     * Gets the Node after this one
     * @return the next Node
     */
    public Node<E> getNext() { 
        return next; 
    } 
    
    /**
     * Gets the Node before this one 
     * @return the previous Node
     */
    public Node<E> getPrev(){
    	return prev;
    }
}
