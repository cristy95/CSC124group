
public class Prim {
	
	private static int infinite = 99999;
	int size;
	int[][] matrix;
	void makeGraph(int[][] input){
		
		size = input.length;
		matrix = new int[size][size];
		int i,j;
		for(i=0; i < size; i++)
			for(j=0; j<size; j++){
				matrix[i][j] = input[i][j];
				if(input[i][j] == 0)
					input[i][j] = infinite;
			}
	}
	
	public void Prim()
	   {
	      int i, j, k, x, y;

	      boolean[] Reached = new boolean[size];	// Reach/unreach nodes
	      int[] predNode = new int[size];		// Remember min cost edge

	      // Start at a vertex, I picked the start node = 0

	      Reached[0] = true;

	      // Other vertices are not reached 

	      for ( k = 1; k < size; k++ )
	      {
	         Reached[k] = false;
	      }

	      predNode[0] = 0;      // No edge for node 0

	      printReachSet( Reached );

	      /* =====================================================
	         UnReachSet will decreas by 1 node in each iteration
		 There are NNodes-1 unreached nodes; so we can loop
		 NNodes-1 times and UnReachSet will become empty !
		 =====================================================  */
	      for (k = 1; k <size; k++)
	      {
	         /* ================================================================
		    Find min. cost link between: reached node ---> unreached node
	            ================================================================ */
	         x = y = 0;

	         for ( i = 0; i < size; i++ )
	            for ( j = 0; j < size; j++ )
	            {
	                if ( Reached[i] && !Reached[j] &&
	                     matrix[i][j] < matrix[x][y] )
	                {
			   x = i;
			   y = j;
	                }
	            }

	         System.out.println("Min cost edge: (" + 
					+ x + "," + 
					+ y + ")" +
					"cost = " + matrix[x][y]);

	         /* =================================
		    Add e (x,y) to Spanning tree
	            ================================= */
	         predNode[y] = x;          // Record the min cost link

		 /* ==========================================
		    ReachSet = ReachSet union {y}
		    UnReachSet = UnReachSet - {y}
		    ========================================== */
	         Reached[y] = true;

	         printReachSet( Reached );     // Print state....
	         System.out.println();
	      }

	      printMinCostEdges( predNode );
	   }

	   void printMinCostEdges( int[] a )
	   {
	      for ( int i = 0; i < size; i++ )
	          System.out.println( a[i] + " --> " + i );
	   }

	   void printReachSet(boolean[] Reached )
	   {
	      System.out.print("ReachSet = ");
	      for (int i = 0; i < Reached.length; i++ )
	         if ( Reached[i] )
	           System.out.print( i + " ");
	      System.out.println();
	   }
}
