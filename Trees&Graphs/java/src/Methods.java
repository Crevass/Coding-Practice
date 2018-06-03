import java.util.LinkedList;
import java.util.ArrayList;

public class Methods {

	public void preOrderTraversal(TreeNode node) {
		if (node != null) {
			System.out.println(node.data);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	public boolean haveRoute(SimpleGraph g, int f, int t) {
		Queue queueFrom = new Queue();
		SimpleGraph.Node from = g.nodes[f];
		SimpleGraph.Node to = g.nodes[t];
		SimpleGraph.Node rFrom = null;
		from.marked = true;
		queueFrom.add(from);

		while (!queueFrom.isEmpty()) {
			rFrom = queueFrom.remove();
			if (rFrom == to && rFrom != null) {
				return true;
			}
			for (SimpleGraph.Node n:rFrom.neighbor) {
				if (n.marked == false) {
					n.marked = true;
					queueFrom.add(n);
				}
			}
		}
		return false;
	}

	public MinimalTreeNode createMinimalTree(int[] array) {

		return createSubTree(array, 0, array.length - 1);
	}
	private MinimalTreeNode createSubTree(int[] array, int leftindex, int rightindex) {
		if (leftindex > rightindex) return null;
		int midindex = leftindex + (int)((rightindex - leftindex) / 2);
		MinimalTreeNode mid = new MinimalTreeNode(array[midindex]);
		mid.left = createSubTree(array, leftindex, midindex - 1);
		mid.right = createSubTree(array, midindex + 1, rightindex);
		return mid;
	}

	private void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		if (root == null) return;
		LinkedList<TreeNode> list = null;
		if (lists.size() == level) {
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
	}

	public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}

	public ArrayList<LinkedList<TreeNode>> createLevelLinkedList2(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if (root != null) {
			current.add(root);
		}
		while (current.size() > 0) {
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for (TreeNode parent:parents) {
				if (parent.left != null) {
					current.add(parent.left);
				}
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}
		return result;
	}

	private class resultForBalanced {
		int height;
		boolean balanced;
		public resultForBalanced(int h, boolean b) {
			height = h;
			balanced = b;
		}
	}

	private resultForBalanced countBalance(TreeNode root) {
		if (root == null) {
			return new resultForBalanced(0, true);
		} 
		resultForBalanced leftResult = countBalance(root.left);
		resultForBalanced rightResult = countBalance(root.right);
		resultForBalanced current = new resultForBalanced(Math.max(rightResult.height, leftResult.height) + 1, true);
		if (leftResult.balanced == false || rightResult.balanced == false || Math.abs(rightResult.height - leftResult.height) > 1) {
			current.balanced = false;
		}
		return current;
	}
	public boolean checkBalanced(TreeNode root) {
		resultForBalanced result = countBalance(root);
		return result.balanced;
	}

	public boolean checkBST(TreeNode root) {
		if (root == null) return true;
		if (checkBST(root.right) == false) return false;
		if (checkBST(root.left) == false) return false;
		if (root.left != null) {
			if (root.left.data > root.data) return false;
		}
		if (root.right != null) {
			if (root.right.data <= root.data) return false;
		}
		return true;
	}

	private boolean checkBST(TreeNode root, int man) 
}
