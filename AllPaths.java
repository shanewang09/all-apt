// All done.

import java.util.ArrayList;
import java.util.Collections;

public class AllPaths {
	private ArrayList<String> myList = new ArrayList<>();
	
	public String[] paths(TreeNode t) {
		
		if (t == null) {
			String[] list = new String[0];
			return list;
		}
		
		doPaths(t, "");

		Collections.sort(myList);
		String[] list = new String[myList.size()];
		list = myList.toArray(list);
		
		return list;
	}
	
	private void doPaths(TreeNode root, String path) {
		if (root == null) {
			return;
		}
		
		if (root.left == null && root.right == null) {
			path = path + root.info;
			myList.add(path);
			return;
		}
		
		path = path + root.info + "->";
		
		doPaths(root.left, path);
		doPaths(root.right,path);
		
	}
}