package AOJ.ALDS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/04.
 */
public class ALDS1_11_C_BreadthFirstSearch
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int node_size = Integer.parseInt(scan.next());

        DirectedGraph graph = new DirectedGraph(node_size);

        for (int i = 0; i < node_size; i++)
        {
            int node_num = Integer.parseInt(scan.next());
            int adj_size = Integer.parseInt(scan.next());
            for (int j = 0; j < adj_size; j++)
            {
                int  adj_num = Integer.parseInt(scan.next());
                graph.connect(node_num, adj_num);
            }
        }

        graph.bfs();
        graph.dump();
    }

    /**
     * from_index, to_index is used to_index represent 1-origin node numbers.
     */
    private static class DirectedGraph
    {
        private static final boolean UNCONNECTED = false;
        private static final boolean CONNECTED = true;

        private static final int UNVISITED = 0;
        private static final int VISITED = 1;

        // 0-Origin : connect, isConnected で 0-Origin から 1-Originに変換
        private boolean [][] adjacent_table;

        // 1-Origin
        private Node[] nodes;

        DirectedGraph(int node_size)
        {
            adjacent_table = new boolean[node_size][node_size];
            nodes = new Node[node_size + 1];

            for (int i = 0; i < node_size; i++)
            {
                Arrays.fill(adjacent_table[i], UNCONNECTED);
                nodes[i + 1] = new Node();
            }
        }

        // 1-Origin
        void connect(int u, int v)
        {
            adjacent_table[u - 1][v - 1] = CONNECTED;
        }

        // 1-Origin
        boolean isConnected(int u, int v)
        {
            return adjacent_table[u - 1][v - 1];
        }

        // set the distance of nodes from_index node 1
        // the distance of nodes which can't be reached from_index the node 1 is -1
        void bfs()
        {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            int distance = 0;

            nodes[1].visit(distance);
            queue.offer(1);

            while (!queue.isEmpty())
            {
                int u = queue.poll();

                for (int v = 1; v < nodes.length; v++)
                    if (isConnected(u, v) && nodes[v].status == UNVISITED)
                    {
                        distance = nodes[u].distance + 1;
                        nodes[v].visit(distance);
                        queue.offer(v);
                    }
            }
        }

        void dump()
        {
            for (int u = 1; u < nodes.length; u++)
                System.out.println(
                        u + " " + nodes[u].distance
                );
        }

        void dump_connections()
        {
            int node_size = nodes.length - 1;
            for (int i = 0; i < node_size; i++)
            {
                for (int j = 0; j < node_size; j++)
                    if (adjacent_table[i][j])
                        System.out.print("1 ");
                    else
                        System.out.print("0 ");
                System.out.print("\n");
            }
        }

        private static class Node
        {
            int distance = -1;
            int status = UNVISITED;

            void visit(int distance)
            {
                status = VISITED;
                this.distance = distance;
            }

        }
    }
}
