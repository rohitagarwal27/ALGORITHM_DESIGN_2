import java.util.*;
// KRUSKAL ALGORITHM
import java.util.Arrays;
import java.util.LinkedList;

public class MST_Kruskal {
	int count;
	private LinkedList<LinkedList<Edge>> Adj;

	private static class Edge implements Comparable<Edge> {
		private int src;
		private int dest;
		private int cost;

		public Edge(int s, int dst, int cost) {
			dest = dst;
			src = s;
			this.cost = cost;
		}

		public int compareTo(Edge compareEdge) {
			return this.cost - compareEdge.cost;
		}
	}

	public MST_Kruskal(int cnt) {
		count = cnt;
		Adj = new LinkedList<LinkedList<Edge>>();
		for (int i = 0; i < cnt; i++) {
			Adj.add(new LinkedList<Edge>());
		}

	}

	public void addDirectedEdge(int source, int dest, int cost) {
		Edge edge = new Edge(source, dest, cost);
		Adj.get(source).add(edge);
	}

	public void addDirectedEdge(int source, int dest) {
		addDirectedEdge(source, dest, 1);
	}

	public void addUndirectedEdge(int source, int dest, int cost) {
		addDirectedEdge(source, dest, cost);
		addDirectedEdge(dest, source, cost);
	}

	public void addUndirectedEdge(int source, int dest) {
		addUndirectedEdge(source, dest, 1);
	}

	public void print() {
		for (int i = 0; i < count; i++) {
			LinkedList<Edge> ad = Adj.get(i);
			System.out.println("\n Vertex " + i + " is connected to: ");
			for (Edge adn : ad) {
				System.out.println("(" + adn.dest + "," + adn.cost + ")");
			}
		}
	}

	public static class Sets {
		int parent;
		int rank;

		Sets(int p, int r) {
			parent = p;
			rank = r;
		}
	}

	public int find(Sets[] sets, int index) {
		int p = sets[index].parent;
		while (p != index) {
			index = p;
			p = sets[index].parent;
		}
		return p;
	}

	public void union(Sets[] sets, int x, int y) {
		if (sets[x].rank < sets[y].rank)
			sets[x].parent = y;
		else if (sets[y].rank < sets[x].rank)
			sets[y].parent = x;
		else {
			sets[x].parent = y;
			sets[y].rank++;
		}
	}

	public void Kruskal_MST() {
		Sets[] sets = new Sets[count];
		for (int i = 0; i < count; i++)
			sets[i] = new Sets(i, 0);
		int E = 0;
		Edge edge[] = new Edge[100];
		for (int i = 0; i < count; i++) {
			LinkedList<Edge> ad = Adj.get(i);
			for (Edge adn : ad) {
				edge[E++] = adn;
			}
		}

		Arrays.sort(edge, 0, E - 1);
		int sum = 0;
		String output = "Edges are: ";
		for (int i = 0; i < E; i++) {
			int x = find(sets, edge[i].src);
			int y = find(sets, edge[i].dest);
			if (x != y) {
				output += ("(" + edge[i].src + "->" + edge[i].dest + " @" + edge[i].cost + ")");
				sum += edge[i].cost;
				union(sets, x, y);
			}

		}
		System.out.println(output);
		System.out.println("Total MST cost: " + sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MST_Kruskal gph = new MST_Kruskal(9);
		gph.addUndirectedEdge(0, 1, 4);
		gph.addUndirectedEdge(1, 2, 8);
		gph.addUndirectedEdge(2, 3, 7);
		gph.addUndirectedEdge(3, 4, 9);
		gph.addUndirectedEdge(4, 5, 10);
		gph.addUndirectedEdge(5, 6, 2);
		gph.addUndirectedEdge(6, 7, 1);
		gph.addUndirectedEdge(0, 7, 8);
		gph.addUndirectedEdge(1, 7, 11);
		gph.addUndirectedEdge(2, 8, 2);
		gph.addUndirectedEdge(2, 5, 4);
		gph.addUndirectedEdge(3, 5, 14);
		gph.addUndirectedEdge(8, 6, 6);
		gph.addUndirectedEdge(8, 7, 7);
		gph.Kruskal_MST();

	}

}
// Output
// Edges are: (6->7 @1)(2->8 @2)(5->6 @2)(0->1 @4)(2->5 @4)(2->3 @7)(0->7
// @8)(3->4 @9)
// Total MST cost: 37