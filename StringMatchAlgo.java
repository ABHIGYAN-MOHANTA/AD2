package LAB3;

import java.util.ArrayList;

public class StringMatchAlgo {

	public static void main(String[] args) {
		String s = "abcaabccabcba";
		String p = "abc";
		System.out.println(findShift(s,p));
	}
	
	public static ArrayList<Integer> findShift(String s, String p) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i = 0; i< s.length() - p.length(); i++) {
			String substring = "";
			int c = i;
			for(int j = 0; j < p.length(); j++) {
				substring += s.charAt(c++);
			}
			
			if(substring.equals(p)) {
				a.add(i);
			}	
		}
		return a;
	}
}
