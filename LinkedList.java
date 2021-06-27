package LINKED_LIST;

import LINKED_LIST.LinkedList.Node;

public class DetectAndDeleteLoopFromLinkedList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		for (int i = 1; i < 7; i++) {
			list.add(i);
		}

		list.head.next.next.next.next.next.next = list.head.next.next.next;
		detectAndDeleteLoop(list);
		list.display();
	}

	/*
	 * First detect loop's existence then find starting point of loop
	 */

	public static void detectAndDeleteLoop(LinkedList list) {
		Node fastPointer = list.head;
		Node slowPointer = list.head;
		// Detecting Loop is present or not using Hare and Tortoise Algorithm
		while (slowPointer != null && fastPointer != null && fastPointer.next != null
				&& fastPointer.next.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer == fastPointer) {
				System.out.println("Loop is present");
				break;
			}
		}
		// Find starting point of the loop using Floyed cycle algorithm
		slowPointer = list.head;

		while (slowPointer.next != fastPointer.next) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
		}
		System.out.println("Start point of loop is " + slowPointer.next.data);
		// Remove loop
		fastPointer.next = null;
	}
}
