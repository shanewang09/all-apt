
public class Anonymous {
	public int howMany(String[] headlines, String[] messages) {
		String all = "";
		for(String s : headlines) {
			all += s.toLowerCase();
		}
		int count = 0;
		for(String mess : messages) {
			if (canMake(mess.toLowerCase(),all)) {
				count += 1;
			}
		}
		return count;
	}

	private boolean canMake(String message, String headline) {
		for(char ch = 'a'; ch <= 'z'; ch += 1) {
			int mcount = count(message,ch);
			int hcount = count(headline,ch);
			
			if (mcount > hcount) {			
				return false;
			}
		}
		return true;
	}

	private int count(String s, char ch) {
		int t = 0;
		for(char c : s.toCharArray()) {
			if (c == ch) t++;
		}
		return t;
	}
}

