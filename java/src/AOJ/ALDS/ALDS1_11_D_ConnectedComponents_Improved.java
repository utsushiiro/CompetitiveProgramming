package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/09.
 *
 * Union-Find-Tree
 */
public class ALDS1_11_D_ConnectedComponents_Improved
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int nodes_size = Integer.parseInt(scan.next());
        DisjointSets set = new DisjointSets(nodes_size);

        int connections =  Integer.parseInt(scan.next());
        for (int i = 0; i < connections; i++)
        {
            int u = Integer.parseInt(scan.next());
            int v = Integer.parseInt(scan.next());
            set.unite(u, v);
        }

        int query_num = Integer.parseInt(scan.next());
        for (int i = 0; i < query_num; i++)
        {
            int u = Integer.parseInt(scan.next());
            int v = Integer.parseInt(scan.next());
            if (set.isInTheSameGroup(u, v))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    static class DisjointSets
    {
        Node[] nodes;

        public DisjointSets(int nodes_size)
        {
            this.nodes = new Node[nodes_size];

            for (int i = 0; i < nodes_size; i++)
            {
                nodes[i] = new Node(i);
                makeSet(nodes[i]);
            }
        }

        private void makeSet(Node node)
        {
            node.parent = node;
        }

        void unite(int index_u, int index_v)
        {
            Node root_u = findSetRootNode(nodes[index_u]);
            Node root_v = findSetRootNode(nodes[index_v]);

            if (root_u.rank < root_v.rank)
            {
                root_u.parent = root_v;
            }
            else
            {
                root_v.parent = root_u;

                if (root_u.rank == root_v.rank)
                    root_u.rank++;
            }
        }

        private Node findSetRootNode(Node node)
        {
            Node parent = node.parent;
            if (node != parent)
            {
                node.parent = findSetRootNode(parent);
            }
            return node.parent;
        }

        boolean isInTheSameGroup(int index_u, int index_v)
        {
            return findSetRootNode(nodes[index_u]) == findSetRootNode(nodes[index_v]);
        }

        static class Node
        {
            int index;
            Node parent;
            int rank;

            public Node(int index)
            {
                this.index = index;
                this.rank = 0;
            }
        }
    }
}
