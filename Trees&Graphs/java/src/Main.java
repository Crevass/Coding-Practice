public class Main {
	public static void main(String[] args) {
		Methods method = new Methods();
		TreeNode tree = new TreeNode(4);
		tree.left = new TreeNode(2);
		//tree.left.left = new TreeNode(1);
		//tree.left.right = new TreeNode(3);

		tree.right = new TreeNode(9);
		//tree.right.right = new TreeNode(5);
		boolean result =  method.checkBST(tree);
		System.out.println(result);
	}
}