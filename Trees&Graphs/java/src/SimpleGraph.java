import java.util.ArrayList;

public class SimpleGraph {
	public int size = 0;
	public Node[] nodes;
	public boolean initialRandomGraph() {
		this.size = (int)(3 + Math.random() * 4);
		nodes = new Node[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node((int)(Math.random() * 100));
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (Math.random() > 0.5 && i != j) {
					nodes[i].neighbor.add(nodes[j]);
				}
			}
		}

		return true;
	}

	public boolean connected(int from, int to) {
		if (nodes[from].neighbor.contains(nodes[to])) return true;
		else return false;
	}
	class Node {
		public int data;
		public Node next;
		public boolean marked = false;
		public ArrayList<Node> neighbor;
		public Node(int d) {
			data = d;
			neighbor = new ArrayList<Node>();
		}
	}
}

