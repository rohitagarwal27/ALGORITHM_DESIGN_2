

public class GraphAM {
    int count;
    int [][]adj;
    public GraphAM(int count) {
    	this.count=count;
    	adj=new int[4][4];
    }
    public void addDirectededge(int src,int dst,int cost) {
    	adj[src][dst]=cost;
    }
    public void addUndirectededge(int src,int dst,int cost) {
    	addDirectededge(src,dst,cost);
    	addDirectededge(dst,src,cost);
    }
    public void print() {
    	for (int i=0;i<count;i++) {
    		System.out.print("Node index "+i+" is connected with: ");
    		for (int j=0;j<count;j++) {
    			if(adj[i][j]!=0) {
    				System.out.print(j+" ");
    			}
    		}
    		System.out.println();
    	}
    }
    public static void main(String[] args) {
    	GraphAM graph=new GraphAM(4);
    	graph.addUndirectededge(0, 1, 1);
    	graph.addUndirectededge(0, 2, 1);
    	graph.addUndirectededge(1, 2, 1);
    	graph.addUndirectededge(2, 3, 1);
    	graph.print();
    	
    }
    
}
// Output
// Node index 0 is connected with: 1 2 
// Node index 1 is connected with: 0 2
// Node index 2 is connected with: 0 1 3
// Node index 3 is connected with: 2
