import java.util.ArrayList;
import java.util.HashMap;

public class FindPath {
	private HashMap<Integer, String> p = new HashMap<>();
	
	public String path(TreeNode root, int target) {
		if (root == null) return null;
		
		helper(root, "");
		if (p.get(target) == null) return "nopath";
		return p.get(target);
	}
	
	public void helper(TreeNode root, String path) {
		if (root == null) return;
		p.putIfAbsent(root.info, path);
		if (p.containsKey(root.info) && path.length() < p.get(root.info).length()) {
			p.put(root.info, path);
		}
		helper(root.left, path + "0");
		helper(root.right, path + "1");
	}
}