/*  Stephen Barrack
    cssc0868
    Program #2
*/
package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class LinearList<E extends Comparable<E>> implements LinearListADT<E>{
	
	private Node<E> head, tail;
	private int size;
	private long count;
	
	public LinearList() {
		head = tail = null;
		count = 0;
		size = 0;
	}

	public boolean addFirst(E obj) {
		Node<E> tmp = new Node<E>(obj);
		if(head == null) 
			head = tail = tmp;
		else {
			tmp.next = head;
			head.prev = tmp;
			head = tmp;
		}
		size++;
		count++;
		return true;
	}

	public boolean addLast(E obj) {
		Node<E> tmp = new Node<E>(obj);
		if(head == null) 
			head = tail = tmp;
		else {
			tail.next = tmp;
            tmp.prev = tail;
	        tail = tmp;
		}
		size++;
		count++;
		return true;
	}

	
	public E removeFirst() {
		if(head == null)
			return null;
		E tmp = head.data;
		head = head.next;
		if(head == null)
			tail = null;
		size--;
		count++;
		return tmp;
	}

	public E removeLast() {
		if(head == null)
			return null;
		E tmp = tail.data;
		tail = tail.prev;
		tail.next = null;
		if(tail == null)
			head = null;
		size--;
		count++;
		return tmp;
	}

	public E remove(E obj) {
		if(head == null)
			return null;
		Node<E> curr = head;
        while (curr != null && (obj.compareTo(curr.data) != 0)) 
            curr = curr.next;
        if (curr == null) 
        	return null;
        if(size == 1){
            head = tail = null;
            size--;
            count++;
            return curr.data;
        }
        if (curr == head) 
        	return removeFirst();
        if (curr == tail) 
        	return removeLast();
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;
        count++;
        return curr.data;
	}

	public E peekFirst() {
		if(isEmpty())
			return null;
		return head.data;
	}

	public E peekLast() {
		if(isEmpty())
			return null;
		return tail.data;
	}

	public boolean contains(E obj) {
		return find(obj) != null;
	}

	public E find(E obj) {
		for(E thing : this)
			if(obj.compareTo(thing) == 0)
				return thing;
		return null;
	}

	public void clear() {
		head = tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size <= 0;
	}

	public boolean isFull() {
		return false;
	}

	public int size() {
		return size;
	}

	public Iterator<E> iterator() {
		return new IteratorHelper();
	}
	
	class IteratorHelper implements Iterator<E> {
		
		private Node<E> thing;
		private long check;
				
		public IteratorHelper() {
			check = count;
			thing = head;
		}
		
		public boolean hasNext() {
			if(check != count)
				throw new ConcurrentModificationException();
			return thing != null;
		}

		public E next() {
			if(!hasNext()) 
				throw new NoSuchElementException();
			E tmp = thing.data;
			thing = thing.next;
			return tmp;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	class Node<T> {
		
		T data;
		Node<T> next, prev;
		
		Node(T obj){
			data = obj;
			next = prev = null;
		}
		
	}
	
}
