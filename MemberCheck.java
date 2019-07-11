import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class MemberCheck {
	public String[] whosDishonest(String[] club1, String[] club2, String[] club3) {

		/*
		 * Set<String> result = new HashSet<>();
		 * Set<String> s1 = new HashSet<>(Arrays.asList(club1));
		 * Set<String> s2 = new HashSet<>(Arrays.asList(club2));
		 * Set<String> s3 = new HashSet<>(Arrays.asList(club3));
		 * 
		 * result.addAll(intersection(s1,s2));
		 * result.addAll(intersection(s1,s3));
		 * result.addAll(intersection(s2,s3));
		 * String[] ret = result.toArray(new String[0]);
		 * Arrays.sort(ret);
		 * return ret;
		 */
		
		ArrayList<String> dishonest = new ArrayList<>();
		
		// Comparing between club one and club two, and storing the string 
		// if and only if it does not appear already in the list and if it is repeated
		for (int i = 0; i < club1.length; i++) {
			for (int j = 0; j < club2.length; j++) {
				if (club1[i].equals(club2[j]) && !dishonest.contains(club1[i])) {
					dishonest.add(club1[i]);
				}
			}
		}
		// Comparing between club one and club three
		for (int i = 0; i < club1.length; i++) {
			for (int j = 0; j < club3.length; j++) {
				if (club1[i].equals(club3[j]) && !dishonest.contains(club1[i])) {
					dishonest.add(club1[i]);
				}
			}
		}
		// Comparing between club two and club three
		for (int i = 0; i < club2.length; i++) {
			for (int j = 0; j < club3.length; j++) {
				if (club2[i].equals(club3[j]) && !dishonest.contains(club2[i])) {
					dishonest.add(club2[i]);
				}
			}
		}
		
		// We now have all the names. The following alphabetizes everything. 
		Collections.sort(dishonest);
				
		// Converting ArrayList back to Array
		String[] dishonestArray = new String[dishonest.size()];
		dishonestArray = dishonest.toArray(dishonestArray);
		
		return dishonestArray;
	}
}