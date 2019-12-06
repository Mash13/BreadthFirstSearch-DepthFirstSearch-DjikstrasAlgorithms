import java.util.*;
import java.io.*;

public class CS60811Aashikari {

	//method to parse string to linked list
	
	private int V;   // No. of vertices 
	  
    // Array  of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 
  
    // Constructor 
    CS60811Aashikari(int v) 
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

		Scanner in = new Scanner(new File("inputData11A.txt"));
		int[][] input = new int[15][15];
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				input[i][j] = in.nextInt();
				//System.out.print(input[i][j] + " ");
			}
			//System.out.println("");
	    }
		
		CS60811Aashikari g = new CS60811Aashikari(15); 
		
	       
	    for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (input[i][j] != 0) {
					g.addEdge(i, j);
	    			//System.out.print(input[i][j] + " ");
				}
			}
			//System.out.println("");
	    }
	    
		
		/*
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,2);
		g.addEdge(2,0);
		g.addEdge(2,3);
		g.addEdge(3,3);
		g.addEdge(3,4);
		g.addEdge(4,5);
		g.addEdge(5,6);
		g.addEdge(6,7);
		g.addEdge(7,8);
		g.addEdge(8,9);
		*/	
			
	    System.out.println("Result of Depth First Search starting at node A: ");
	    g.DFS(0);
	    System.out.println("");    
	    
		//read each line from file to separate string, then parse to linked list
		
		//is a linked list even necessary?
		
	    in.close();
	}
}
