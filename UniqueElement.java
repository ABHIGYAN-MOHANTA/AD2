package LAB3;

import java.util.HashSet;

public class UniqueElement {

	public static void main(String[] args) {
		String s = "apple";
		System.out.println(s+" has unique chars: "+hasUniqueCharacters(s));
	}
	
	public static boolean hasUniqueCharacters(String s) {
		HashSet<Character> hs = new HashSet<Character>();
		for(int i =0; i < s.length(); i++) {
			if(!hs.add(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
