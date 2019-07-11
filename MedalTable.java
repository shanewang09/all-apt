import java.util.*;

public class MedalTable {
	
	public class Medals {
		
		private String country;
		private int gold;
		private int silver;
		private int bronze;
		
		public Medals(String data) {
			country = data;
		}
		
		public int getGold() {
			return gold;
		}
		
		public int getSilver() {
			return silver;
		}
		
		public int getBronze() {
			return bronze;
		}
		
		public String getCountry() {
			return country;
		}
		
		@Override
		public String toString() {
			return country + " " + gold + " " + silver + " " + bronze;
		}
	}
	
	public String[] generate(String[] results) {
		Map<String, Medals> map = new HashMap<>();
		for (String s : results) {
			String[] data = s.split(" ");
			for (int k = 0; k < 3; k++) {
				map.putIfAbsent(data[k], new Medals(data[k]));
			}
			map.get(data[0]).gold += 1;
			map.get(data[1]).silver += 1;
			map.get(data[2]).bronze += 1;
		}
		
		ArrayList<Medals> list = new ArrayList<>(map.values());
		
		list.sort(Comparator.comparing(Medals::getCountry));
		list.sort(Collections.reverseOrder(Comparator.comparing(Medals :: getBronze)));
		list.sort(Collections.reverseOrder(Comparator.comparing(Medals :: getSilver)));
		list.sort(Collections.reverseOrder(Comparator.comparing(Medals :: getGold)));
		
		String[] ret = new String[list.size()];
		for (int k = 0; k < ret.length; k++) {
			ret[k] = list.get(k).toString();
		}
		return ret;
	}
	
	
}