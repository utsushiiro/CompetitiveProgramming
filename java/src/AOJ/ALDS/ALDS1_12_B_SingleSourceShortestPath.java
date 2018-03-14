package AOJ.ALDS;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/06.
 */
public class ALDS1_12_B_SingleSourceShortestPath
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int nodes_size = Integer.parseInt(scan.next());

        int[][] adj = new int[nodes_size][nodes_size];
        for (int i = 0; i < nodes_size; i++)
            Arrays.fill(adj[i], SSSPG.UNCONNECTED);

        for (int i = 0; i < nodes_size; i++)
        {
            int u = Integer.parseInt(scan.next());
            int out_degree = Integer.parseInt(scan.next());
            for (int j = 0; j < out_degree; j++)
            {
                int v = Integer.parseInt(scan.next());
                int cost = Integer.parseInt(scan.next());
                adj[i][v] = cost;
            }
        }

        SSSPG g = new SSSPG(0, nodes_size, adj);
        g.buildSSSP();

        for (int i = 0; i < nodes_size; i++)
            System.out.println(i + " " + g.getPathCost(i));
    }

    static class SSSPG
    {
        int start_node;
        int nodes_size;

        int[][] adjacent_table;
        static final int MAX_EDGE_COST = 100000;
        static final int MAX_NODES_SIZE = 100;
        static final int UNCONNECTED = MAX_EDGE_COST* MAX_NODES_SIZE + 1;

        Node[] nodes;
        static Node dummy = new Node(-1);
        static
        {
            dummy.distance = UNCONNECTED;
        }

        SSSPG(int start_node, int nodes_size, int[][] adjacent_table)
        {
            this.start_node = start_node;
            this.nodes_size = nodes_size;
            this.adjacent_table = adjacent_table;

            nodes = new Node[nodes_size];
            for (int i = 0; i < nodes_size; i++)
                nodes[i] = new Node(i);
        }

        void buildSSSP()
        {
            nodes[start_node].distance = 0;

            while (true)
            {
                Node min_node = dummy;
                for (Node node : nodes)
                    if (!node.isIncluded && node.distance < min_node.distance)
                        min_node = node;

                if (min_node == dummy)
                    break;

                min_node.isIncluded = true;

                for (Node node : nodes)
                    if (!node.isIncluded && isConnected(min_node, node))
                    {
                        int new_distance =
                                min_node.distance + getEdgeCost(min_node, node);
                        if (new_distance < node.distance)
                        {
                            node.distance = new_distance;
                            node.parent = min_node;
                        }
                    }
            }
        }

        private boolean isConnected(Node u, Node v)
        {
            return adjacent_table[u.index][v.index] != UNCONNECTED;
        }

        private int getEdgeCost(Node u, Node v)
        {
            return adjacent_table[u.index][v.index];
        }

        // i is a index of SSSPG#nodes
        int getPathCost(int i)
        {
            return nodes[i].distance;
        }

        private static class Node
        {
            // index for SSSPG#nodes
            int index;

            Node parent = dummy;

            // start_nodeからの最短距離
            int distance = UNCONNECTED;

            // SSSP集合に含まれているか否か
            boolean isIncluded = false;

            public Node(int index)
            {
                this.index = index;
            }
        }
    }
}
