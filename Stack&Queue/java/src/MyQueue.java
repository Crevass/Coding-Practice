public class MyQueue {
	private int count = 0;
	class Stack {
		private Node top;
		private int size = 0;

		public int pop() {
			if (isEmpty()) throw new EmptyStackException();
			int data = top.value;
			top = top.next;
			size--;
			return data;
		}

		public boolean push(int v) {
			Node n = new Node(v);
			n.next = top;
			top = n;
			size++;
			return true;
		}

		public boolean isEmpty() {
			return size == 0;
		}

	}

	class Node {
		public int value;
		public Node next;
		public Node(int v) {value = v;}
	}
	private Stack newestStack = new Stack();
	private Stack oldestStack = new Stack();

	public boolean add(int v) {
		newestStack.push(v);
		count++;
		return true;
	}

	public int remove() {
		if (count == 0) throw new EmptyStackException();
		if (oldestStack.isEmpty()) {
			new2old();
		}
		count--;
		int data = oldestStack.pop();
		return data;
	}

	private boolean new2old() {
		if (count == 0) throw new EmptyStackException();
		while (!newestStack.isEmpty()) {
			oldestStack.push(newestStack.pop());
		}
		return true;
	}

	public boolean isEmpty() {
		return count == 0;
	}

}