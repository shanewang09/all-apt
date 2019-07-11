import java.util.*;

public class FriendScore {
	// Person #; Value
	private TreeMap<Integer, List<Character>> myGraph = new TreeMap<>();
	private TreeMap<Integer, HashSet<Integer>> myFirstFriends = new TreeMap<>();
	private TreeMap<Integer, HashSet<Integer>> mySecondFriends = new TreeMap<>();
	
	public int highestScore(String[] friends) {
		makeGraph(friends);
		firstFriends();
		secondFriends();
		
		int max = 0;
		for (int k : mySecondFriends.keySet()) {
			if (mySecondFriends.get(k).size() > max) {
				max = mySecondFriends.get(k).size() - 1;
			}
		}
		
		return max;
	}
	
	public void firstFriends() {
		
		for (int person = 0; person < myGraph.size(); person++) {
			myFirstFriends.putIfAbsent(person, new HashSet<Integer>());
			for (int friend = 0; friend < myGraph.size(); friend++) {
				if (myGraph.get(friend).get(person) == 'Y') {
					HashSet<Integer> set = myFirstFriends.get(person);
					set.add(friend);
					myFirstFriends.put(person, set);
				}
			}
		}
	}
	
	public void secondFriends() {
		for (int person = 0; person < myFirstFriends.size(); person++) {
			mySecondFriends.putIfAbsent(person, new HashSet<Integer>());
			for (int friend : myFirstFriends.get(person)) {
				// Get friend and add all of HIS/HER friends
				mySecondFriends.get(person).addAll(myFirstFriends.get(person));
				mySecondFriends.get(person).addAll(myFirstFriends.get(friend));
			}
		}
	}
	
	public void makeGraph(String[] friends) {
		for (int person = 0; person < friends.length; person++) {
			char[] charArray = friends[person].toCharArray();
			
			ArrayList<Character> charList = new ArrayList<>();
			for (char a : charArray) {
				charList.add(a);
			}
			
			myGraph.put(person, charList);
		}
	}
}