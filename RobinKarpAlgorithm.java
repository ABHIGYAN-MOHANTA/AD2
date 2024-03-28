package LAB3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class RobinKarpAlgorithm {

	public static void main(String[] args) {
		String s = "abcaabc";
		String p = "abc";
		System.out.println(robinKarp(s,p));

	}
	
	public static ArrayList<Integer> robinKarp(String s, String p) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		// Encoding
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		HashSet<Character> hs = new HashSet<Character>();
		int c = 1;
		for(int i = 0; i< s.length(); i++) {
			if(hs.add(s.charAt(i))) {
				hm.put(s.charAt(i), c++);
			}
		}

		//build s number
		int num = 0;
		for(int i = 0; i< s.length(); i++) {
			num = num*10+hm.get(s.charAt(i));
		}

		
		//build p number
		int pnum = 0;
		for(int i = 0; i< p.length(); i++) {
			pnum = pnum*10+hm.get(p.charAt(i));
		}
		
		for(int i = 0; i< s.length() - p.length(); i++) {
			int tnum = 0;
			int cn = i;
			for(int j =0; j < p.length(); j++) {
				tnum = tnum*10+hm.get(s.charAt(cn++));
			}
			
			System.out.println(tnum);
			
			if(tnum == pnum) {
				a.add(i);
			}
					
		}
		
		return a;
		
	}

}
