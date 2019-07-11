import java.util.Arrays;
import java.util.HashMap;

public class LeafTrails {
	private HashMap<Integer, String> paths = new HashMap<>();
	public String[] trails(TreeNode tree) {
		paths (tree, "");
		
		String [] stringPath = new String[paths.size()];
		
		Object[] nums = paths.keySet().toArray();
		Arrays.sort(nums);
		
		for (int i = 0; i < stringPath.length;i++) {
			stringPath[i] = paths.get(nums[i]);
		}
		
		return stringPath;
	}
	
	private void paths (TreeNode tree, String path) {
		if (tree == null) {
			return;
		}
		
		if (tree.left == null && tree.right == null) {
			paths.put(tree.info, path);
			return;
		}
		
		paths (tree.left, path + "0");
		paths (tree.right, path + "1");
		
	}
}