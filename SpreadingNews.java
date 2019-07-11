import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SpreadingNews {
	private HashMap<Integer, ArrayList<Integer>> mySubs;
	
	public int minTime(int[] supervisors) {
		mySubs = new HashMap<>();
		for (int k = 0; k < supervisors.length; k++) {
			int reportTo = supervisors[k];
			mySubs.putIfAbsent(k, new ArrayList<>());
			mySubs.putIfAbsent(reportTo, new ArrayList<>());
			mySubs.get(reportTo).add(k);
		}
		return minForSupervisor(0);
		
	}
	
	private int minForSupervisor(int bossIndex) {
		ArrayList<Integer> subTimes = new ArrayList<>();
		for (int sub : mySubs.get(bossIndex)) {
			subTimes.add(minForSupervisor(sub));
		}
		Collections.sort(subTimes, Collections.reverseOrder());
		
		if (bossIndex == 0) {
			return 0;
		}
		
	}
}