package LAB3;

public class RabinKarpAlgo {
    public final static int d = 256;

    static void search(String pat, String txt) {
    	int p = 101;
        int m = pat.length();
        int n = txt.length();
        int i, j;
        int pnum = 0;
        int tnum = 0;
        int h = 1;

        for (i = 0; i < m; i++) {
            pnum = (d * pnum + pat.charAt(i)) % p;
            tnum = (d * tnum + txt.charAt(i)) % p;
            if(i < m-1) {
            	h = (h * d) % p;
            }
        }

        for (i = 0; i <= n - m; i++) {

            if (pnum == tnum) {
                for (j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }

                if (j == m)
                    System.out.println("Pattern found at index " + i);
            }

            if (i < n - m) {
                tnum = (d * (tnum - txt.charAt(i) * h) + txt.charAt(i + m)) % p;

                if (tnum < 0)
                    tnum = (tnum + p);
            }
        }
    }

    public static void main(String[] args) {
        String txt = "abcaabc";
        String pat = "abc";
        
        search(pat, txt);
    }
}
