import java.util.ArrayList;

public class SetOfStacks {
	private int capacity;
	public SetOfStacks(int capacity){
		this.capacity = capacity;
	}
	private ArrayList<Stack> stacklist = new ArrayList<Stack>();

	public int pop() {
		if (stacklist.size() == 0) throw new EmptyStackException();
		Stack last = getLastStack();
		int item = last.pop();
		if (last.size == 0) stacklist.remove(stacklist.size() - 1);
		return item;
	}

	public void push(int v) {
		if (stacklist.size() == 0 || getLastStack().isFull()) {
			stacklist.add(new Stack(capacity));
		}
		Stack last = getLastStack();
		last.push(v);
	}

	public Stack getLastStack() {
		if (stacklist.size() == 0) return null;
		return stacklist.get(stacklist.size() - 1);
	}

	public boolean isEmpty() {
		return stacklist.size() == 0;
	}

	private int leftShift(int index, boolean removeTop) {
		Stack stack = stacklist.get(index);
		int item;
		if (removeTop) {
			item = stack.pop();
		} else {
			item = stack.removeBottom();
		}
		if (stack.size == 0) {
			stacklist.remove(index);
		} else if (stacklist.size() > index + 1) {
			int v = leftShift(index + 1, false);
			stack.push(v);
		}
		return item;
	}
	public int popAt(int index) {
		return leftShift(index, true);
	}

	class Node {
		public int value;
		public Node above;
		public Node below;
		public Node(int v) {
			this.value = v;
		}
	}

	class Stack {
		public int size = 0;
		public int capacity;
		public Node top, bottom;
		public Stack(int capacity) {
			this.capacity = capacity;
		}

		public boolean isFull() {
			return this.size == this.capacity;
		}

		public void join(Node above, Node below) {
			if (below != null) below.above = above;
			if (above != null) above.below = below;
		}

		public void push(int v) {
			Node n = new Node(v);
			size++;
			if (size == 1) {
				bottom = n;
				top = n;
			} else {
				n.below = top;
				top.above = n;
				top = n;
			}

		}

		public int pop() {
			Node n = top;
			top = top.below;
			size--;
			return n.value;
		}

		public int removeBottom() {
			if (size == 0) throw new EmptyStackException();
			Node n = bottom;
			bottom = bottom.above;
			if (bottom != null) bottom.below = null;
			size--;
			return n.value;
		}

	}
}