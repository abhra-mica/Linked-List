package Linked_List;
import Linked_List.LinkedList.Node;

public class MergeTwoSortedLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		list1.addRecursive(10);
		list1.addRecursive(50);
		list1.addRecursive(70);
		list1.addRecursive(90);
		list1.addRecursive(100);

		LinkedList<Integer> list2 = new LinkedList<>();
		list2.addRecursive(20);
		list2.addRecursive(30);
		list2.addRecursive(40);
		list2.addRecursive(60);
		list2.addRecursive(80);

		Node node = mergeTwoSortedLinkedList(list1, list2);
		list1.display(node);
	}

	public static Node mergeTwoSortedLinkedList(LinkedList<Integer> list1,
			LinkedList<Integer> list2) {
		Node currentPtr = null;
		Node firstListPtr = null;
		Node secListPtr = null;
		Node newHead = null;

		/*
		 * Setting up the new head node and first and second pointer for the
		 * first time
		 */
		if ((Integer) list1.head.data < (Integer) list2.head.data) {
			newHead = currentPtr = list1.head;
			firstListPtr = currentPtr.next;
			secListPtr = list2.head;
		} else {
			newHead = currentPtr = list2.head;
			secListPtr = currentPtr.next;
			firstListPtr = list1.head;
		}

		// Through below while loop creating new list by comparing elements from both lists.
		while (firstListPtr != null && secListPtr != null) {
			if ((Integer) firstListPtr.data < (Integer) secListPtr.data) {
				currentPtr.next = firstListPtr;
				currentPtr = firstListPtr;
				firstListPtr = firstListPtr.next;
			} else if ((Integer) firstListPtr.data > (Integer) secListPtr.data) {
				currentPtr.next = secListPtr;
				currentPtr = secListPtr;
				secListPtr = secListPtr.next;
			}
		}
		
		//After above while loop one of the below while loop will execute.
		while (firstListPtr != null) {
			currentPtr.next = firstListPtr;
			firstListPtr = firstListPtr.next;
			currentPtr = currentPtr.next;
		}
		while (secListPtr != null) {
			currentPtr.next = secListPtr;
			secListPtr = secListPtr.next;
			currentPtr = currentPtr.next;
		}
		return newHead;
	}
}
