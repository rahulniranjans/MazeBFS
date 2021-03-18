// A Java program for BFS
// single source shortest path 
// algorithm. The program is for 
// adjacency matrix representation 
// of the graph. 
import java.util.*; 
import java.io.*; 
class BreadthFirstSearch { 

	private static final int NO_PARENT = -1; 

	// Function that implements BFS 
	// single source shortest path 
	// algorithm for a graph represented 
	// using adjacency matrix 
	// representation 
	private static void BFS(int[][] adjacencyMatrix, 
										int startVertex) 
	{ 
		int nVertices = 71;

		// shortestDistances[i] will hold the 
		// shortest distance from src to i 
		int[] shortestDistances = new int[nVertices]; 

		// added[i] will true if vertex i is 
		// included / in shortest path tree 
		// or shortest distance from src to 
		// i is finalized 
		boolean[] added = new boolean[nVertices]; 

		// Initialize all distances as 
		// INFINITE and added[] as false 
		for (int vertexIndex = 0; vertexIndex < nVertices; 
											vertexIndex++) 
		{ 
			shortestDistances[vertexIndex] = Integer.MAX_VALUE; 
			added[vertexIndex] = false; 
		} 
		
		// Distance of source vertex from 
		// itself is always 0 
		shortestDistances[startVertex] = 0; 

		// Parent array to store shortest 
		// path tree 
		int[] parents = new int[nVertices]; 

		// The starting vertex does not 
		// have a parent 
		parents[startVertex] = NO_PARENT; 

		// Find shortest path for all 
		// vertices 
		for (int i = 1; i < nVertices; i++) 
		{ 

			// Pick the minimum distance vertex 
			// from the set of vertices not yet 
			// processed. nearestVertex is 
			// always equal to startNode in 
			// first iteration. 
			int nearestVertex = -1; 
			int shortestDistance = Integer.MAX_VALUE; 
			for (int vertexIndex = 1; 
					vertexIndex < nVertices; 
					vertexIndex++) 
			{ 
				if (!added[vertexIndex] && 
					shortestDistances[vertexIndex] < 
					shortestDistance) 
				{ 
					nearestVertex = vertexIndex; 
					shortestDistance = shortestDistances[vertexIndex]; 
				} 
			} 

			// Mark the picked vertex as 
			// processed 
			added[nearestVertex] = true; 

			// Update dist value of the 
			// adjacent vertices of the 
			// picked vertex. 
			for (int vertexIndex = 1; 
					vertexIndex < nVertices; 
					vertexIndex++) 
			{ 
				int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex]; 
				
				if (edgeDistance > 0
					&& ((shortestDistance + edgeDistance) < 
						shortestDistances[vertexIndex])) 
				{ 
					parents[vertexIndex] = nearestVertex; 
					shortestDistances[vertexIndex] = shortestDistance + 
													edgeDistance; 
				} 
			} 
		} 

		printSolution(startVertex, shortestDistances, parents); 
	} 

	// A utility function to print 
	// the constructed distances 
	// array and shortest paths 
	private static void printSolution(int startVertex, 
									int[] distances, 
									int[] parents) 
	{ 
		int nVertices = distances.length;  
		
		for (int vertexIndex = 1; 
				vertexIndex < nVertices; 
				vertexIndex++) 
		{ 
			if (vertexIndex != startVertex && vertexIndex==1 || vertexIndex==70) 
			{ 
				System.out.print("Vertices:\t"+(startVertex-1) + " -> "+(vertexIndex-1) + "\n"+"Distance:\t"+distances[vertexIndex] + "\n" +"Path Taken:\t");
				printPath(vertexIndex, parents);
                System.out.println("\n");
			} 
		} 
	} 

	// Function to print shortest path 
	// from source to currentVertex 
	// using parents array 
	private static void printPath(int currentVertex, 
								int[] parents) 
	{ 
		
		// Base case : Source node has 
		// been processed 
		if (currentVertex == NO_PARENT) 
		{ 
			return; 
		} 
		printPath(parents[currentVertex], parents); 
		System.out.print(" -> "+(currentVertex-1)); 
	} 

		// Driver Code 
	public static void main(String[] args) throws IOException
	{ 
		int adjacency_matrix[][];
            int number_of_vertices;
            
                number_of_vertices = 70;
                Scanner myReader = new Scanner(new File("out.txt"));
                adjacency_matrix = new int[number_of_vertices + 1][number_of_vertices + 1];
                while(myReader.hasNextLine()){
                    for (int i = 1; i <= number_of_vertices; i++)
                    {   
                        for (int j = 1; j <= number_of_vertices; j++)
                        {
                            adjacency_matrix[i][j] = myReader.nextInt();
                            if (i == j)
                            {
                                adjacency_matrix[i][j] = 0;
                                continue;
                            }
                            if (adjacency_matrix[i][j] == 0)
                            {
                                adjacency_matrix[i][j] = 999;
                            }
                        }
                    }
                }
                myReader.close();
		BFS(adjacency_matrix, 46); 
	} 
} 
