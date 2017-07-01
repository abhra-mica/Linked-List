package Linked_List;

import Linked_List.LinkedList.Node;

public class Find_Nth_Node_From_Last {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.addRecursive("1");
		list.addRecursive("2");
		list.addRecursive("3");
		list.addRecursive("4");
		list.addRecursive("5");
		list.addRecursive("6");
		list.addRecursive("7");
		
		Node nthLastNode= findNthNodeFromLast(list,3);
		System.out.println("Nth Node from last-- " + nthLastNode.data);
	}

	static Node findNthNodeFromLast(LinkedList<String> list, int n) {

		Node actual = list.head;
		Node faster = list.head;
		int i = 0;
		while (i <= n - 1) {
			faster = faster.next;
			i++;
		}
		while (faster != null) {
			actual = actual.next;
			faster = faster.next;
		}
		return actual;
	}
}
