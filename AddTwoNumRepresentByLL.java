package Linked_List;
import Linked_List.LinkedList.Node;

public class AddTwoNumRepresentByLL {
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		list1.addRecursive(1);
		list1.addRecursive(2);
		list1.addRecursive(3);
		list1.addRecursive(4);
		list1.addRecursive(5);

		LinkedList<Integer> list2 = new LinkedList<>();
		list2.addRecursive(9);
		list2.addRecursive(6);
		list2.addRecursive(3);

		System.out.print("First Number : ");
		list1.display(list1.head);
		System.out.print("\nSecond Number : ");
		list2.display(list2.head);
		System.out.print("\nAfter Addition :  ");

		Node node = addTwoNumber(list1, list2);
		list1.display(node);
	}

	public static Node<Integer> addTwoNumber(LinkedList<Integer> list1,
			LinkedList<Integer> list2) {

		// Size of two Linked Lists
		int list1Size = list1.size();
		int list2Size = list2.size();

		// Below two lines are the head nodes of the two reversed linked list
		Node<Integer> node1 = list1.reverseRec(list1.head);
		Node<Integer> node2 = list2.reverseRec(list2.head);

		// Below two Lines for adding zeros at the end of the linked lists
		LinkedList<Integer> list1Reversed = new LinkedList<Integer>(node1);
		LinkedList<Integer> list2Reversed = new LinkedList<Integer>(node2);

		
		// Below IF and ELSE IF block to add zeros.This handle equal length lists also
		if (list1Size < list2Size) {
			for (int i = 0; i < list2Size - list1Size; i++) {
				list1Reversed.add(0);
			}
		} else if (list2Size < list1Size) {
			for (int i = 0; i < list1Size - list2Size; i++) {
				list2Reversed.add(0);
			}
		}

		// Below 3 lines are the helper variables for addition of two numbers.
		int addition = 0;
		int reminder = 0;
		int carry = 0;

		// Below 3 lines for the new result list
		LinkedList<Integer> resultList = new LinkedList<Integer>();
		Node resultHead = resultList.head;
		Node temp = null;

		// Below while loops are where the addition is happening
		while (node1 != null) {
			addition = (int) node1.data + (int) node2.data + carry;
			Node node = null;
			if (addition / 10 == 0) {
				node = new Node(addition);
				carry=0;
			} else {
				reminder = addition % 10;
				node = new Node(reminder);
				carry = addition / 10;
			}

			if (resultHead == null) {
				resultHead = node;
				temp = resultHead;
			} else {
				temp.next = node;
				temp = temp.next;
			}
			node1 = node1.next;
			node2 = node2.next;
		}

		if (carry != 0)
			temp.next = new Node(carry);

		resultHead = resultList.reverseRec(resultHead);
		return resultHead;
	}
}

		
