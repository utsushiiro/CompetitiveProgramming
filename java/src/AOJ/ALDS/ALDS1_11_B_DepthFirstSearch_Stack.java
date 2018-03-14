package AOJ.ALDS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/04.
 */
public class ALDS1_11_B_DepthFirstSearch_Stack
{
    public static void main(String[] args) {
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

        graph.dfs();
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
        private static final int COMPLETED = 2;

        // 0-Origin
        private boolean [][] adjacent_table;
        // 1-Origin
        private Node[] nodes;

        private int time;

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


        void dfs()
        {
            time = 1;

            for (int u = 1; u < nodes.length; u++)
                if (nodes[u].status == UNVISITED)
                    _dfs(u);
        }

        // start : 1-Origin
        private void _dfs(int start)
        {
            ArrayDeque<Integer> stack = new ArrayDeque<>();

            nodes[start].visit(time);
            time++;
            stack.offerFirst(start);

            while (!stack.isEmpty())
            {
                int u = stack.peek();
                int v = next(u);

                if (v != -1)
                {
                    nodes[v].visit(time);
                    time++;
                    stack.offerFirst(v);
                }
                else
                {
                    u = stack.poll();
                    nodes[u].complete(time);
                    time++;
                }
            }
        }

        // return the next node to_index visit (-1 means it wasn't founded)
        private int next(int u)
        {
            int v;
            for (v = 1; v < nodes.length; v++)
                if (isConnected(u, v) && nodes[v].status == UNVISITED)
                    return v;
            return -1;
        }

        void dump()
        {
            for (int u = 1; u < nodes.length; u++)
                System.out.println(
                        u + " " + nodes[u].visited_time + " " + nodes[u].completed_time
                );
        }

        private static class Node
        {
            int visited_time = 0;
            int completed_time = 0;
            int status = UNVISITED;

            void visit(int time)
            {
                visited_time = time;
                status = VISITED;
            }

            void complete(int time)
            {
                completed_time = time;
                status = COMPLETED;
            }
        }
    }
}
