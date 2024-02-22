// Create a BST for 15, 27, 6, 82, 18, 4, 9, 65
import java.util.*;
public class Question1 {
	public static void main(String args[]) {
		int A[] = {15, 27, 6, 82, 18, 4, 9, 65};
		BST t = new BST();
		t.createBST(A);
		System.out.println("InOrder: ");
		t.inOrder(t.root);
		System.out.println("\nPreOrder: ");
		t.preOrder(t.root);
		System.out.println("\nPostOrder: ");
		t.postOrder(t.root);
		System.out.println("\nDelete: "+15);
		t.delete(t.root, 15);
	}
}

class BST {
	
	class Node{
		public int info;
		public Node left;
		public Node right;
		Node(int info){
			this.info = info;
			this.left = this.right = null;
		}
	}
	
	public Node root;
	
	public void createBST(int A[]) {
		
		Node temp = new Node(A[0]);
		root = temp;
		for(int i = 1; i < A.length; i++) {
			insert(root, A[i]);
		}
		
	}
	
	public void insert(Node temp, int k) {
		Node t = new Node(k);
		while(true) {
		if(k > temp.info) {
			if(temp.right != null) {
				temp = temp.right;
			} else {
				temp.right = t;
				return;
			}
		} else {
			if(temp.left != null) {
				temp = temp.left;
			} else {
				temp.left = t;
				return;
			}
		}
		}
		
	}
	
	public void inOrder(Node root) {
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.info+", ");
			inOrder(root.right);
		}
	}
	
	public void preOrder(Node root) {
		if(root != null) {
			System.out.print(root.info+", ");
			preOrder(root.left);
			preOrder(root.right);
		}
		
	}
	public void postOrder(Node root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.info+", ");
		}
	}
	
	public void delete(Node temp, int k) {
		while(temp != null) {
		if(temp.info == k) {
			System.out.println(k);
			if(temp.left == null && temp.right == null) {
				temp = null;
			}
			return;
		} else{
			delete(temp.left, k);
			delete(temp.right, k);
		}
		
		}
	}
	
}
