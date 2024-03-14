package lab2;
import java.util.*;


public class KruskalMST {
    public static void main(String[] args) {
    	int V = 5;
    	int E = 4;
    	Graph G = new Graph(V,E);
    	G.addEdge(0, 1, 10);
    	G.addEdge(0, 2, 20);
    	G.addEdge(0, 3, 30);
    	G.addEdge(0, 4, 40);
    	G.addEdge(3, 4, 70);
    	G.addEdge(2, 1, 80);
    	
    	G.krushkalMst();
    	
    	G.showMst();
    	
    	   
    }
}

class Edge implements Comparable<Edge> {
    int u, v, w;
    Edge(int a, int b, int c){
    	u = a; v = b; w = c;
    }
    public int compareTo(Edge compareEdge) {
        return this.w - compareEdge.w;
    }
}


class Graph {
    int V, E;
    ArrayList<Edge> adjacencylist[];
    ArrayList<Edge> allEdge;
    ArrayList<Edge> mstEdge;

    Graph(int v, int e) {
        V = v;
        E = e;
        adjacencylist = new ArrayList[V];
        for(int i =0; i < v; i++) {
        	adjacencylist[i] = new ArrayList<Edge>();
        }
        allEdge = new ArrayList<Edge>();
        mstEdge = new ArrayList<Edge>();
    }
    
    void addEdge(int a, int b, int c) {
    	Edge e = new Edge(a,b,c);
    	allEdge.add(e);
    }
    
    void krushkalMst() {
    	Collections.sort(allEdge);
    	
    	Set<Integer> set[] = new HashSet[V];
    	for(int i =0; i<V; i++) {
    		set[i] = new HashSet<Integer>();
    		set[i].add(i);
    	}
    	
    	for(int i=0; i<E; i++) {
    		int k, l;
    		Edge e = allEdge.get(i);
    		for(k = 0; k < V; k++) {
    			if(set[k].contains(e.u)) {
    				break;
    			}
    		}
    		for(l = 0; l < V; l++) {
    			if(set[l].contains(e.v)) {
    				break;
    			}
    		}
    		
    		if(k!=l) {
    			set[k].addAll(set[l]);
    			set[l].clear();
    			mstEdge.add(e);
    		}
    		
    	}
    	  	    	
    }
    
    void showMst() {
    	int wt = 0;
    	for(Edge e: mstEdge) {
    		wt = wt+e.w;
    		System.out.println(e.u+"->"+e.v);
    	}
    	System.out.println(wt);
    }
   
}
