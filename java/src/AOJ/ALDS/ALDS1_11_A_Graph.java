package AOJ.ALDS;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/03.
 */
public class ALDS1_11_A_Graph
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int node_num = Integer.parseInt(scan.next());

        int[][] adj = new int[node_num + 1][node_num + 1];
        for (int i = 0; i < node_num + 1; i++)
            Arrays.fill(adj[i], 0);


        for (int i = 0; i < node_num; i++)
        {
            int u = Integer.parseInt(scan.next());
            int degree = Integer.parseInt(scan.next());
            for (int j = 0; j < degree; j++)
            {
                int v = Integer.parseInt(scan.next());
                adj[u][v] = 1;
            }
        }

        for (int i = 1; i < node_num + 1; i++)
        {
            System.out.print(adj[i][1]);
            for (int j = 2; j < node_num + 1; j++)
                System.out.print(" " + adj[i][j]);
            System.out.print("\n");
        }
    }
}
