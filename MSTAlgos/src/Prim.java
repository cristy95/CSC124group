import java.util.*;

public class Prim
{
   static int size;
   static int infinite = 99999;
   int cost;
   
   public void Prim(final int[][] matrix)
   {
      int i, j, k, x, y;
      size = matrix.length;
      boolean[] Reached = new boolean[size];	
      int[] predNode = new int[size];		

      Reached[0] = true;
      Reached[1] = true;
      for ( i=0; i < size; i++)
      {
         for ( j=0; j < size; j++)
         {
            matrix[i][j] = matrix[i][j];

            if ( matrix[i][j] == 0 )
               matrix[i][j] = infinite;
         }
      }
      
      for ( k = 2; k < size; k++ )
      {
         Reached[k] = false;
      }

      predNode[0] = 0;      
      predNode[1] = 0;
      printReachSet( Reached );

 	 
      for ( i = 1; i < size; i++ )
         {
    	  x = y = 1;
        	 for ( j = 2; j < size; j++ )
             {
                 if ( matrix[i][j] < matrix[x][y] && !Reached[j] && Reached[i] && x != y)
                      {
                 		x = i;
                 		y = j;
                 		System.out.print(matrix[x][y] + " ");
                 }
             }

          System.out.println("Min cost edge: (" + 
 				+ x + "," + 
 				+ y + ")" +
 				"cost = " + matrix[x][y]);
          cost += matrix[x][y];
          predNode[y] = x;        
          Reached[y] = true;

          printReachSet( Reached );     // Print state....
         
          System.out.println();
         }
            
	  System.out.println("This is the adjacency matrix");
      for (int m = 1; m < size; m++)
      {
          for (int l = 1; l < size; l++)
          {
              System.out.print(matrix[m][l] + "\t");
          }
          System.out.println();
      }
      printMinCostEdges( predNode );
      System.out.println("Total Cost: " + cost);
   }

   void printMinCostEdges( int[] a )
   {
      for ( int i = 1; i < size; i++ )
          System.out.println( a[i] + " --> " + i );
   }

   void printReachSet(boolean[] Reached )
   {
      System.out.print("ReachSet = ");
      for (int i =1; i < Reached.length; i++ )
         if ( Reached[i] )
           System.out.print( i + " ");
      System.out.println();
   }

}


