// All done. 

public class TreeCount {
	public int count(TreeNode tree) {
		if (tree == null) {
			return 0;
		}
		
		int left = count(tree.left);
		int right = count(tree.right);
		
		return (left + right + 1);
	}
}