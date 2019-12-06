import java.util.*;
import java.io.*;

public class CS60811Bashikari {

	//method to parse string to linked list
	
	private int V;   // No. of vertices 
	  
    // Array  of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 
  
    // Constructor 
    CS60811Bashikari(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    //Function to add an edge into the graph 
    void addEdge(int v, int w) 
    { 
        adj[v].add(w);  // Add w to v's list. 
    } 
	
	// A function used by DFS 
    void DFSUtil(int v,boolean visited[]) 
    { 
    	
    	//convert from number to corresponding character
    	char output = 'x';
    	output = charConv(v);
    	
        // Mark the current node as visited and print it 
        visited[v] = true; 
        System.out.print(output+" "); 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
    } 
  
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    void DFS(int v) 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[V]; 
  
        // Call the recursive helper function to print DFS traversal 
        DFSUtil(v, visited); 
    }
    
 // prints BFS traversal from a given source s 
    void BFS(int s) 
    { 
    	
    	//convert from number to corresponding character
    	//char output = 'x';
    	//output = charConv(s);
    	
        // Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[V]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            
            char output = 'x';
        	output = charConv(s);
            
            System.out.print(output+" "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
    } 
	
    int minDistance(int dist[], Boolean sptSet[]) 
    { 
        // Initialize min value 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) 
            { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
    // A utility function to print the constructed distance array 
    void printSolution(int dist[], int n) 
    { 
    	char output = 'x';
    	char outputI = 'x';
    	char shortest = 'x';
    	char shortestNum = 0;
        System.out.println("Distance from A: "); 
        for (int i = 0; i < V; i++) {
        	output = charConv(dist[i]);
        	outputI = charConv(i);
            System.out.println(outputI+" -- "+ dist[i]); 
            
            
            //if () {
            	
            //}
            
        }
    } 
    
 // Funtion that implements Dijkstra's single source shortest path 
    // algorithm for a graph represented using adjacency matrix 
    // representation 
    void dijkstra(int graph[][], int src) 
    { 
        int dist[] = new int[V]; // The output array. dist[i] will hold 
                                 // the shortest distance from src to i 
  
        // sptSet[i] will true if vertex i is included in shortest 
        // path tree or shortest distance from src to i is finalized 
        Boolean sptSet[] = new Boolean[V]; 
  
        // Initialize all distances as INFINITE and stpSet[] as false 
        for (int i = 0; i < V; i++) 
        { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
  
        // Distance of source vertex from itself is always 0 
        dist[src] = 0; 
  
        // Find shortest path for all vertices 
        for (int count = 0; count < V-1; count++) 
        { 
            // Pick the minimum distance vertex from the set of vertices 
            // not yet processed. u is always equal to src in first 
            // iteration. 
            int u = minDistance(dist, sptSet); 
  
            // Mark the picked vertex as processed 
            sptSet[u] = true; 
  
            // Update dist value of the adjacent vertices of the 
            // picked vertex. 
            for (int v = 0; v < V; v++) 
  
                // Update dist[v] only if is not in sptSet, there is an 
                // edge from u to v, and total weight of path from src to 
                // v through u is smaller than current value of dist[v] 
                if (!sptSet[v] && graph[u][v]!=0 && 
                        dist[u] != Integer.MAX_VALUE && 
                        dist[u]+graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
        } 
  
        // print the constructed distance array 
        printSolution(dist, V); 
    } 
    
    char charConv(int v) {
    	
    	//convert from number to corresponding character
    	char output = 'x';
    	
    	if (v == 0) {
    		output = 'A';
    	} else if (v == 1){
    		output = 'B';
    	} else if (v == 2){
    		output = 'C';
    	} else if (v == 3){
    		output = 'D';
    	} else if (v == 4){
    		output = 'E';
    	} else if (v == 5){
    		output = 'F';
    	} else if (v == 6){
    		output = 'G';
    	} else if (v == 7){
    		output = 'H';
    	} else if (v == 8){
    		output = 'I';
    	} else if (v == 9){
    		output = 'J';
    	} else if (v == 10){
    		output = 'K';
    	} else if (v == 11){
    		output = 'L';
    	} else if (v == 12){
    		output = 'M';
    	} else if (v == 13){
    		output = 'N';
    	} else {
    		output = 'O';
    	}
    	
    	return output;
    }
    
	public static void main(String[] args) throws Exception {
		
		//linked list should be 16 nodes long (A-O plus another A).

		Scanner in = new Scanner(new File("inputData11B.txt"));
		int[][] input = new int[15][15];
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				input[i][j] = in.nextInt();
				//System.out.print(input[i][j] + " ");
			}
			//System.out.println("");
	    }
		
		CS60811Bashikari g = new CS60811Bashikari(15); 
		
	       
	    for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (input[i][j] != 0) {
					g.addEdge(i, j);
	    			//System.out.print(input[i][j] + " ");
				}
			}
			//System.out.println("");
	    }
			
	    System.out.println("Result of Depth First Search starting at node A: ");
	    g.DFS(0);
	    System.out.println("");
	    
	    System.out.println("Result of Breadth First Search starting at node A: ");
	    g.BFS(0);
	    System.out.println(""); 
	    
	    g.dijkstra(input, 0);
	    
		//read each line from file to separate string, then parse to linked list
		
		//is a linked list even necessary?
		
	    in.close();
	}
}
