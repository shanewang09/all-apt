// All done. 

import java.util.ArrayList;

public class PathSum {
	private ArrayList<Integer> sums = new ArrayList<>();
	
	public int hasPath(int target, TreeNode tree) {
		if (tree == null) {
			return 0;
		}
		
		summation(tree, 0);
		
		for (int nums : sums) {
			if (nums == target) return 1;
		}
		
		return 0;
	}
	
	private void summation (TreeNode dummy, int sum) {
		if (dummy == null) {
			return;
		}
		
		if (dummy.left == null && dummy.right == null) {
			sum += dummy.info;
			sums.add(sum);
			return;
		}
		
		sum += dummy.info;
		
		summation(dummy.left, sum);
		summation(dummy.right, sum);
	}
}