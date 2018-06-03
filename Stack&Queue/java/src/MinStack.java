public class MinStack {
	private class StackNode {
		private int data;
		private int min;
		private StackNode next;

		public StackNode(int data) {
			this.data = data;
			this.min = data;
		}
		public StackNode(int data, int min) {
			this.data = data;
			if (data < min) {
				this.min = data;
			} else {
				this.min = min;
			}
		}
	}

	private StackNode top;

	public void push(int item) {
		if (top == null) {
			top = new StackNode(item);
		}
		StackNode t = new StackNode(item, top.min);
		t.next = top;
		top = t;
	}

	public int pop() {
		if (top == null) {throw new EmptyStackException();}
		int d = top.data;
		top = top.next;
		return d;
	}

	public int peek() {
		if (top == null) {throw new EmptyStackException();}
		return top.data;
	}

	public int min() {
		if (top == null) {throw new EmptyStackException();}
		return top.min;
	}
}