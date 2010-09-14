public class Main {
	static class LinkedItem {
		int value;
		LinkedItem next;
 
		public LinkedItem(int value) {
			super();
			this.value = value;
		}
		
		public LinkedItem(int value, LinkedItem next) {
			super();
			this.value = value;
			this.next = next;
		}
	}
 
	private static LinkedItem reverseLinkedList(LinkedItem currentHead) {
		LinkedItem nextHead = null, previousHead = null;
		while (currentHead != null) {
			nextHead = currentHead;
			currentHead = nextHead.next;
			nextHead.next = previousHead;
			previousHead = nextHead;
		}
		return nextHead;
	}
	
	private static LinkedItem recursiveReverseLinkedList(LinkedItem currentHead) {
		if(currentHead == null) return null;
		return append(currentHead.value, recursiveReverseLinkedList(currentHead.next));
	}
	
	private static LinkedItem append(int x, LinkedItem currentHead) {
		if (currentHead == null) return new LinkedItem(x);
		return new LinkedItem(currentHead.value, append(x, currentHead.next));
	}
 
	public static void main(String[] args) {
		LinkedItem head = initializeSampleList();
		printLinkedList(head);
		head = reverseLinkedList(head);
		printLinkedList(head);
		
		// recursive
		head = initializeSampleList();
		printLinkedList(head);
		head = recursiveReverseLinkedList(head);
		printLinkedList(head);
	}
 
	private static LinkedItem initializeSampleList() {
		LinkedItem it = new LinkedItem(1), head = it;
		for (int i = 2; i < 10; i++) {
			LinkedItem it2 = new LinkedItem(i);
			it.next = it2;
			it = it2;
		}
		return head;
	}
 
	private static void printLinkedList(LinkedItem it) {
		while (it != null) {
			System.out.printf("%d ", it.value);
			it = it.next;
		}
		System.out.println();
	}
}