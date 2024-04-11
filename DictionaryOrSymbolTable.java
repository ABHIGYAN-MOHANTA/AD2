package LAB4;

import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryOrSymbolTable {

	public static void main(String[] args) {
		DictionaryOrSymbolTable obj = new DictionaryOrSymbolTable();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your String:- ");
		String[] s = new String[20];
		for(int i =0; i <10; i++) {
			s[i] = sc.next();
		}
		
		for(int i = 0; i < 10; i++) {
			obj.addNode(s[i], i);
		}
		
		obj.show();
		}
	
	class TreeNode{
		String name;
		TreeNode left;
		TreeNode right;
		int cnt;
		ArrayList<Integer> poslist;
		TreeNode(String n, int pos){
			poslist = new ArrayList<Integer>();
			cnt = 1;
			name = n;
			poslist.add(pos);
			left = null;
			right = null;
		}
	}
	
	TreeNode root;
	
	public void addNode(String str, int p) {
	    if (root == null) {
	        root = new TreeNode(str, p);
	        System.out.println(str + " root node");
	    } else {
	        TreeNode parent = null;
	        TreeNode tmp = root;
	        while (tmp != null) {
	            parent = tmp;
	            int res = tmp.name.compareTo(str);
	            if (res == 0) {
	                tmp.cnt++;
	                tmp.poslist.add(p);
	                System.out.println(str + " repeat node");
	                return;
	            } else if (res > 0) {
	                tmp = tmp.left;
	            } else {
	                tmp = tmp.right;
	            }
	        }
	        if (parent.name.compareTo(str) > 0) {
	            parent.left = new TreeNode(str, p);
	            System.out.println(str + " new left node");
	        } else {
	            parent.right = new TreeNode(str, p);
	            System.out.println(str + " new right node");
	        }
	    }
	}

	
	void show() {
		TreeNode tmp = root;
		inOrder(tmp);
	}
	
	
	
	public void inOrder(TreeNode tmp) {
		if(tmp != null) {
			inOrder(tmp.left);
			System.out.println(tmp.name+", "+tmp.poslist);
			inOrder(tmp.right);
		}
	}
	
	
	

}

