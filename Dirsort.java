
import java.util.Arrays;
import java.util.Comparator;

public class Dirsort {
	public class DirComp implements Comparator<String> {
		
		@Override
		public int compare(String a, String b) {
			String[] arr = a.split("/");
			String[] brr = b.split("/");
			
			if (arr.length - brr.length != 0) return arr.length - brr.length;
			
			else {
				for (int k = 0; k < arr.length; k++) {
					int comp = arr[k].compareTo(brr[k]);
					if (comp != 0) return comp;
				}
			}
			return 0;
		}
	}
	
	public String[] sort(String[] dirs) {
		Arrays.sort(dirs, new DirComp());
		return dirs;
	}
}