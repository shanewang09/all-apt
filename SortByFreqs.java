// YOU MUST UNDERSTAND THIS CODE

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SortByFreqs {
	public String[] sort(String[] data) {
		TreeMap<String, Integer> map = new TreeMap<>();
		for (String s : data) {
			map.putIfAbsent(s, 0);
			map.put(s, map.get(s) + 1);
		}
		
		// "Entry" is an important concept here
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, 
				Collections.reverseOrder(
						Comparator.comparing(Map.Entry::getValue)));
		
		String[] s = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			s[i] = list.get(i).getKey();
		}
		
		return s;
	}
}