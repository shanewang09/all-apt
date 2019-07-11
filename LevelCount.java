// All done. 

import java.util.ArrayList;

public class LevelCount {
	private ArrayList<Integer> list = new ArrayList<>();
	
	public int count(TreeNode t, int level) {
		nums(t, 0, level);
		return list.size();
	}
	
	private void nums (TreeNode dummy, int levelAt, int level) {
		if (dummy == null) {
			return;
		}
		
		if (levelAt == level) {
			list.add(levelAt);
			return;
		}
		levelAt += 1;
		
		nums(dummy.left, levelAt, level);
		nums(dummy.right, levelAt, level);
	}
}


//public class LevelCount {
//	public int count(TreeNode t, int level) {
//        if (t == null) return 0;
//        if (level == 0) return 1;
//        return count(t.left,level-1) + count(t.right,level-1);
//    }
//}
