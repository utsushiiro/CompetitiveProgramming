package AOJ.DSL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/06.
 *
 * - Union Find Tree (Path Compression)
 */
public class DSL_1_A_DisjointSet_UnionFindTree
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int nodes_size = Integer.parseInt(scan.next());
        int query_num = Integer.parseInt(scan.next());

        DisjointSets set = new DisjointSets(nodes_size);

        for (int i = 0; i < query_num; i++)
        {
            int command = Integer.parseInt(scan.next());
            int x = Integer.parseInt(scan.next());
            int y = Integer.parseInt(scan.next());

            switch (command)
            {
                case 0:
                    set.unite(x ,y);
                    break;

                case 1:
                    if (set.isInTheSameGroup(x, y))
                        System.out.println("1");
                    else
                        System.out.println("0");
                    break;
            }
        }
    }

    private static class DisjointSets
    {
        List<Node> nodes = new ArrayList<>();

        DisjointSets(int nodes_size)
        {
            for (int i = 0; i < nodes_size; i++)
                makeSet(i);
        }

        void makeSet(int index)
        {
            Node node = new Node(index);
            node.parent = node;
            nodes.add(node);
        }

        Node findSetRootNode(int index)
        {
            Node node = nodes.get(index);
            Node parent = node.parent;

            if (node != parent)
                node.parent = findSetRootNode(parent.index);

            return node.parent; // Miss : node.parent -> node, node.parent -> parent
        }

        void unite(int i, int j)
        {
            Node root_i = findSetRootNode(i);
            Node root_j = findSetRootNode(j);

            if (root_i.rank > root_j.rank)
            {
                // jの木をiの木に統合
                root_j.parent = root_i;
            }
            else
            {
                // iの木をjの木に統合
                root_i.parent = root_j;

                // iの木とjの木が同じ高さの時、統合により木の高さが1増える
                if (root_i.rank == root_j.rank)
                    root_j.rank++;
            }
        }

        boolean isInTheSameGroup(int i, int j)
        {
            return findSetRootNode(i) == findSetRootNode(j);
        }

        private static class Node
        {
            // index of DisjointSets#nodes
            int index = -1;

            // the height of a tree if this node is the root of it
            // ignore changes of this value occurred by path compressions
            int rank = 0;

            Node parent;

            public Node(int index)
            {
                this.index = index;
            }
        }
    }
}
