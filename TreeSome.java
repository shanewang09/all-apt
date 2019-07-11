public class TreeSome {
	public int count(TreeNode root, int low, int high) {
		int num;
		if (root == null) {
			return 0;
		}
		if (root.info >= low && root.info <= high) {
			return 1 + count(root.left, low, high) + count(root.right, low, high);
		}
		else {
			return 0 + count(root.left, low, high) + count(root.right, low, high);
		}
	}
}