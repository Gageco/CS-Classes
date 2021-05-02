import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Array-based implementation of IndexedUnsortedList.
 * An Iterator with working remove() method is implemented, but
 * ListIterator is unsupported. 
 * 
 * @author 
 *
 * @param <T> type to store
 */
public class IUArrayList<T> implements IndexedUnsortedList<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private static final int NOT_FOUND = -1;
	
	private T[] array;
	private int rear;
	private int modCount;
	
	/** Creates an empty list with default initial capacity */
	public IUArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	/** 
	 * Creates an empty list with the given initial capacity
	 * @param initialCapacity
	 */
	@SuppressWarnings("unchecked")
	public IUArrayList(int initialCapacity) {
		array = (T[])(new Object[initialCapacity]);
		rear = 0;
		modCount = 0;
	}
	
	/** Double the capacity of array */
	private void expandCapacity() {
		array = Arrays.copyOf(array, array.length*2);
	}

	@Override
	public void addToFront(T element) {
		modCount++;
		
		for (int i = rear; i > 0; i--) {
			array[i] = array[i-1];
		}
		array[0] = element;
		rear++;
		if (rear >= array.length) {
			expandCapacity();
		}
	}

	@Override
	public void addToRear(T element) {
		modCount++;

		array[rear] = element;
		rear++;
		if (rear >= array.length) {
			expandCapacity();
		}
	}

	@Override
	public void add(T element) {
		modCount++;

		array[rear] = element;
		rear++;
		if (rear >= array.length) {
			expandCapacity();		
		}
	}

	@Override
	public void addAfter(T element, T target) {
		int index = indexOf(target);
		if (index == -1) {
			throw new NoSuchElementException("No such element");
		}

		add(index++, element);
	}

	@Override
	public void add(int index, T element) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Invalid index for insertion");
		}
		modCount++;

		for (int i = rear; i > index; i--) {
			array[i] = array[i-1];
		}
		array[index] = element;

		rear++;
		if (rear >= array.length) {
			expandCapacity();		
		}
	}

	@Override
	public T removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("No such element");
		}
		return remove(0);
	}

	@Override
	public T removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("No such element");
		}
		return remove(rear-1);
	}

	@Override
	public T remove(T element) {
		int index = indexOf(element);
		if (index == NOT_FOUND) {
			throw new NoSuchElementException();
		}
		
		T retVal = array[index];
		
		rear--;
		//shift elements
		for (int i = index; i < rear; i++) {
			array[i] = array[i+1];
		}
		array[rear] = null;
		modCount++;
		
		return retVal;
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= rear) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		
		T retVal = array[index];
		
		rear--;
		//shift elements
		for (int i = index; i < rear; i++) {
			array[i] = array[i+1];
		}
		array[rear] = null;
		modCount++;
		
		return retVal;
	}

	@Override
	public void set(int index, T element) {
		if (index < 0 || index >= rear) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		array[index] = element;
		modCount++;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= rear) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		return array[index];
	}

	@Override
	public int indexOf(T element) {
		int index = NOT_FOUND;
		
		if (!isEmpty()) {
			int i = 0;
			while (index == NOT_FOUND && i < rear) {
				if (element.equals(array[i])) {
					index = i;
				} else {
					i++;
				}
			}
		}
		
		return index;
	}

	@Override
	public T first() {
		if (!isEmpty()) {
			return array[0];
		} else {
			throw new NoSuchElementException("Array has no elements");
		}
	}

	@Override
	public T last() {
		if (!isEmpty()) {
			return array[rear-1];
		} else {
			throw new NoSuchElementException("Array has no elements");
		}	
	}

	@Override
	public boolean contains(T target) {
		return (indexOf(target) != NOT_FOUND);
	}

	@Override
	public boolean isEmpty() {
		return rear == 0;
	}

	@Override
	public int size() { 
		return rear;
	}

	@Override
	public Iterator<T> iterator() {
		return new ALIterator();
	}

	@Override
	public ListIterator<T> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<T> listIterator(int startingIndex) {
		throw new UnsupportedOperationException();
	}

	/** Iterator for IUArrayList */
	private class ALIterator implements Iterator<T> {
		private int nextIndex;
		private int iterModCount;
		private boolean nextHasBeenRun;
		
		public ALIterator() {
			nextIndex = 0;
			iterModCount = modCount;
			nextHasBeenRun = false;
		}

		@Override
		public boolean hasNext() {
			if (modCount != iterModCount) {
				throw new ConcurrentModificationException("Error");
			}
			return nextIndex < rear;
		}

		@Override
		public T next() {
			if (hasNext()) {
				T retT = array[nextIndex];
				nextIndex++;
				nextHasBeenRun = true;
				return retT;
			} else {
				throw new NoSuchElementException("No more elements");
			}
			
		}
		
		@Override
		public void remove() {
			if (modCount != iterModCount) {
				throw new ConcurrentModificationException("Error");
			}
			
			if (!nextHasBeenRun) {
				throw new IllegalStateException("Illegal State");
			}
			for (int i = nextIndex-1; i < rear-1; i++) {
				array[i] = array[i+1];
			}
			
			nextHasBeenRun = false;
			array[rear-1] = null;
			nextIndex--;
			modCount++;
			iterModCount++;
			rear--;			
		}
		
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[");
		for (int i = 0; i < rear; i++) {
			str.append(array[i]);
			str.append(", ");
		}
		if (rear > 0) {
			str.delete(str.length()-2, str.length()); //drop trailing ", "
		}
		str.append("]");
		return str.toString();
	}
}