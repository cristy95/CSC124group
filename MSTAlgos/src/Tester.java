import java.util.Scanner;


public class Tester
{

   public static void main(String[] args)
   {
	   int MAX_VALUE = 999;
	   int adj_mat[][];
       int number_of_vertices;

       Scanner scan = new Scanner(System.in);
       System.out.println("Enter the number of vertices");
       number_of_vertices = scan.nextInt();
       adj_mat = new int[number_of_vertices+1][number_of_vertices+1];

       System.out.println("Enter the Weighted Matrix for the graph");
       for (int i = 1; i <= number_of_vertices; i++)
       {
           for (int j = 1; j <= number_of_vertices; j++)
           {
        	   int x = scan.nextInt();
               if (x == 0)
               {
                   adj_mat[i][j] = MAX_VALUE;
               }else{
            	   adj_mat[i][j] = x;
               }
           }
       }
       for (int i = 1; i <= number_of_vertices; i++)
       {
           for (int j = 1; j <= number_of_vertices; j++)
           {
               System.out.print(adj_mat[i][j] + " ");
           }
       }
      Prim P = new Prim();
      
      P.Prim(adj_mat);
   }
}
