package LINKED_LIST;

import LINKED_LIST.LinkedList.Node;

public class LinkedList_Palindrome_or_Not {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.addRecursive("a");
		list.addRecursive("b");
		list.addRecursive("c");
		list.addRecursive("d");
		list.addRecursive("c");
		list.addRecursive("b");
		list.addRecursive("a");

		System.out.println(isPalindrome(list));
	}

	private static boolean isPalindrome(LinkedList list) {
		Node slowPtr = list.head;
		Node prevSlowPtr = null;
		Node fastPtr = list.head;

		Node firstList = list.head;
		Node secondList = null;

		while (true) {
			if (fastPtr == null) { // Even List
				secondList = prevSlowPtr.next;
				prevSlowPtr.next = null;
				break;
			}
			if (fastPtr.next == null) {// Odd List
				secondList = slowPtr.next;
				prevSlowPtr.next = null;
				break;
			}

			prevSlowPtr = slowPtr;
			slowPtr = slowPtr.next;
			if (fastPtr.next != null)
				fastPtr = fastPtr.next.next;
			else
				fastPtr = null;
		}

		// Reversing the second list
		secondList = list.reverseRec(secondList);

		// Comparing First List and Second reversed List
		while (firstList.next != null) {
			if (firstList.data != secondList.data)
				return false;
			firstList = firstList.next;
			secondList = secondList.next;
		}
		return true;
	}
}
