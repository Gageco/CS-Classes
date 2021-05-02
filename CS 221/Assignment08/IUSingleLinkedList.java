import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Single-linked node implementation of IndexedUnsortedList.
 * An Iterator with working remove() method is implemented, but
 * ListIterator is unsupported.
 * 
 * @author 
 * 
 * @param <T> type to store
 */
public class IUSingleLinkedList<T> implements IndexedUnsortedList<T> {
	private Node<T> head, tail;
	private int size;
	private int modCount;
	
	/** Creates an empty list */
	public IUSingleLinkedList() {
		head = tail = null;
		size = 0;
		modCount = 0;
	}

	@Override
	public void addToFront(T element) {
		Node <T> newHeadNode = new Node(element);
		if (isEmpty()) {
			head = newHeadNode;
			tail = newHeadNode;
		} else {
			newHeadNode.setNext(head);
			head = newHeadNode;
		}
		size++;
		modCount++;
	}

	@Override
	public void addToRear(T element) {
		/*
		 * Some Visualization 
		 * [A] [B] [C] [D] [E] [null]
		 *  ^				^
		 * head    		   tail
		 * 
		 * if the head is empty/null, it sets the head and is done with it
		 * 
		 * otherwise
		 * nextNode & prevNode are set to head
		 * the while loop then is trying to find the final node in the list by setting prevNode to the nextNode, and nextNode to nextNode.getNext()
		 * [A] [B] [C] [D] [E] [null]
		 *  ^				
		 *prev
		 *next  
		 *
		 * [A] [B] [C] [D] [E] [null]
		 *  ^	^		
		 *prev next 
		 *
		 * [A] [B] [C] [D] [E] [null]
		 *	    ^   ^		
		 *	  prev next 
		 *...so on...
		 *
		 * [A] [B] [C] [D] [E] [null]
		 *			    ^   ^		
		 *	 		  prev next
		 *
		 * [A] [B] [C] [D] [E] [null]
		 *				    ^    ^		
		 *	 		  	   prev next
		 *then next is null and the while loop kicks out, and the prevNode is used to set the next node.
		 *
		 *This logic also works for a size 2 LinkedList
		 * [A] [B] [null]
		 * 
		 * [A] [B] [null]
		 *  ^				
		 *prev
		 *next 
		 * 
		 * [A] [B] [null]
		 *  ^	^			
		 *prev  next
		 * 
		 * [A] [B] [null]
		 * 		^	 ^			
		 *	  prev  next
		 *then once again the while loop kicks out and prev is used to set the next node.
		 */
		add(element);
	}

	@Override
	public void add(T element) {
		if (head == null) {
			head = new Node<T>(element);
			tail = head;
		} else {
			Node<T> newTail = new Node<T>(element);
			tail.setNext(newTail);
			tail = newTail;
			
		}
		modCount++;
		size++;	
	}

	@Override
	public void addAfter(T element, T target) {
		int index = indexOf(target);
		if (index == -1) {
			throw new NoSuchElementException();
		}
		add(index, element);
	}

	@Override
	public void add(int index, T element) {
		 if ((index < 0 || index > size)) {
			throw new IndexOutOfBoundsException();
		 }
		 Node<T> newNode = new Node<T>(element);
		 if (isEmpty()) {
			 head = newNode;
			 tail = newNode;
		 } else if (index == 0) {
				newNode.setNext(head);
				head = newNode;
		 } else if (index == size) {
			 tail.setNext(newNode);
			 tail = newNode;
		 } else {
			 Node<T> nextNode = head;
			 Node<T> prevNode = null;
			 for (int i = 0; i < index; i++) {
				 prevNode = nextNode;
				 nextNode = nextNode.getNext();
			 }
			 
			 prevNode.setNext(newNode);
			 newNode.setNext(nextNode);
		 }
		 
		 modCount++;
		 size++;
	}

	@Override
	public T removeFirst() {
		if (head == null) {
			throw new NoSuchElementException(); 
		}
		
		Node<T> oldHead = head;
		if (head.getNext() == null) {
			head = null;
		} else {
			head = head.getNext();
		}
		size--;
		modCount++;
		return oldHead.getElement();
	}

	@Override
	public T removeLast() {
		if (head == null) {
			throw new NoSuchElementException(); 
		}
		return remove(size-1);
	}

	@Override
	public T remove(T element) {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		boolean found = false;
		Node<T> previous = null;
		Node<T> current = head;
		
		while (current != null && !found) {
			if (element.equals(current.getElement())) {
				found = true;
			} else {
				previous = current;
				current = current.getNext();
			}
		}
		
		if (!found) {
			throw new NoSuchElementException();
		}
		
		if (size() == 1) { //only node
			head = tail = null;
		} else if (current == head) { //first node
			head = current.getNext();
		} else if (current == tail) { //last node
			tail = previous;
			tail.setNext(null);
		} else { //somewhere in the middle
			previous.setNext(current.getNext());
		}
		
		size--;
		modCount++;
		
		return current.getElement();
	}

	@Override
	public T remove(int index) {
		 if ((index < 0 || index > size)) {
			throw new IndexOutOfBoundsException();
		}
		return remove(get(index));
	}

	@Override
	public void set(int index, T element) {
		 if ((index < 0 || index >= size)) {
			throw new IndexOutOfBoundsException();
		}

		Node <T> currNode = head;
		for (int i = 0; i < index; i++) {
			currNode = currNode.getNext();
		}
		currNode.setElement(element);
		modCount++;
	}

	@Override
	public T get(int index) {
		 if ((index < 0 || index >= size)) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> currNode = head;
		Node<T> prevNode = head; 
		for (int i = 0; i < index+1; i++) {
			prevNode = currNode;
			currNode = currNode.getNext();
		}
		return prevNode.getElement();
	}

	@Override
	public int indexOf(T element) {
		if (head == null) {
			return -1;
		}
		int i = 0;
		Node <T> currNode = head;
		if (!contains(element)) {
			return -1;
		}
		while (element != currNode.getElement()) {
			currNode = currNode.getNext();
			i++;
		}
		return i;
	}

	@Override
	public T first() {
		if (head == null) { 
			throw new NoSuchElementException();
		}
		return head.getElement();
	}

	@Override
	public T last() {
		if (head == null) { 
			throw new NoSuchElementException();
		}
		return tail.getElement();
	}

	@Override
	public boolean contains(T target) {
		Node <T> currNode = head;
		
		for (int i = 0; i < size(); i++) {
			if (currNode.getElement() == target) {
				return true;
			} else {
				currNode = currNode.getNext();
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[");
		Node<T> currNode = head;
		for (int i = 0; i < size; i++) {
			str.append(currNode.getElement());
			str.append(", ");
			currNode = currNode.getNext();
		}
		if (size > 0) {
			str.delete(str.length()-2, str.length()); //drop trailing ", "
		}
		str.append("]");
		return str.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new SLLIterator();
	}

	@Override
	public ListIterator<T> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<T> listIterator(int startingIndex) {
		throw new UnsupportedOperationException();
	}

	/** Iterator for IUSingleLinkedList */
	private class SLLIterator implements Iterator<T> {
		private Node<T> nextNode, currNode, prevNode;
		private int iterModCount;
		private boolean nextHasBeenRun;

		
		/** Creates a new iterator for the list */
		public SLLIterator() {
			prevNode = null;
			currNode = null;
			nextNode = head;
			iterModCount = modCount;
			nextHasBeenRun = false;

		}

		@Override
		public boolean hasNext() {
			if (modCount != iterModCount) {
				throw new ConcurrentModificationException("Error");
			}
			return nextNode != null;
		}

		@Override
		public T next() {
			if (hasNext()) {
				prevNode = currNode;
				currNode = nextNode;
				nextNode = nextNode.getNext();
				
				nextHasBeenRun = true;
			} else {
				throw new NoSuchElementException("No more elements");
			}
			return currNode.getElement();
		}
		
		@Override
		public void remove() {
			if (modCount != iterModCount) {
				throw new ConcurrentModificationException("Error");
			}
			
			if (!nextHasBeenRun) {
				throw new IllegalStateException("Illegal State");
			}
			
			if (size() == 1) { //only node
				prevNode = null;
				currNode = null;
				nextNode = null;
			}  else {
				currNode = nextNode;
				prevNode.setNext(currNode);
				currNode = null;
			}
			
			size--;
			nextHasBeenRun = false;
		}
		
	}
}