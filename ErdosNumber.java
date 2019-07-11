import java.util.*;

public class ErdosNumber {

	TreeMap<String, Set<String>> myGraph = new TreeMap<>();
	TreeMap<String, Integer> myDistance = new TreeMap<>();
	
	public String[] calculateNumbers(String[] pubs) {
		makeGraph(pubs);
		ArrayList<String> list = new ArrayList<>();
		bfsErdos();
		for (String s : myGraph.keySet()) {
			if (myDistance.containsKey(s)) {
				s = s + " " + myDistance.get(s);
			}
			list.add(s);
		}
		return list.toArray(new String[0]);
	}
	
	// dfs: stack (pre-order traversal); bfs: queue (level-order traversal);
	
	// create an entry (key) in the map myGraph for every author
	public void makeGraph(String[] pubs) {
		for (String s : pubs) {
			String[] author = s.split(" ");
			
			for (int i = 0; i < author.length; i++) {
				TreeSet<String> coauthors = new TreeSet<>(Arrays.asList(author));
				myGraph.putIfAbsent(author[i], new TreeSet<>());
				coauthors.remove(author[i]);
				myGraph.get(author[i]).addAll(coauthors);
			}			
		}
	}
	
	// invariant: every author put on the queue has its distance from ERDOS
	// stored in myDistance
	public void bfsErdos() {
		myDistance.put("ERDOS",0);
		Queue<String> qu = new LinkedList<>();
		qu.add("ERDOS");
		
		Set<String> visited = new TreeSet<>();
		visited.add("ERDOS");
		
		while (qu.size() > 0) {
			String author = qu.remove();
			
			for (String coauthor : myGraph.get(author)) {
				if (!(visited.contains(coauthor))) {
					myDistance.put(coauthor, myDistance.get(author) + 1);
					visited.add(coauthor);
					qu.add(coauthor);					
				}
			}
		}
			
//		public Set<String> bfs(String start){
//			Set<String> visited = new TreeSet<>();
//			Queue<String> qu = new LinkedList<>();
//			visited.add(start);
//			qu.add(start);
//			while (qu.size() > 0){
//		  		String v = qu.remove();
//		  		for(String adj : myGraph.getAdjacent(v)){
//		    			if (! visited.contains(adj)) {
//		        			visited.add(adj);
//		        			qu.add(adj);
//		    			}
//		  		}
//		}
//			return visited;
//		}

	}
}