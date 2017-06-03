package Linked_List;

public class LinkedList {

	public Node root;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	// 1> add new node at the end of the linked list
	public void add(int newData) {
		Node temp = new Node(newData);
		if (root == null)
			root = temp;
		else {
			Node node = root;
			while (node.next != null)
				node = node.next;
			node.next = temp;
		}
	}

	// 2> display linked list

	public void display(Node node) {
		
		if(node != null)
		System.out.print(node.data);
		else
			return;
		if(node.next != null)
		System.out.print(" --> ");
		display(node.next);
	}

}
