// All done. 
public class HeightLabel {
	public TreeNode rewire(TreeNode t) {
		if (t == null) return null;
		return new TreeNode(height(t), rewire(t.left), rewire(t.right));
	}
	
	private int height(TreeNode t) {
		if (t == null) return 0;
		return Math.max(height(t.left) + 1, height(t.right) + 1);
	}
}