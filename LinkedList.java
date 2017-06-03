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

	// 1a> recursively add nodes
	void addRecursive(int data) {
		if (root == null) {
			root = new Node(data);
			return;
		}
		Node node = root;
		recursiveSupport(node, data);
	}

	// Suportive method for addRecursive
	void recursiveSupport(Node node, int data) {
		if (node.next == null) {
			node.next = new Node(data);
			return;
		}
		recursiveSupport(node.next, data);
	}

	// 1b> add node in particular position

	void add(int data, int position) {
		Node node = root;
		int count = 0;
		while (count != position) {
			node = node.next;
			count++;
		}
		Node temp = node.next;
		node.next = new Node(data);
		node.next.next = temp;
	}

	// 2> display linked list
	public void display(Node node) {
		if (node != null)
			System.out.print(node.data);
		else
			return;
		if (node.next != null)
			System.out.print(" --> ");
		display(node.next);
	}

	// 3> delete a node from last
	void delete() {
		if (root == null) {
			System.out.println("Empty list");
			return;
		}

		if (root.next == null)
			root = null;
		Node node = root;
		while (node.next.next != null) {
			node = node.next;
		}
		node.next = null;
	}
}
