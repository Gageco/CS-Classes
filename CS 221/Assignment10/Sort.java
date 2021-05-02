import java.util.Comparator;

/**
 * Class for sorting lists that implement the IndexedUnsortedList interface,
 * using ordering defined by class of objects in list or a Comparator. As
 * written uses Mergesort algorithm.
 *
 * @author gageco
 */
public class Sort {
	/**
	 * Returns a new list that implements the IndexedUnsortedList interface. As
	 * configured, uses WrappedDLL. Must be changed if using your own
	 * IUDoubleLinkedList class.
	 * 
	 * @return a new list that implements the IndexedUnsortedList interface
	 */
	private static <T> IndexedUnsortedList<T> newList() {
//		return new WrappedDLL<T>();
		return new IUDoubleLinkedList<T>();
	}

	/**
	 * Sorts a list that implements the IndexedUnsortedList interface using
	 * compareTo() method defined by class of objects in list. DO NOT MODIFY THIS
	 * METHOD
	 * 
	 * @param - <T> The class of elements in the list, must extend Comparable
	 * @param - list The list to be sorted, implements IndexedUnsortedList interface
	 * @see IndexedUnsortedList
	 */
	public static <T extends Comparable<T>> void sort(IndexedUnsortedList<T> list) {
		mergesort(list);

	}

	/**
	 * Sorts a list that implements the IndexedUnsortedList interface using given
	 * Comparator. DO NOT MODIFY THIS METHOD
	 * 
	 * @param <T> - The class of elements in the list
	 * @param list - The list to be sorted, implements IndexedUnsortedList interface
	 * @param c - The Comparator used
	 * @see IndexedUnsortedList
	 */
	public static <T> void sort(IndexedUnsortedList<T> list, Comparator<T> c) {
		mergesort(list, c);
	}

	/**
	 * Mergesort algorithm to sort objects in a list that implements the
	 * IndexedUnsortedList interface, using compareTo() method defined by class of
	 * objects in list. DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T> - The class of elements in the list, must extend Comparable
	 * @param list - The list to be sorted, implements IndexedUnsortedList interface
	 */
	private static <T extends Comparable<T>> void mergesort(IndexedUnsortedList<T> list) {
		
		IndexedUnsortedList<T> begList = newList();			//front half of the list
		IndexedUnsortedList<T> endList = newList();			//back half of the list
		
		int beg = 0;
		int end = list.size() - 1;
		int mid = (end + 1) / 2;
		
		int i = 0;
		for(T t : list) {									//for some reason this wasn't working with a regular for loop so I changed it which is a pain
			if(i++ < mid) {									//add to the front list if 'i' is before the middle
				begList.add(t);
			} else {										//add to the back list if 'i' is after the middle, including the middle
				endList.add(t);
			}
		}
		
		if (!(beg >= end)) {
			mergesort(begList);								//recursively use mergesort to break the list into further single elements
			mergesort(endList);
			
			for(i = 0; i < end+1; i++) {
				list.removeFirst();
			}
			
			merge(list, begList, mid, endList);

		}
	}

	/**
	 * Mergesort algorithm to sort objects in a list that implements the
	 * IndexedUnsortedList interface, using the given Comparator. DO NOT MODIFY THIS
	 * METHOD SIGNATURE
	 * 
	 * @param <T> - The class of elements in the list
	 * @param list - The list to be sorted, implements IndexedUnsortedList interface
	 * @param c - The Comparator used
	 */
	private static <T> void mergesort(IndexedUnsortedList<T> list, Comparator<T> c) {
		
		IndexedUnsortedList<T> begList = newList();			//front half of the list
		IndexedUnsortedList<T> endList = newList();			//back half of the list
		
		int beg = 0;
		int end = list.size() - 1;
		int mid = (end + 1) / 2;
		
		int i = 0;
		for(T t : list) {									//for some reason this wasn't working with a regular for loop so I changed it which is a pain
			if(i++ < mid) {									//add to the front list if 'i' is before the middle
				begList.add(t);
			} else {
				endList.add(t);
			}
		}
		
		if (!(beg >= end)) {
			mergesort(begList, c);
			mergesort(endList, c);
			
			for(i = 0; i < end+1; i++) {
				list.removeFirst();
			}
			
			merge(list, begList, endList, c);
		}
	}

	/**
	 * Private merge that can merge the beginning and end of the list combining it and returning it via the 
	 * list itself
	 * 
	 * @param list - The list to be sorted, implements IndexUnsortedList interface
	 * @param begList - the beginning half of the list
	 * @param mid - the integer in the representing the middle of the list
	 * @param endList - the end half of the list
	 */
	private static <T extends Comparable<T>> void merge(IndexedUnsortedList<T> list, IndexedUnsortedList<T> begList, int mid, IndexedUnsortedList<T> endList) {
		
		while (!endList.isEmpty() && !begList.isEmpty()) {
			if (begList.first().compareTo(endList.first()) <= 0) {
				list.add(begList.removeFirst());
			} else {
				list.add(endList.removeFirst());
			}
		}
		
		if (!begList.isEmpty()) {
			for (int i = 0; i < begList.size(); i++) {
				list.add(begList.removeFirst());
			}
		}
		
		if (!endList.isEmpty()) {
			for (int i = 0; i < endList.size()+1; i++) {
				list.add(endList.removeFirst());
			}
		}
	}
	
	/**
	 * Private merge that can merge the beginning and end of the list combining it and returning it via the 
	 * list itself
	 * 
	 * @param list - The list to be sorted, implements IndexUnsortedList interface
	 * @param begList - the beginning half of the list
	 * @param mid - the integer in the representing the middle of the list
	 * @param endList - the end half of the list
	 */
	private static <T> void merge(IndexedUnsortedList<T> list, IndexedUnsortedList<T> begList, IndexedUnsortedList<T> endList, Comparator<T> c) {
		
		while (!begList.isEmpty() && !endList.isEmpty()) {
			if (c.compare(begList.first(), endList.first()) < 0) {
				list.add(begList.removeFirst());
			} else {
				list.add(endList.removeFirst());
			}
		}
		
		if (!begList.isEmpty()) {
			for (int i = 0; i < begList.size(); i++) {
				list.add(begList.removeFirst());
			}
		}
		
		if (!endList.isEmpty()) {
			for (int i = 0; i < endList.size()+1; i++) {
				list.add(endList.removeFirst());
			}
		}
	}
}