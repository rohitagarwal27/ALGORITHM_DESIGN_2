
import java.util.*;
public class GraphAL {
    int count;
    private LinkedList <LinkedList<Edge>>Adj;
    private static class Edge{
    	private int dest;
    	private int cost;    	
    
        public Edge(int dst,int cost) {
    	    dest=dst;
    	    this.cost=cost;
        }
    }
    public GraphAL(int cnt) {
    	count=cnt;
    	Adj=new LinkedList<LinkedList<Edge>>();
    	for (int j=0;j<cnt;j++) {
    		Adj.add(new LinkedList<Edge>());
    		
    	}
    	
    }
    public void addDirectedEdge(int source,int dest,int cost) {
        Edge edge=new Edge(dest,cost);
        Adj.get(source).add(edge);
    }
    public void addDirectedEdge(int source,int dest) {
    	addDirectedEdge(source,dest,1);
    }
    public void addUndirectedEdge(int source,int dest,int cost) {
    	addDirectedEdge(source,dest,cost);
    	addDirectedEdge(dest,source,cost);
    }
    public void addUndirectedEdge(int source,int dest) {
    	addUndirectedEdge(source,dest,1);
    }
    public void print() {
    	for(int i=0;i<count;i++) {
    		LinkedList<Edge>ad=Adj.get(i);
    		System.out.print("\n Vertex "+i+" is connected to: ");
    		for(Edge adn:ad) {
    			System.out.print("("+adn.dest+","+adn.cost+")");
    		}
    	}
		System.out.println();
    }
	public static void main(String[] args) {
		 
		GraphAL gph=new GraphAL(5);
		for(int i=0;i<5;i++) {
			for(int j=i+1;j<5;j++) {
				
				    gph.addUndirectedEdge(i,j,1);
			}
		}
		gph.print();

	}

}
// Output
// Vertex 0 is connected to: (1,1)(2,1)(3,1)(4,1)
//  Vertex 1 is connected to: (0,1)(2,1)(3,1)(4,1)
//  Vertex 2 is connected to: (0,1)(1,1)(3,1)(4,1)
//  Vertex 3 is connected to: (0,1)(1,1)(2,1)(4,1)
//  Vertex 4 is connected to: (0,1)(1,1)(2,1)(3,1)