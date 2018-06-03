public class Queue {
	public int size = 0;

	private SimpleGraph.Node head;
	private SimpleGraph.Node last;

	public void add(SimpleGraph.Node n) {
		if (isEmpty()) {
			head = n;
			last = n;
			size = 1;
		} else {
			last.next = n;
			last = n;
			size++;
		}
	}

	public SimpleGraph.Node remove() {
		if (isEmpty()) throw new EmptyStackException();
		SimpleGraph.Node n  = head;
		head = head.next;
		size--;
		return n;
	}

	public int peek() {
		if (isEmpty()) throw new EmptyStackException();
		return head.data;
	}

	public boolean isEmpty() {
		return size == 0;
	}
}