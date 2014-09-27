
public class Prims_algo {
	
	public int[] prims(int[][] adjmatrix, int[] vertices){
		int size = vertices.length-1;
		int[] visited = new int[size];
		int[] unvisited = vertices;
		int[] spantree = new int[size];
		boolean[] isvisited =new boolean[size];
		int[] predvert = new int[size];
		
		isvisited[0] = true;
		
		for(int i=1; i<size;  i++)
		{
			isvisited[i] = false;
		}
		
		predvert[0] = 0;
		
		for(int k = 1; k < size; k++)
		{
			int x = 0;
			int y = 0;
			
			for(int i = 0; i < size; i++)
				for(int j=0; j < size; j++)
				{
					if(isvisited[i] && !isvisited[j] && 
							adjmatrix[i][j] < adjmatrix[x][y])
					{
						x = i;
						y = j;
					}
				}
				predvert[y] = x;	
				isvisited[y] = true;
		}
		return visited;
	}
	
	
	/*void Graph(int[][] matrix){
		int size = matrix.length;
	}*/
	
	void printVisited(int[] visited )
	   {
	      System.out.print("Visited = ");
	      for (int i = 0; i < visited.length; i++ )
	         if ( visited[i]  != 0)
	           System.out.print( i + " ");
	      System.out.println();
	   }
}
