
public class IsomorphicWords {
	public int countPairs(String[] words) {
		int total = 0;

		for (int j = 0; j < words.length; j++) {
			String jword = iso(words[j]);
			for (int k = j + 1; k < words.length; k++) {
				String kword = iso(words[k]);
				if (jword.equals(kword)) {
					total += 1;
				}
			}
		}
		return total;
	}

	public String iso(String a) {
		// char[] testWord = a.toCharArray();
		
		char[] newWord = a.toCharArray();
		newWord[0] = 'a';
		char k = 'b';
		for (int i = 0; i < a.length(); i++) {
			for (int j = i + 1; j < a.length(); j++) {
				if (a.charAt(i) == a.charAt(j)) {
					newWord[j] = newWord[i];
				}
				else if (a.charAt(i) != a.charAt(j)) {
					newWord[j] = k;
					k++;
				}
			}
		}

		// Convert back to string
		String b = new String(newWord);
		return b;
	}
}

//public class IsomorphicWords {
//	public int countPairs(String[] words) {
//		int total = 0;
//		for(int j=0; j < words.length; j++) {
//			for(int k=j+1; k < words.length; k++) {
//				if (isomorphic(words[j],words[k])) {
//					total += 1;
//				}
//			}
//		}
//		return total;
//	}
//
//	private boolean isomorphic(String a, String b) {
//		char map[] = new char[500];
//		for(int k=0; k < a.length(); k++) {
//			char ac = a.charAt(k);
//			char bc = b.charAt(k);
//			if (map[ac] == 0) {
//				map[ac] = bc;
//			}
//			else if (map[ac] != bc) {
//				return false;
//			}
//		}
//		Set<Character> ss = new HashSet<>();
//		int tot = 0;
//		for(int k=0; k < map.length; k++) {
//			if (map[k] != 0) {
//				ss.add(map[k]);
//				tot += 1;
//			}
//		}
//		return tot == ss.size();
//	}
//	public static void main(String[] args) {
//		String[] s = {"aaa","baa","cdd","ddd"};
//		IsomorphicWords iw = new IsomorphicWords();
//		System.out.println(iw.countPairs(s));
//	}
//}
