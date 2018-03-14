package AOJ.ALDS;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/04.
 *
 * - Memory Limit Exceeded
 */
public class ALDS1_11_D_ConnectedComponents
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int nodes_size = Integer.parseInt(scan.next());
        UnDirectedGraph graph = new UnDirectedGraph(nodes_size);

        int connections_size = Integer.parseInt(scan.next());
        for (int i = 0; i < connections_size; i++)
        {
            int u = Integer.parseInt(scan.next());
            int v = Integer.parseInt(scan.next());
            graph.connect(u,v);
        }

        graph.separateComponents();

        int query_size = Integer.parseInt(scan.next());
        for (int i = 0; i < query_size; i++)
        {
            int u = Integer.parseInt(scan.next());
            int v = Integer.parseInt(scan.next());
            if (graph.isTheSameGroup(u ,v))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    private static class UnDirectedGraph
    {
        private Node[] nodes;
        private List<List<Integer>> adjacent_lists = new ArrayList<>();

        UnDirectedGraph(int nodes_size)
        {
            nodes = new Node[nodes_size];
            for (int i = 0; i < nodes_size; i++)
            {
                nodes[i] = new Node();
                adjacent_lists.add(new ArrayList<>());
            }
        }

        void separateComponents()
        {
            int group_id = 1;
            for (int i = 0; i < nodes.length; i++)
                if (!nodes[i].isVisited)
                {
                    makeComponent(i, group_id);
                    group_id++;
                }
        }

        private void makeComponent(int start, int group_id)
        {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            nodes[start].visit(group_id);
            queue.offer(start);

            while (!queue.isEmpty())
            {
                int u = queue.poll();

                for (int v = 0; v < nodes.length; v++)
                    if (isConnected(u, v) && !nodes[v].isVisited)
                    {
                        nodes[v].visit(group_id);
                        queue.offer(v);
                    }
            }
        }

        boolean isTheSameGroup(int u, int v)
        {
            return nodes[u].group_id == nodes[v].group_id;
        }

        void connect(int u, int v)
        {
            adjacent_lists.get(u).add(v);
            adjacent_lists.get(v).add(u);
        }

        boolean isConnected(int u, int v)
        {
            return adjacent_lists.get(u).contains(v);
        }

        void dump_connections()
        {
            for (List<Integer> list : adjacent_lists)
            {
                for (Integer elem : list)
                    System.out.print(elem + " ");
                System.out.print("\n");
            }
        }

        private static class Node
        {
            boolean isVisited = false;
            int group_id = -1;

            void visit(int group_id)
            {
                this.group_id = group_id;
                isVisited = true;
            }
        }
    }
}
