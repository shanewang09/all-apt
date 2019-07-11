
// All done. 
import java.util.Arrays;
import java.util.Comparator;

public class ClientsList {
	public class Person /* implements Comparable<Person> */ {
		String first;
		String last;

		public Person(String s) {
			if (s.indexOf(",") == -1) {
				first = s.split(" ")[0];
				last = s.split(" ")[1];
			} else {
				first = s.split(", ")[1];
				last = s.split(", ")[0];
			}
		}

		public String getLast() {
			return last;
		}

		public String getFirst() {
			return first;
		}

		@Override
		public String toString() {
			return this.getFirst() + " " + this.getLast();
		}

//		public int compareTo(Person p) {
//			int ldiff = last.compareTo(p.last);
//			if (lastComp != 0) {
//				return ldiff;
//			}
//			return first.compareTo(p.first);
//		}
	}

	public String[] dataCleanup(String[] names) {
		Person[] list = new Person[names.length];
		for (int i = 0; i < names.length; i++) {
			Person name = new Person(names[i]);
			list[i] = name;
		}

//	    Comparator<Person> comp = Comparator.comparing(Person::getLast);
//	    comp = comp.thenComparing(Person::getFirst);

		Arrays.sort(list, Comparator.comparing(Person::getLast)
									.thenComparing(Person::getFirst));

		for (int k = 0; k < names.length; k++) {
			names[k] = list[k].toString();
		}

		return names;
	}
}