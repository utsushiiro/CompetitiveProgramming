package AOJ.ALDS;

import java.util.*;

/**
 * Created by @utsushiiro on 2016/05/09.
 *
 *  - don't work well in some case
 */
public class ALDS1_12_C_SingleSourceShortestPath2
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        int nodes_size = Integer.parseInt(scan.next());
        SSSPG graph = new SSSPG(nodes_size);

        for (int i = 0; i < nodes_size; i++)
        {
            int from_index = Integer.parseInt(scan.next());
            int out_degree = Integer.parseInt(scan.next());
            for (int j = 0; j < out_degree; j++)
            {
                int to_index = Integer.parseInt(scan.next());
                int cost = Integer.parseInt(scan.next());
                graph.setEdgeCost(from_index, to_index, cost);
            }
        }

        graph.buildShortestPath(0);
        graph.dumpNodesDist();
    }

    private static class SSSPG
    {

        Node[] nodes;

        List<List<Cost>> adjacent_list;
        static final long MAX_NODES_SIZE = 10000;
        static final long MAX_COST       = 100000;
        static final long UNCONNECTED    = MAX_NODES_SIZE*MAX_COST + 1;

        SSSPG(int nodes_size)
        {
            adjacent_list = new ArrayList<>();

            nodes = new Node[nodes_size];

            for (int i = 0; i < nodes_size; i++)
            {
                nodes[i] = new Node(i);
                adjacent_list.add(new ArrayList<>());
            }
        }

        void buildShortestPath(int start)
        {
            nodes[start].distance = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(nodes[start]);

            while (!pq.isEmpty())
            {
                Node min_node = pq.poll();

                if (min_node.isVisited)
                    continue;
                else
                    min_node.isVisited = true;

                for (Cost c : adjacent_list.get(min_node.index))
                {
                    Node neighbor = nodes[c.to_index];

                    if (neighbor.isVisited)
                        continue;

                    long new_distance = min_node.distance + c.cost;
                    if (new_distance < neighbor.distance)
                    {
                        neighbor.distance = new_distance;
                        pq.offer(neighbor);
                    }
                }
            }
        }

        private long getEdgeCost(int from, int to)
        {
            long cost = UNCONNECTED;
            for (Cost c : adjacent_list.get(from))
            {
                if (c.to_index == to)
                    cost = c.cost;
            }
            if (cost == UNCONNECTED) System.out.println("ok");
            return cost;
        }

        private void setEdgeCost(int from, int to, long cost)
        {
            adjacent_list.get(from).add(new Cost(from, to, cost));
        }

        private static class Node implements Comparable<Node>
        {
            // index of SSSPG#nodes
            int index;

            // default value for dijkstra
            long distance = UNCONNECTED;
            boolean isVisited =false;

            Node(int index)
            {
                this.index = index;
            }

            @Override
            public int compareTo(Node o)
            {
                return Math.toIntExact(this.distance - o.distance);
            }
        }

        private static class Cost
        {
            int from_index;
            int to_index;

            // the cost of the edge from_index "from_index" to_index "to_index"
            long cost;

            Cost(int from_index, int to_index, long cost)
            {
                this.from_index = from_index;
                this.to_index = to_index;
                this.cost = cost;
            }
        }

        void dumpEdgeCosts()
        {
            for (int i = 0; i < nodes.length; i++)
            {
                System.out.print("from: " + i + " ");
                for (Cost c : adjacent_list.get(i))
                {
                    System.out.print(
                            "[ to:" + c.to_index + " " +
                            "cost: " + c.cost + " ] "
                    );
                }
                System.out.println("");
            }
        }

        void dumpEdgeCosts_raw()
        {
            System.out.println(adjacent_list.size());
            for (int i = 0; i < nodes.length; i++)
            {
                int out_degree = adjacent_list.get(i).size();
                System.out.print(
                        i + " " + out_degree + " "
                );
                for (int j = 0; j < out_degree - 1; j++) {
                    Cost c = adjacent_list.get(i).get(j);
                    System.out.print(c.to_index + " " + c.cost + " ");
                }
                Cost last = adjacent_list.get(i).get(out_degree - 1);
                System.out.println(last.to_index + " " + last.cost);
            }
        }

        void dumpNodesDist()
        {
            for (int i = 0; i < nodes.length; i++)
                System.out.println(nodes[i].index + " " + nodes[i].distance);
        }
    }
}
