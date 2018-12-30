/* Stephen Barrack
 * cssc0868
 * Program #1
 */
package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayLinearList<E> implements LinearListADT<E>{

	private E[] array;
	private int max, size, first, last;
	private Iterator<E> i;
	
	public ArrayLinearList(int max) {
		this.max = max;
		array = (E[]) new Object[max];
		size = 0;
		first = 1;
		last = 0;
	}
	
	public ArrayLinearList() {
		this(DEFAULT_MAX_CAPACITY);
	}
	
	public boolean addFirst(E obj) {
		if(isFull())
			return false;
		if(first == 0)
			first = max;
		first--;
		array[first] = obj;
		size++;
		return true;
	}
	
	public boolean addLast(E obj) {
		if(isFull())
			return false;
		if(last == max - 1)
			last = -1;
		last++;
		array[last] = obj;
		size++;
		return true;
	}

	public E removeFirst() {
		if(isEmpty())
			return null;
		E elem = array[first];
		if(first >= max - 1)
			first = -1;
		first++;
		size--;
		return elem;
	}

	public E removeLast() {
		if(isEmpty())
			return null;
		E elem = array[last];
		if(last <= 0)
			last = max;
		last--;
		size--;
		return elem;
	}

	public E remove(E obj) {
		if(isEmpty())
			return null;
		int here = -1;
		E temp = null;
		if(last < first) {
			for(int i = 0; i <= last; i++) {
				if(((Comparable<E>)obj).compareTo(array[i]) == 0) {
					here = i;
					break;
				}
			}
			if(here == -1) 
				for(int i = first; i < max; i++) {
					if(((Comparable<E>)obj).compareTo(array[i]) == 0) {
						here = i;
						break;
					}
				}
			temp = array[here];
			if(here >= first) {
				for(int i = here; i < max - 1; i++) {
					array[i] = array[i+1];
				}
				array[max-1] = array[0];
		        for(int i = 0; i < last; i++) {
					array[i] = array[i+1];
		        }
			}else {
				for(int i = here; i < last; i++) {
					array[i] = array[i+1];
				}
			}
		}else {
			for(int i = first; i <= last; i++) {
				if(obj == array[i]) {
					here = i;
					break;
				}
			}
			temp = array[here];
			for(int i = here; i < last; i++) {
				array[i] = array[i+1];
			}
		}
		if(last <= 0)
			last = max;
		last--;
		size--;
		return temp;
	}

	public E peekFirst() {
		if(isEmpty())
			return null;
		return array[first];
	}

	public E peekLast() {
		if(isEmpty())
			return null;
		return array[last];
	}

	public boolean contains(E obj) {
		return find(obj) != null;
	}

	public E find(E obj) {
		for(E temp : this)
			if(((Comparable<E>)obj).compareTo(temp) == 0)
				return temp;
		return null;
	}

	public void clear() {
		size = 0;
		first = 1;
		last = 0;
	}

	public boolean isEmpty() {
		return size <= 0;
	}

	public boolean isFull() {
		return size >= max;
	}

	public int size() {
		return size;
	}

	public Iterator<E> iterator() {
		return new IteratorHelper();
	}
	
	class IteratorHelper implements Iterator<E> {
		
		private int index, p;
				
		public IteratorHelper() {
				index = first;
				p = 0;
		}
		
		public boolean hasNext() {
			return p != size;
		}

		public E next() {
			if(!hasNext()) 
				throw new NoSuchElementException();
			E temp = array[index++];
			if(index == max)
				index = 0;
			p++;
			return temp;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
}
