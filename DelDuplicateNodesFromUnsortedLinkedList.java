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
		delDuplicateNodes(list1, 5);
		list1.display(list1.head);
	}

	
	//Asuming we know the highest number present in the linked list.If we don't know then we have to take Integer.MAX_VALUE
	public static void delDuplicateNodes(LinkedList<Integer> list, int higestNumber) {
		int[] hashing = new int[higestNumber+1];
		Node previous = list.head;   //previous used to delete the next duplicate node
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
	}
}
