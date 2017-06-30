package Linked_List;

import static Linked_List.LinkedList.*;

/*Steps:-
 * 1> Split the linked list in the middle.
 * 2>Prepare two linked lists,if odd ignore the middle node.
 * 3>Reverse the second linked list.
 * 4>Compare the two linked list.
 *  */

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

	static boolean isPalindrome(LinkedList list) {
		Node slowPtr = list.head;
		Node fastPtr = list.head;

		Node firstList = list.head;
		Node secondList = null;
		Node firstListEndNode = list.head;    //This variable to hold the last element of first list
		while (true) {
			if (fastPtr == null) { // Even List
				secondList = slowPtr.next;
				firstListEndNode.next = null;
				break;
			}
			if (fastPtr.next == null) {// Odd List
				secondList = slowPtr.next;
				firstListEndNode.next = null;
				break;
			}
			//Below if block for calculating the last element of the first list
			if (firstListEndNode.equals(slowPtr))     
				firstListEndNode = firstListEndNode.next;

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
