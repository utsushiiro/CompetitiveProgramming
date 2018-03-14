package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/03.
 */
public class ALDS1_7_C_TreeWalk
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int node_num = Integer.parseInt(scan.next());
        BNode[] nodes = new BNode[node_num];
        for (int id = 0; id < node_num; id++)
            nodes[id] = new BNode(id);

        for (int i = 0; i < node_num; i++)
        {
            int node_id = Integer.parseInt(scan.next());
            int left_id = Integer.parseInt(scan.next());
            int right_id = Integer.parseInt(scan.next());

            if (left_id != -1)
            {
                nodes[node_id].left = nodes[left_id];
                nodes[left_id].parent = nodes[node_id];
            }

            if (right_id != -1)
            {
                nodes[node_id].right = nodes[right_id];
                nodes[right_id].parent = nodes[node_id];
            }
        }

        BNode root = BNode.dummy_node;
        for (int i = 0; i < node_num; i++)
            if (nodes[i].parent == BNode.dummy_node)
                root = nodes[i];


        System.out.println("Preorder");
        root.traversePreOrder();
        System.out.println("");

        System.out.println("Inorder");
        root.traverseInOrder();
        System.out.println("");

        System.out.println("Postorder");
        root.traversePostOrder();
        System.out.println("");
    }

    private static class BNode
    {
        static BNode dummy_node = new BNode(-1);

        int id;
        BNode parent = dummy_node;
        BNode left = dummy_node;
        BNode right = dummy_node;

        BNode(int id)
        {
            this.id = id;
        }

        void traversePreOrder()
        {
            System.out.print(" " + id);

            if (left != dummy_node)
                left.traversePreOrder();

            if (right != dummy_node)
                right.traversePreOrder();
        }

        void traverseInOrder()
        {
            if (left != dummy_node)
                left.traverseInOrder();

            System.out.print(" " + id);

            if (right != dummy_node)
                right.traverseInOrder();
        }

        void traversePostOrder()
        {
            if (left != dummy_node)
                left.traversePostOrder();

            if (right != dummy_node)
                right.traversePostOrder();

            System.out.print(" " + id);
        }
    }
}
