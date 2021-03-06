package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	private int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null){
			throw new NullPointerException("You can't add null elements");
		}
		LLNode<E> newNode = new LLNode<E>(element);
		tail.prev.next = newNode;
		newNode.prev = tail.prev;
		newNode.next = tail;
		tail.prev = newNode;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index > this.size-1 || index < 0 || this.size == 0){
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		LLNode current = this.head.next;
		int i = 0;
		while(i != index){
			i++;
			current = current.next;
		}
		return (E) current.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(index > this.size || index < 0){
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		if(element == null){
			throw new NullPointerException("You can't add null elements");
		}
		if (index==this.size){
			this.add(element);
		}else{
			LLNode current = this.head.next;
			int i = 0;
			while(i != index){
				i++;
				current = current.next;
			}
			LLNode newNode = new LLNode(element);
			current.prev.next = newNode;
			newNode.prev = current.prev;
			newNode.next = current;
			current.prev = newNode;
			this.size++;
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index > this.size-1 || index < 0 || this.size == 0){
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		LLNode current = this.head.next;
		int i = 0;
		while(i != index){
			i++;
			current = current.next;
		}
		E data = (E) current.data;
		current.prev.next = current.next;
		current.next.prev = current.prev;
		this.size--;
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index > this.size-1 || index < 0 || this.size == 0){
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		if(element == null){
			throw new NullPointerException("You can't add null elements");
		}
		LLNode current = this.head.next;
		int i = 0;
		while(i != index){
			i++;
			current = current.next;
		}
		E prevData = (E) current.data;
		current.data = element;
		return prevData;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
