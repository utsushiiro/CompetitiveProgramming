package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/06.
 */
public class ALDS1_12_A_MinimumSpanningTree
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int nodes_size = Integer.parseInt(scan.next());

        int[][] adj = new int[nodes_size][nodes_size];
        for (int i = 0; i < nodes_size; i++)
            for (int j = 0; j < nodes_size; j++)
            {
                int w = Integer.parseInt(scan.next());
                if (w != -1)
                    adj[i][j] = w;
                else
                    adj[i][j] = MST.UNCONNECTED;
            }

        MST mst = new MST(nodes_size, adj);
        mst.buildMST();
        System.out.println(mst.getMSTWeight());
    }

    static class MST
    {
        int nodes_size;
        Node[] nodes;
        static final Node dummy = new Node(-1);

        int[][] adjacent_table;
        static final int UNCONNECTED = 2001;

        static
        {
            dummy.weight = UNCONNECTED;
        }

        MST(int nodes_size, int[][] adjacent_table)
        {
            this.nodes_size = nodes_size;
            nodes = new Node[nodes_size];
            for (int i = 0; i < nodes_size; i++)
                nodes[i] = new Node(i);

            this.adjacent_table = adjacent_table;
        }

        void buildMST()
        {
            nodes[0].weight = 0;

            while (true)
            {
                Node min_node = dummy;
                for (Node node : nodes)
                    if (!node.isIncluded && node.weight < min_node.weight)
                        min_node = node;

                // all nodes are included in a MST
                if (min_node == dummy)
                    break;

                min_node.isIncluded = true;

                for (Node node : nodes)
                    if (!node.isIncluded && isConnected(min_node, node))
                    {
                        int new_weight = getEdgeWeight(min_node, node);
                        if (new_weight < node.weight)
                        {
                            node.weight = new_weight;
                            node.parent = min_node;
                        }
                    }
            }
        }

        int getMSTWeight()
        {
            int sum = 0;
            for (Node node : nodes)
                sum += node.weight;
            return sum;
        }

        private boolean isConnected(Node u, Node v)
        {
            return adjacent_table[u.index][v.index] != UNCONNECTED;
        }

        private int getEdgeWeight(Node u, Node v)
        {
            return adjacent_table[u.index][v.index];
        }

        private static class Node
        {
            // nodesでのindex
            int index;

            Node parent = dummy;
            // parent との辺の重さ
            int weight = UNCONNECTED;

            // MSTに含まれているか否か
            boolean isIncluded = false;

            Node(int index)
            {
                this.index = index;
            }
        }
    }
}
