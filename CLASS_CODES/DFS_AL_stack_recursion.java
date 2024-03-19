
// import java.util.*;

// class Edge{
// 	public int dest;
// 	public int cost;    	

//     public Edge(int dst,int cost) {
// 	    dest=dst;
// 	    this.cost=cost;
//     }
// }
// public class DFS_AL_stack_recursion {
//     int count;
//     public LinkedList <LinkedList<Edge>>Adj;
    
//     public GraphAL(int cnt) {
//     	count=cnt;
//     	Adj=new LinkedList<LinkedList<Edge>>();
//     	for (int j=0;j<cnt;j++) {
//     		Adj.add(new LinkedList<Edge>());
    		
//     	}
    	
//     }
//     public void addDirectedEdge(int source,int dest,int cost) {
//         Edge edge=new Edge(dest,cost);
//         Adj.get(source).add(edge);
//     }
//     public void addDirectedEdge(int source,int dest) {
//     	addDirectedEdge(source,dest,1);
//     }
//     public void addUndirectedEdge(int source,int dest,int cost) {
//     	addDirectedEdge(source,dest,cost);
//     	addDirectedEdge(dest,source,cost);
//     }
//     public void addUndirectedEdge(int source,int dest) {
//     	addUndirectedEdge(source,dest,1);
//     }
//     public void print() {
//     	for(int i=0;i<count;i++) {
//     		LinkedList<Edge>ad=Adj.get(i);
//     		System.out.println("\n Vertex "+i+" is connected to: ");
//     		for(Edge adn:ad) {
//     			System.out.println("("+adn.dest+","+adn.cost+")");
//     		}
//     	}
//     }
//     public static boolean dfsStack(GraphAL gph,int source,int target) {
// 		int count=gph.count;
// 		boolean visited[]=new boolean[count];
// 		Stack<Integer> stk=new Stack<Integer>();
// 		stk.push(source);
// 		visited[source]=true;
// 		while(stk.isEmpty()==false) {
// 			int curr=stk.pop();
// 			LinkedList<Edge>ad1=gph.Adj.get(curr);
// 			for(Edge adn:ad1) {
// 				if(visited[adn.dest]==false) {
// 					visited[adn.dest]=true;
// 					stk.push(adn.dest);
// 				}
// 			}
// 		}
// 		return visited[target];
		
// 	}
//     public static boolean rtraversal(GraphAL gph,int source,int target) {
//     	int count=gph.count;
//     	boolean visited[]=new boolean[count];
//     	dfsVisit(gph,source,visited);
//     	return(visited[target]);
    	
//     }
//     public static void dfsVisit(GraphAL gph,int index,boolean visited[]) {
//     	visited[index]=true;
//     	LinkedList<Edge> ad1=gph.Adj.get(index);
//     	for(Edge adn:ad1) {
//     		if(visited[adn.dest]==false) {
//     			System.out.println("("+adn.dest+")");
//     			dfsVisit(gph,adn.dest,visited);
//     		}
//     	}
//     }
// 	public static void main(String[] args) {
// 		// TODO Auto-generated method stub
// 		GraphAL gph=new GraphAL(7);
// 		/*gph.addUndirectedEdge(0, 1);
// 		gph.addUndirectedEdge(0, 2);
// 		gph.addUndirectedEdge(0, 3);
// 		gph.addUndirectedEdge(1, 4);
// 		gph.addUndirectedEdge(4, 7);
// 		gph.addUndirectedEdge(7, 8);
// 	//	gph.addUndirectedEdge(8, 9);
// 		//gph.addUndirectedEdge(9, 6);
// 		gph.addUndirectedEdge(6, 3);
// 		gph.addUndirectedEdge(2, 5);
// 		System.out.println(dfsStack(gph,0,9));	
// 		boolean v[]=new boolean[10];
// 		dfsutil(gph,0,v);*/
// 		gph.addDirectedEdge(1, 2);
// 		gph.addDirectedEdge(1, 4);
// 		gph.addDirectedEdge(4, 2);
// 		gph.addDirectedEdge(5, 4);
// 		gph.addDirectedEdge(2, 5);
// 		gph.addDirectedEdge(3, 5);
// 		gph.addDirectedEdge(3, 6);
// 		gph.addDirectedEdge(6, 6);
// 		System.out.println(rtraversal(gph,1,3));
		
		
		

// 	}

// }	
