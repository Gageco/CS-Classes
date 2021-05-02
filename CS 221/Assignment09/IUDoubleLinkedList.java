import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @author Gage Coprivnicar
 * 
 * @param <T> type to store
 */
public class IUDoubleLinkedList<T> implements IndexedUnsortedList<T> {
	private Node<T> head, tail;
	private int size;
	private int modCount;
	
	/** Creates an empty list */
	public IUDoubleLinkedList() {
		head = tail = null;
		size = 0;
		modCount = 0;
	}
	
	/**
	 * adds element to front of list
	 * @param T element
	 * @return void
	 * @throws none
	 */
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

	/**
	 * adds element to rear of list
	 * @param T element
	 * @return void
	 * @throws none
	 */
	@Override
	public void addToRear(T element) {
		add(element);
	}

	/**
	 * adds element to rear of list
	 * @param T element
	 * @return void
	 * @throws none
	 */
	@Override
	public void add(T element) {
		if (head == null) {
			head = new Node<T>(element);
			tail = head;
		} else {
			Node<T> newTail = new Node<T>(element);
			newTail.setPrevious(tail);
			tail.setNext(newTail);
			tail = newTail;
		}
		modCount++;
		size++;	
	}
	
	/**
	 * adds element after target element
	 * @param T element, T target
	 * @return void
	 * @throws NoSuchElement
	 */
	@Override
	public void addAfter(T element, T target) {
		int index = indexOf(target);
		if (index == -1) {
			throw new NoSuchElementException();
		}
		add(index+1, element);
	}
	
	public void addBefore(T element, T target) {
		int index = indexOf(target);
		if (index == -1) {
			throw new NoSuchElementException();
		}
		add(index-1, element);
	}
	
	/**
	 * adds element at specified index
	 * @param int index, T element
	 * @return void
	 * @throws IndexOutOfBounds
	 */
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
				head.setPrevious(newNode);
				head = newNode;
		 } else if (index == size) {
			 tail.setNext(newNode);
			 newNode.setPrevious(tail);
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
			 newNode.setPrevious(prevNode);
		 }
		 
		 modCount++;
		 size++;
	}
	
	/**
	 * removes first element
	 * @param none
	 * @return T removed element
	 * @throws NoSuchElement
	 */
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
			head.setPrevious(null);
		}
		size--;
		modCount++;
		return oldHead.getElement();
	}

	/**
	 * removes last element
	 * @param none
	 * @return T removed element
	 * @throws NoSuchElementException
	 */
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
			head.setPrevious(null);
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

	/**
	 * removes element at specified index
	 * @param int index
	 * @return T element removed
	 * @throws IndexOutOfBounds
	 */
	@Override
	public T remove(int index) {
		 if ((index < 0 || index > size())) {
			throw new IndexOutOfBoundsException();
		}
		return remove(get(index));
	}

	@Override
	public void set(int index, T element) {
		 if ((index < 0 || index >= size())) {
			throw new IndexOutOfBoundsException();
		}

		Node <T> currNode = head;
		for (int i = 0; i < index; i++) {
			currNode = currNode.getNext();
		}
		currNode.setElement(element);
		modCount++;
	}

	/**
	 * gets the element at the specified element
	 * @param int index
	 * @return T element
	 * @throws IndexOutOfBounds
	 */
	@Override
	public T get(int index) {
		 if ((index < 0 || index >= size())) {
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

	/**
	 * finds and returns the location of a specified element
	 * @param T element
	 * @return int index of element
	 * @throws none
	 */
	@Override
	public int indexOf(T element) {
		if (isEmpty()) {
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
	
	/**
	 * returns the element in the first index
	 * @param none
	 * @return T element
	 * @throws No Such Element
	 */
	@Override
	public T first() {
		if (isEmpty()) { 
			throw new NoSuchElementException();
		}
		return head.getElement();
	}

	/**
	 * returns the last element in the list
	 * @param none
	 * @return T element
	 * @throws NoSuchElement
	 */
	@Override
	public T last() {
		if (head == null) { 
			throw new NoSuchElementException();
		}
		return tail.getElement();
	}

	/**
	 * checks if specified element is in list
	 * @param T element
	 * @return boolean true if in list
	 * @throws none
	 */
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

	/**
	 * checks if list is empty
	 * @param none
	 * @return boolean, true if empty
	 * @throws none
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * checks size of the element
	 * @param none
	 * @return int size
	 * @throws none
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * formatted string of the list
	 * @param none
	 * @return String of list
	 * @throws none
	 */
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

	/**
	 * Iterators
	 * @param none
	 * @return DLLIterators
	 * @throws none
	 */
	@Override
	public Iterator<T> iterator() {
		return new DLLListIterator(0);
	}

	/**
	 * ListIterator
	 * @param none
	 * @return DLLListIterator
	 * @throws none
	 */
	@Override
	public ListIterator<T> listIterator() {
		return new DLLListIterator(0);
	}

	/**
	 * ListIterator
	 * @param int startingIndex
	 * @return DLLListIterator
	 * @throws none
	 */
	@Override
	public ListIterator<T> listIterator(int startingIndex) {
		return new DLLListIterator(startingIndex);
	}

    private class DLLListIterator implements ListIterator<T>{
        private Node<T> nextNode;
        private int nextIndex;
        private int iterModCount;
        private Node<T> lastNode;

    	/**
    	 * ListIterator constructor
    	 * @param int startingIndex
    	 * @return DLLListIterator
    	 * @throws IndexOutOfBounds
    	 */
        public DLLListIterator(int startingIndex){
            if(startingIndex < 0 || startingIndex > size){
                throw new IndexOutOfBoundsException();
            }
            nextNode = head;
            for(int i=0; i<startingIndex; i++){
                nextNode = nextNode.getNext();
            }
            nextIndex = startingIndex;
            iterModCount = modCount;
            lastNode = null;
        }
        
    	/**
    	 * checks if the list has a next node
    	 * @param none
    	 * @return boolean, true if there is a next node
    	 * @throws ConcurrentModification
    	 */
        @Override
        public boolean hasNext() {
            if(iterModCount != modCount){
                throw new ConcurrentModificationException();
            }
            return nextNode != null;
        }

    	/**
    	 * gets the next element and moves the cursor
    	 * @param none
    	 * @return the last element in the node passed
    	 * @throws NoSuchElement
    	 */
        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T returnValue = nextNode.getElement();
            lastNode = nextNode;
            nextNode = nextNode.getNext();
            nextIndex++;
            return returnValue;
        }

    	/**
    	 * checks if there is a previous node
    	 * @param none
    	 * @return boolean, true if there is a previous node
    	 * @throws ConcurrentModification
    	 */
        @Override
        public boolean hasPrevious() {
            if(iterModCount != modCount){
                throw new ConcurrentModificationException();
            }
            return nextNode != head;
        }

    	/**
    	 * moves the cursor back one
    	 * @param none
    	 * @return T the element passed when moving back
    	 * @throws NoSuchElement
    	 */
        @Override
        public T previous() {
            if(!hasPrevious()){
                throw new NoSuchElementException();
            }
            if(nextNode != null){
                nextNode = nextNode.getPrevious();
            }else{
                nextNode = tail;
            }
            nextIndex--;
            lastNode = nextNode;
            return nextNode.getElement();
        }

    	/**
    	 * gets the index of the next node
    	 * @param none
    	 * @return int of the next index
    	 * @throws ConcurrentModification
    	 */
        @Override
        public int nextIndex() {
            if(iterModCount != modCount){
                throw new ConcurrentModificationException();
            }
            return nextIndex;
        }

    	/**
    	 * gets the index of the previous node
    	 * @param none
    	 * @return int of the previous index
    	 * @throws ConcurrentModification
    	 */
        @Override
        public int previousIndex() {
            if(iterModCount != modCount){
                throw new ConcurrentModificationException();
            }
            return nextIndex - 1;
        }

    	/**
    	 * removes the node from the list
    	 * @param none
    	 * @return none
    	 * @throws ConcurrenbtModification, IllegalState
    	 */
        @Override
        public void remove() {
            if(iterModCount != modCount){
                throw new ConcurrentModificationException();
            }
            if(lastNode == null){
                throw new IllegalStateException();
            }
            if(lastNode.getPrevious() != null){
                lastNode.getPrevious().setNext(lastNode.getNext());
            }else{
                head = lastNode.getNext();
                if(head != null){
                    head.setPrevious(null);
                }
            }
            if(lastNode.getNext() != null){
                lastNode.getNext().setPrevious(lastNode.getPrevious());
            }else{
                tail = lastNode.getPrevious();
                if(tail != null){
                    tail.setNext(null);
                }
            }
            if(lastNode == nextNode){
                nextNode = nextNode.getNext();
            }else{
                nextIndex--;
            }
            size--;
            iterModCount++;
            modCount++;
            lastNode = null;

        }

    	/**
    	 * sets the element at the cursor location
    	 * @param T element
    	 * @return none
    	 * @throws ConcurrentModification, IllegalState
    	 */
        @Override
        public void set(T element) {
            if(iterModCount != modCount){
                throw new ConcurrentModificationException();
            }
            if(isEmpty()){
                throw new IllegalStateException();
            }
            if(lastNode == null){
                throw new IllegalStateException();
            }else if(lastNode != null){
                lastNode.setElement(element);
            }
            iterModCount++;
            modCount++;
        }

    	/**
    	 * adds the element at iterator location
    	 * @param T element
    	 * @return none
    	 * @throws ConcurrentModification
    	 */
        @Override
        public void add(T element) {
            if(iterModCount != modCount){
                throw new ConcurrentModificationException();
            }
            Node<T> newNode = new Node<T>(element);
            if(size == 0){
                head = tail = newNode;
            } else if (nextNode == head){
                newNode.setNext(head);
                head.setPrevious(newNode);
                head = newNode;
            } else if (nextNode == null){
                newNode.setPrevious(tail);
                tail.setNext(newNode);
                tail = newNode;
            } else{
                newNode.setNext(nextNode);
                newNode.setPrevious(nextNode.getPrevious());
                nextNode.getPrevious().setNext(newNode);
                nextNode.setPrevious(newNode);
            }
            size++;
            modCount++;
            iterModCount++;
            nextIndex++;

        }
    }
	
	/** Iterator for IUDoubleLinkedList */
	private class DLLIterator implements Iterator<T> {
		private Node<T> nextNode, currNode, prevNode;
		private int iterModCount;
		private boolean nextHasBeenRun;

		/** Creates a new iterator for the list 
		 * @param start */
		public DLLIterator() {
			prevNode = null;
			currNode = null;
			nextNode = head;
			iterModCount = modCount;
			nextHasBeenRun = false;
		}

		/**
		 * checks there is another node after the iterator
		 * @param none
		 * @return boolean, true if there is a next one
		 * @throws none
		 */
		@Override
		public boolean hasNext() {
			if (modCount != iterModCount) {
				throw new ConcurrentModificationException("Error");
			}
			return nextNode != null;
		}

		/**
		 * moves the iterator forward one 
		 * @param none
		 * @return T element
		 * @throws NoSuchElementException
		 */
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
		
		/**
		 * removes the node at the iterator
		 * @param none
		 * @return void
		 * @throws ConcurrentModification, IllegalState
		 */	
		@Override
		public void remove() {
			if (modCount != iterModCount) {
				throw new ConcurrentModificationException("Error");
			}
			
			if (!nextHasBeenRun) {
				throw new IllegalStateException("Illegal State");
			}
			
			if (currNode == head) {
				head = nextNode; // CHANGE
			}  else if (nextNode == null) {
				tail = prevNode; // CHANGE
			}  
			
			if (prevNode != null) {
				prevNode.setNext(nextNode);
			}
			
			size--;
			currNode = prevNode;  //CHANGE
			nextHasBeenRun = false;
		}	
	}
}