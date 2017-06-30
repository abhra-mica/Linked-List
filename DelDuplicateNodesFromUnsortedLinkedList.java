package Linked_List;

import Linked_List.LinkedList.Node;

public class DelDuplicateNodesFromUnsortedLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		list1.addRecursive(1);
		list1.addRecursive(3);
		list1.addRecursive(2);
		list1.addRecursive(3);
		list1.addRecursive(5);
		list1.addRecursive(4);
		list1.addRecursive(5);
		list1.display(list1.head);
		System.out.println("\n=====================");

		list1.display(delDuplicateNodes(list1, 5));
	}

	static Node delDuplicateNodes(LinkedList<Integer> list, int higestNumber) {
		int[] hashing = new int[higestNumber+1];
		Node modifiedHead = list.head;
		Node previous = list.head;
		Node current = previous.next;

		hashing[(Integer) previous.data] = 1;

		while (current != null) {
			if (hashing[(Integer) current.data] == 1) {
				previous.next = previous.next.next;
				current = current.next;
			} else {
				hashing[(Integer) current.data]=1;
				current = current.next;
				previous = previous.next;
			}
		}
		return modifiedHead;
	}
}
