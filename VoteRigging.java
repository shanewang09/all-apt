public class VoteRigging {
	public int minimumVotes(int[] votes) {
	
		int num = 0;
		
		while (largestCandidate(votes) != 0) {
			votes[largestCandidate(votes)]--;
			votes[0]++;
			num++;
		}
		
		return num;
		
	}
	
	public int largestCandidate(int[] votes) {
		int max = votes[0];
		int index = 0;

		for (int i = 0; i < votes.length; i++) {
			if (max <= votes[i]) {
				max = votes[i];
				index = i;
			}
		}
		
		return index;
	}
	
}