import java.util.*;

public class HuffmanDecoding {
	// HashMap example: 00: 'A'
	HashMap<String, String> dict = new HashMap<>();

	public String decode(String archive, String[] dictionary) {
		dict(dictionary);

		String word = "";

		int j = 0;		
		for (int i = j; i <= archive.length(); i++) {
			if (dict.containsKey(archive.substring(j, i))) {
				word += dict.get(archive.substring(j, i));
				j = i;
			}
		}
		return word;
	}

	private void dict(String[] dictionary) {
		char key = 'A';
		for (String value : dictionary) {
			String keyString = String.valueOf(key);
			dict.put(value, keyString);
			key += 1;
		}
	}
}