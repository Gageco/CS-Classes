/**
 * Node represents a node in a linked list.
 *
 * @author Java Foundations, mvail, gagecoprivnicar
 * @version 4.0
 */
public class Node<E> {
	private Node<E> next, prev;
	private E element;

	/**
  	 * Creates an empty node.
  	 */
	public Node() {
		next = null;
		prev = null;
		element = null;
	}

	/**
  	 * Creates a node storing the specified element.
 	 *
  	 * @param elem
  	 *            the element to be stored within the new node
  	 */
	public Node(E elem) {
		next = null;
		prev = null;
		element = elem;
	}

	/**
 	 * Returns the node that prefaces this one.
  	 *
  	 * @return the node that prefaces the current one
  	 */
	public Node<E> getPrevious() {
		return prev;
	}
	
	/**
 	 * Returns the node that follows this one.
  	 *
  	 * @return the node that follows the current one
  	 */
	public Node<E> getNext() {
		return next;
	}
	

	/**
 	 * Sets the node that follows this one.
 	 *
 	 * @param node
 	 *            the node to be set to follow the current one
 	 */
	public void setNext(Node<E> node) {
		next = node;
	}


	/**
 	 * Sets the node that prefaces this one.
 	 *
 	 * @param node the node to be set to prefaces the current one
 	 */
	public void setPrevious(Node<E> node) {
		prev = node;
	}
	
	/**
 	 * Returns the element stored in this node.
 	 *
 	 * @return the element stored in this node
 	 */
	public E getElement() {
		return element;
	}

	/**
 	 * Sets the element stored in this node.
  	 *
  	 * @param elem
  	 *            the element to be stored in this node
  	 */
	public void setElement(E elem) {
		element = elem;
	}

	@Override
	public String toString() {
		return "Element: " + element.toString() + " Has next: " + (next != null) + " Has previous: " + (prev != null);
	}
}
