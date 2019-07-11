import java.util.Arrays;
import java.util.HashSet;

public class Starter {
	public int begins(String[] words, String first) {
		HashSet<String> store = new HashSet(Arrays.asList(words));
		
		char firstChar = first.charAt(0);
		
		int score = 0;
		for (String i : store) {
			if (firstChar == (i.charAt(0))) {
				score += 1;
			}
		}
		return score;
	}
}