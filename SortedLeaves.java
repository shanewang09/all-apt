import java.util.ArrayList;
import java.util.Collections;

public class SortedLeaves {
	private ArrayList<String> words = new ArrayList<>();
	
	public String[] values(TreeNode tree) {
		nums(tree);
		Collections.sort(words);
		String[] out = new String[words.size()];
		out = words.toArray(out);
		return out;
	}
	
	private void nums(TreeNode tree) {
		if (tree == null) {
			return;
		}
		
		if (tree.left == null && tree.right == null) {
			char ascii = (char) tree.info;
			String string = Character.toString(ascii);
			words.add(string);
			return;
		}
		
		nums(tree.left);
		nums(tree.right);
	}
}