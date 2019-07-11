import java.util.*;

public class OlympicCandles {
	public int numberOfNights(int[] candles) {
		ArrayList<Integer> candlesList = new ArrayList<>();
		for (int length : candles) {
			candlesList.add(length);
		}
		Collections.sort(candlesList, Collections.reverseOrder());
		int night = 1;
		while (true) {
			for (int i = 0; i < night; i++) {
				candlesList.set(i, candlesList.get(i) - 1);
			}
			Collections.sort(candlesList, Collections.reverseOrder());
			if ((night == candlesList.size()) || (candlesList.get(night) == 0)) {
				return night;
			}
			night += 1;
		}
	}
}