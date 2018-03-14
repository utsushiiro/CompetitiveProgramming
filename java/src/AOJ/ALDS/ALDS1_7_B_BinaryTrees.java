package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/02.
 */
public class ALDS1_7_B_BinaryTrees
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
            int node_id  = Integer.parseInt(scan.next());
            int left_id  = Integer.parseInt(scan.next());
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

        root.setFeatures(0);

        for (int i = 0; i < node_num; i++)
            System.out.println(nodes[i]);

    }

    private static class BNode
    {
        static BNode dummy_node = new BNode(-1);
        static
        {
            dummy_node.node_type = "dummy";
            dummy_node.parent = new BNode(-2);
            dummy_node.left = null;
            dummy_node.right = null;
        }

        int id;
        int depth = 0;
        int degree = 0;
        int height = 0;
        String node_type;
        BNode parent = dummy_node;
        BNode left = dummy_node;
        BNode right = dummy_node;


        BNode(int id)
        {
            this.id = id;
        }

        /**e
         * @return height of this node
         */
        int setFeatures(int depth)
        {
            if (parent == dummy_node)
                node_type = "root";
            else if (left == dummy_node && right == dummy_node)
                node_type = "leaf";
            else
                node_type = "internal node";

            this.depth = depth;

            int left_height  = -1;
            int right_height = -1;

            if (left != dummy_node)
            {
                this.degree++;
                left_height = left.setFeatures(depth + 1);
            }

            if (right != dummy_node)
            {
                this.degree++;
                right_height = right.setFeatures(depth + 1);
            }

            if (left == dummy_node && right == dummy_node)
                this.height = 0;
            else if (left_height < right_height)
                this.height = right_height + 1;
            else
                this.height = left_height + 1;

            return this.height;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("node ");
            sb.append(id);
            sb.append(": parent = ");
            sb.append(parent.id);
            sb.append(", sibling = ");
            if (this.parent == dummy_node) // case : root node
                sb.append("-1");
            else if (this == this.parent.left)
                sb.append(this.parent.right.id);
            else
                sb.append(this.parent.left.id);
            sb.append(", degree = ");
            sb.append(degree);
            sb.append(", depth = ");
            sb.append(depth);
            sb.append(", height = ");
            sb.append(height);
            sb.append(", ");
            sb.append(node_type);
            return sb.toString();
        }
    }
}
