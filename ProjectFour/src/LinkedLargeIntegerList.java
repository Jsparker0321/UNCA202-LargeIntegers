/**
 * 
 * @author Jessica Parker
 * @version Project 4: Large Integers CSCI 202 December 5th, 2018 Professor
 *          Charley Sheaffer
 * @ @param
 *       <E>
 */

public class LinkedLargeIntegerList<E> {
	public class Node {

		private E data;
		private Node next;

		/**
		 * creates fields for a node
		 * 
		 * @param data
		 * @param next
		 */
		public Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}

		/**
		 * 
		 * @param data
		 */
		public Node(E data) {
			this(data, null);
		}

		public Node() {
			this(null, null);
		}

		/**
		 * 
		 * @return data
		 */
		public E getData() {
			return data;
		}

		/**
		 * 
		 * @return next node field
		 */
		public Node getNext() {
			return next;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public LinkedLargeIntegerList() {
		head = new Node();
		tail = head;
		size = 0;
	}

	/**
	 * 
	 * @return size of list
	 */
	public int size() {
		return size;
	}

	/**
	 * 
	 * @param index
	 * @return current node
	 */
	public Node getNodeBefore(int index) {
		Node current = head;
		for (int i = 0; i < index; i++)
			current = current.next;
		return current;
	}

	/**
	 * 
	 * @param index
	 * @return value of node
	 */
	public E get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("index: " + index);
		return getNodeBefore(index).next.data;
	}

	/**
	 * 
	 * @param element
	 */
	public void add(E element) {
		tail.next = new Node(element);
		tail = tail.next;
		size++;
	}

	/**
	 * 
	 * @return head of node
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * 
	 * @param index
	 * @param element
	 */
	public void add(int index, E element) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("index: " + index);
		Node previous = getNodeBefore(index);
		Node current = new Node(element, previous.next);
		previous.next = current;
		if (tail == previous)
			tail = current;
		size++;
	}
	
	public void clear() {
		head.next = null;
		tail = head;
		size = 0;
	}

	@Override
	public int hashCode() {
		int hash = 11;
		Node current = head.next;
		while (current != null) {
			hash = 23 * hash + current.data.hashCode();
			current = current.next;
		}
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		LinkedLargeIntegerList<E> list = (LinkedLargeIntegerList<E>) obj;
		if (size != list.size)
			return false;
		Node current = head.next;
		Node otherCurrent = list.head.next;
		while (current != null) {
			if (!current.data.equals(otherCurrent.data))
				return false;
			current = current.next;
			otherCurrent = otherCurrent.next;
		}
		return true;
	}

	@Override
	public String toString() {
		if (size == 0)
			return "[ ]";
		StringBuilder sb = new StringBuilder("[");
		Node current = head.next;
		while (current != null) {
			sb.append(current.data.toString() + ", ");
			current = current.next;
		}
		sb.setLength(sb.length() - 2);
		sb.append("]\t");
		return sb.toString();
	}

}