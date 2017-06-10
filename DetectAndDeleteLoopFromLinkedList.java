package Linked_List;

import static Linked_List.LinkedList.*;

public class DetectAndDeleteLoopFromLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		for (int i = 1; i < 7; i++) {
			list.add(i);
		}

		list.root.next.next.next.next.next.next = list.root.next.next.next;
		Node node = detectAndDeleteLoop(list.root);
		list.display(node);
	}

	/*
	 * This function is taking the root node and from , then it detect the loop
	 * is present or not and then find the starting point of the loop and at
	 * last it remove the loop by nullifying the the last element connection
	 */

	public static Node detectAndDeleteLoop(Node node) {
		Node fastPointer = node;
		Node slowPointer = node;
		// Detecting Loop is present or not
		while (slowPointer != null && fastPointer != null
				&& fastPointer.next != null && fastPointer.next.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer == fastPointer) {
				System.out.println("Loop is present");
				break;
			}
		}
		// Find starting point of the loop
		slowPointer = node;

		while (slowPointer.next != fastPointer.next) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
		}
		System.out.println("Start point of loop is " + slowPointer.next.data);
		// Remove loop
		fastPointer.next = null;
		return node;
	}
}
