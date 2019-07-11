import java.util.Arrays;
import java.util.HashSet;

public class SimpleWordGame {
	public int points(String[] player, String[] dictionary) {
		HashSet<String> S1 = new HashSet(Arrays.asList(player));
		HashSet<String> S2 = new HashSet(Arrays.asList(dictionary));
		S2.retainAll(S1);
		return this.score(S2);
	}
	
	private int score (HashSet<String> input) {
		int score = 0;
		for (String s : input) {
			score += s.length() * s.length();
		}
		return score;
	}
}
