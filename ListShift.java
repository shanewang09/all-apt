public class ListShift {
	public ListNode shift(ListNode start, int key) {
		ListNode headGreater = null;
		ListNode greater = null;
		ListNode headLess = null;
		ListNode less = null;
		
		while (start != null) {
			if (start.info > key) {
				if (greater == null) {
					headGreater = new ListNode(start.info);
					greater = headGreater;
				}
				else {
					greater.next = new ListNode(start.info);
					greater = greater.next;
				}
			}
			
			else {
				if (less == null) {
					headLess = new ListNode(start.info);
					less = headLess;
				}
				else {
					less.next = new ListNode(start.info);
					less = less.next;
				}
			}
			start = start.next;
		}
		
		if (greater == null) return headLess;
		
		greater.next = headLess;
		return headGreater;
	}
}