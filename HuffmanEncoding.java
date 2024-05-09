package LAB6;

import java.util.PriorityQueue;

public class HuffmanEncoding {

    class HuffmanNode implements Comparable<HuffmanNode> {
        int data;
        char c;
        HuffmanNode left;
        HuffmanNode right;

        @Override
        public int compareTo(HuffmanNode o) {
            return this.data - o.data;
        }
    }

    public void printTree(HuffmanNode root, String s) {
        if (root.left == null && root.right == null) {
            System.out.println(root.c + ":" + s);
            return;
        }
        printTree(root.left, s + "0");
        printTree(root.right, s + "1");
    }

    public HuffmanNode HuffmanTree(char[] sym, int[] freq) {
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>();
        for (int i = 0; i < sym.length; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = sym[i];
            hn.data = freq[i];
            hn.left = null;
            hn.right = null;
            q.add(hn);
        }
        HuffmanNode root = null;
        while (q.size() > 1) {
            HuffmanNode x = q.peek();
            q.poll();
            HuffmanNode y = q.peek();
            q.poll();
            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;
            q.add(f);
        }
        return root;
    }

    public static void main(String[] args) {
        char[] sym = {'C', 'A', 'K', 'T', 'R'};
        int freq[] = {75, 30, 105, 280, 110};

        HuffmanEncoding obj = new HuffmanEncoding();
        obj.printTree(obj.HuffmanTree(sym, freq), "");
    }
}
