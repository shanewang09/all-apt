
public class CounterAttack {
	public int[] analyze(String str, String[] words) {
		String[] strSplit = str.split(" ");

		int[] score = new int[words.length];

		for (int i = 0; i < words.length; i++) {
			String k = words[i];
			for (String j : strSplit) {
				if (k.equals(j)) {
					score[i] += 1;
				}
			}
		}
		return score;
	}
}