public class Node {
	int data;
	Node next = null;

	public Node(int d) {
		data = d;
	}

	public void append(int d) {
		Node end = new Node(d);
		Node head = this;
		while (head.next != null) {
			head = head.next;			
		}
		head.next = end;
	}

	public void display(Node n) {
		Node current = n;
		while (current != null) {
			System.out.print(current.data);
			if (current.next != null) {
				System.out.print("->\0");
			}
			current = current.next;
		}
		System.out.println("\0");
	}

	public int getLength() {
		int count = 0;
		Node current = this;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
}