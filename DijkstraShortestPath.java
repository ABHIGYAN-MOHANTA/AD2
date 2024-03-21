package lab2;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class DijkstraShortestPath {

	public static void main(String[] args) {
		int V = 5;
    	int E = 4;
    	Graph G = new Graph(V,E);
    	Vertex s = new Vertex(0,0, null);
    	ArrayList<Vertex> VL = new ArrayList<Vertex>();
    	VL.add(s);
    	for(int i = 1; i < V; i++) {
    		Vertex v = new Vertex(i, (Integer.MAX_VALUE), null);
    		VL.add(v);
    	}
    	
    	G.addEdge(VL.get(0), VL.get(1), 10);
    	G.addEdge(VL.get(1), VL.get(2), 20);
    	G.addEdge(VL.get(2), VL.get(3), 30);
    	G.addEdge(VL.get(0), VL.get(3), 5);
    	G.dijkstra(s);

        for (Vertex v : VL) {
            System.out.println("Vertex: " + v.getId() + " Distance: " + v.getD());
        }
    	
    	

	}

}


class Edge implements Comparable<Edge> {
	Vertex u, v;
    int w;
    Edge(Vertex a, Vertex b, int c){
    	u = a; v = b; w = c;
    }
    public int compareTo(Edge compareEdge) {
        return this.w - compareEdge.w;
    }
}

class Vertex{
	int id;
	int d;
	Vertex p;
	
	public Vertex(int id, int d, Vertex p) {
		this.id = id;
		this.d = d;
		this.p = p;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	public Vertex getP() {
		return p;
	}
	public void setP(Vertex p) {
		this.p = p;
	}
	
}

class Graph {
    int V, E;
    ArrayList<Edge> adjacencylist[];
    ArrayList<Edge> allEdge;

    Graph(int v, int e) {
        V = v;
        E = e;
        adjacencylist = new ArrayList[V];
        for(int i =0; i < v; i++) {
        	adjacencylist[i] = new ArrayList<Edge>();
        }     
    
    }
    
    void addEdge(Vertex a, Vertex b, int c) {
    	Edge e = new Edge(a,b,c);
    	adjacencylist[a.getId()].add(e);
    }
    
    void relaxEdge(Vertex u, Vertex v, int w) {
    	if(u.getD() + w < v.getD()) {
    		v.setD(u.getD()+w);
    		v.setP(u);
    	}
    }
    
    public void dijkstra(Vertex source) {
        source.setD(0);
        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>((va, vb) -> (va.getD() - vb.getD()));
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex u = pq.poll();

            for (Edge e : adjacencylist[u.getId()]) {
                Vertex v = e.v;
                int weight = e.w;
                if (u.getD() + weight < v.getD()) {
                    v.setD(u.getD() + weight);
                    v.setP(u);
                    pq.offer(v);
                    
                }
            }
        }
    }
}

