// Java implementation of the approach
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GFG{

static class Graph
{
	
	// Number of vertices
	int v;

	// Number of edges
	int e;

	// Adjacency matrix
	int[][] adj;

	// Function to fill the empty
	// adjacency matrix
	Graph(int v, int e)
	{
		this.v = v;
		this.e = e;
		
		adj = new int[v][v];
		for(int row = 0; row < v; row++)
			Arrays.fill(adj[row], 0);
	}
	
	// Function to add an edge to the graph
	void addEdge(int start, int e) 
	{
		
		// Considering a bidirectional edge
		adj[start][e] = 1;
		adj[e][start] = 1;
	}

	// Function to perform BFS on the graph
	void BFS(int start) 
	{
		
		// Visited vector to so that
		// a vertex is not visited more than once
		// Initializing the vector to false as no
		// vertex is visited at the beginning
		boolean[] visited = new boolean[v];
		Arrays.fill(visited, false);
		List<Integer> q = new ArrayList<>();
		q.add(start);

		// Set source as visited
		visited[start] = true;

		int vis;
		while (!q.isEmpty())
		{
			vis = q.get(0);

			// Print the current node
			System.out.print(" --> "+vis);

            // Exiting loop once goal condition has been reached
            if(vis==0 || vis==69)
                break; 

			q.remove(q.get(0));

			// For every adjacent vertex to
			// the current vertex
			for(int i = 0; i < v; i++)
			{
				if (adj[vis][i] == 1 && (!visited[i]))
				{
					// Push the adjacent node to
					// the queue
					q.add(i);
					// Set
					visited[i] = true;
				}
			}
		}
	}
}

// Driver code
public static void main(String[] args)
{
	
	int v = 70, e = 92;

	// Create the graph
	Graph G = new Graph(v, e);

	G.addEdge(45, 46);
	G.addEdge(45, 50);
	G.addEdge(46, 49);
    G.addEdge(47, 49);
    G.addEdge(47, 48);
    G.addEdge(47, 53);
    G.addEdge(48, 53);
    G.addEdge(48, 57);
    G.addEdge(49, 52);
    G.addEdge(50, 51);
    G.addEdge(50, 54);
    G.addEdge(51, 52);
    G.addEdge(51, 55);
    G.addEdge(52, 53);
    G.addEdge(52, 56);
    G.addEdge(54, 55);
    G.addEdge(55, 56);
    G.addEdge(55, 59);
    G.addEdge(55, 60);
    G.addEdge(56, 57);
    G.addEdge(56, 60);
    G.addEdge(57, 61);
    G.addEdge(58, 62);
    G.addEdge(58, 64);
    G.addEdge(58, 67);
    G.addEdge(59, 62);
    G.addEdge(60, 63);
    G.addEdge(60, 61);
    G.addEdge(61, 35);
    G.addEdge(62, 65);
    G.addEdge(62, 66);
    G.addEdge(64, 10);
    G.addEdge(64, 67);
    G.addEdge(65, 6);
    G.addEdge(65, 66);
    G.addEdge(66, 7);
    G.addEdge(67, 15);
    G.addEdge(68, 1);
    G.addEdge(1, 2);
    G.addEdge(2, 3);
    G.addEdge(2, 9);
    G.addEdge(3, 4);
    G.addEdge(4, 5);
    G.addEdge(5, 8);
    G.addEdge(6, 7);
    G.addEdge(7, 8);
    G.addEdge(7, 11);
    G.addEdge(9, 20);
    G.addEdge(9, 34);
    G.addEdge(10, 16);
    G.addEdge(10, 17);
    G.addEdge(11, 12);
    G.addEdge(11, 17);
    G.addEdge(12, 13);
    G.addEdge(12, 14);
    G.addEdge(13, 20);
    G.addEdge(14, 15);
    G.addEdge(15, 19);
    G.addEdge(16, 21);
    G.addEdge(18, 19);
    G.addEdge(19, 21);
    G.addEdge(20, 23);
    G.addEdge(21, 22);
    G.addEdge(21, 25);
    G.addEdge(22, 23);
    G.addEdge(22, 26);
    G.addEdge(23, 32);
    G.addEdge(24, 25);
    G.addEdge(25, 28);
    G.addEdge(26, 27);
    G.addEdge(26, 29);
    G.addEdge(27, 30);
    G.addEdge(28, 29);
    G.addEdge(29, 30);
    G.addEdge(31, 32);
    G.addEdge(32, 33);
    G.addEdge(33, 34);
    G.addEdge(33, 37);
    G.addEdge(35, 45);
    G.addEdge(35, 38);
    G.addEdge(36, 37);
    G.addEdge(37, 43);
    G.addEdge(37, 38);
    G.addEdge(38, 39);
    G.addEdge(39, 40);
    G.addEdge(39, 42);
    G.addEdge(40, 41);
    G.addEdge(41, 42);
    G.addEdge(42, 43);
    G.addEdge(43, 44);
    G.addEdge(36, 0);
    G.addEdge(28, 69);


	G.BFS(45); //Starting at node A
    System.out.println();
}
}

