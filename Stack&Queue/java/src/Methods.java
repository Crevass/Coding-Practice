public class Methods {
	public MyStack<Integer> sortStack(MyStack<Integer> stack) {
		MyStack<Integer> sorted = new MyStack<Integer>();
		while (!stack.isEmpty()) {
			popAndSort2(stack, sorted);
		}
		return sorted;
	}
	private boolean popAndSort(MyStack<Integer> stack, MyStack<Integer> sorted) {
		int count = 0;
		int item = stack.pop();
		while (!sorted.isEmpty()) {
			if (item > sorted.peek()) {
				stack.push(sorted.pop());
				count++;
			} else {
				break;
			}
		}
		sorted.push(item);
		for (int i = 0; i < count; i++) {
			sorted.push(stack.pop());
		}
		return true;
	}

	private boolean popAndSort2(MyStack<Integer> stack, MyStack<Integer> sorted) {
		int item = stack.pop();
		while (!sorted.isEmpty()) {
			if (item > sorted.peek()) {
				stack.push(sorted.pop());
			} else {
				break;
			}
		}
		sorted.push(item);
		return true;
	}
}