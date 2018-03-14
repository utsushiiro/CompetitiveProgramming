package AOJ.ALDS;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/02.
 */
public class ALDS1_7_A_RootedTrees
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int node_num = Integer.parseInt(scan.next());
        Node[] nodes = new Node[node_num];
        for (int i = 0; i < node_num; i++)
            nodes[i] = new Node(i);

        for (int i = 0; i < node_num; i++) {
            int node_id = Integer.parseInt(scan.next());
            int children_num = Integer.parseInt(scan.next());
            for (int j = 0; j < children_num; j++) {
                int child_id = Integer.parseInt(scan.next());
                // ノード(node_id)の子ノードを設定
                nodes[node_id].children.add(nodes[child_id]);
                // ノート(child_id)の親のをノード(node_id)に設定(Miss)
                nodes[child_id].parent = nodes[node_id];
            }
        }

        // search the root node
        Node root = Node.dummy_node;
        for (int i = 0; i < node_num; i++)
            if (nodes[i].parent == Node.dummy_node)
                root = nodes[i];

        root.setDepthAndParent(0);

        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < node_num; i++)
            pw.println(nodes[i]);
        pw.flush();
    }

    private static class Node
    {
        static Node dummy_node = new Node(-1);
        int id;
        int depth = 0;
        String node_type;
        Node parent = dummy_node;
        List<Node> children = new ArrayList<>();

        Node(int id)
        {
            this.id = id;
        }

        void setDepthAndParent(int depth)
        {
            if (parent.id == -1)
                node_type = "root";
            else if (children.size() == 0)
                node_type = "leaf";
            else
                node_type = "internal node";

            this.depth = depth;

            for (Node child : children)
            {
                child.parent = this;
                child.setDepthAndParent(depth + 1);
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("node ");
            sb.append(id);
            sb.append(": parent = ");
            sb.append(parent.id);
            sb.append(", depth = ");
            sb.append(depth);
            sb.append(", ");
            sb.append(node_type);
            sb.append(", ");
            sb.append("[");
            if (children.size() != 0)
            {
                for (int i = 0; i < children.size() - 1; i++) {
                    sb.append(children.get(i).id);
                    sb.append(", ");
                }
                sb.append(children.get(children.size() - 1).id);
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
