package Linked_List;
import Linked_List.LinkedList.Node;

public class MergePointofTwoLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		 list1.addRecursive(1);
		 list1.addRecursive(2);
		 list1.addRecursive(3);
		 list1.addRecursive(4);
		 list1.addRecursive(5);
		 list1.addRecursive(6);
		 
		 System.out.println(list1.size());
		 
		 LinkedList<Integer> list2 = new LinkedList<>();
		 list2.addRecursive(9);
		 list2.addRecursive(9);
		 list2.addRecursive(9);
		 list2.addRecursive(9);
		
		 list2.head.next.next.next.next = list1.head.next;
		 System.out.println(list2.size());
		 
		 Node mergePoint = mergePoint(list1, list2);
		 if(mergePoint!= null)
			 System.out.println(mergePoint.data);
	}
	
public static Node mergePoint(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		Node<Integer> list1Head = list1.head;
		Node<Integer> list2Head = list2.head;
		int count = list1.size() - list2.size(); // Get difference between two linked list											
		/*
		 * Below if and else if blocks hand two different length of list and if
		 * two lists are equal also and it cover the extra length list
		 * traversal.
		 */
		if (count > 0) {
			while (count != 0) {
				list1Head = list1Head.next;
				count--;
			}

		} else if (count < 0) {
			while (count != 0) {
				list2Head = list2Head.next;
				count++;
			}
		}
		// From here both list have same nodes
		while (list1Head != null) {
			if (list1Head.data == list2Head.data) {
				return list1Head;
			}
			list1Head = list1Head.next;
			list2Head = list2Head.next;
		}

		return null;
	}
}
