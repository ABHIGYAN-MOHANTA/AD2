package LAB3;

import java.util.HashSet;

public class RemoveDuplicate {

	public static void main(String[] args) {
		String s = "Aplicability";
		System.out.println(s+" without duplicates is: "+removeDuplicate(s));
	}
	
	public static String removeDuplicate(String s) {
		HashSet<Character> hs = new HashSet<Character>();;
		for(int i =0; i < s.length(); i++) {
			if(!hs.add(s.charAt(i))) {
				s = s.substring(0,i) + s.substring(i+1); 
			}
		}
		return s;
	}
}