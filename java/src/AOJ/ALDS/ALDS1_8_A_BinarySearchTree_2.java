package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/03.
 */
public class ALDS1_8_A_BinarySearchTree_2
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.next());

        BST bst = new BST();

        for (int i = 0; i < n; i++)
        {
            String command = scan.next();
            int value;

            if (command == null)
                System.exit(-1);
            else switch (command)
            {
                case "insert":
                    value = Integer.parseInt(scan.next());
                    bst.insert(value);
                    break;

                case "find":
                    value = Integer.parseInt(scan.next());
                    bst.find(value);
                    break;

                case "print":
                    bst.print();
                    break;
            }
        }
    }

    private static class BST
    {
        private Node root = Node.dummy_node;

        private static class Node
        {
            static final Node dummy_node = new Node(0);

            int key;
            Node parent = dummy_node;
            Node left = dummy_node;
            Node right = dummy_node;

            Node(int key)
            {
                this.key = key;
            }
        }

        void insert(int key)
        {
            if (root == Node.dummy_node)
            {
                root = new Node(key);
            }else
            {
                _insert(root, key);
            }
        }

        private void _insert(Node node, int key)
        {
            if (key < node.key)
            {
                if (node.left == Node.dummy_node)
                {
                    Node new_node = new Node(key);
                    new_node.parent = node;
                    node.left = new_node;
                }
                else
                {
                    _insert(node.left, key);
                }
            }
            else
            {
                if (node.right == Node.dummy_node)
                {
                    Node new_node = new Node(key);
                    new_node.parent = node;
                    node.right = new_node;
                }
                else
                {
                    _insert(node.right, key);
                }
            }
        }

        void find(int key)
        {
            if (root == Node.dummy_node)
                System.out.println("no");
            else
                _find(root, key);
        }

        private void _find(Node node, int key)
        {
            if (key == node.key)
            {
                System.out.println("yes");
            }
            else if (key < node.key)
            {
                if (node.left == Node.dummy_node)
                    System.out.println("no");
                else
                    _find(node.left, key);
            }
            else
            {
                if (node.right == Node.dummy_node)
                    System.out.println("no");
                else
                    _find(node.right, key);
            }
        }

        void print()
        {
            if (root == Node.dummy_node)
                System.out.println("No nodes");
            else
            {
                _inOrderPrint(root);
                System.out.println("");

                _preOrderPrint(root);
                System.out.println("");
            }

        }

        private void _preOrderPrint(Node node)
        {
            System.out.print(" " + node.key);

            if (node.left != Node.dummy_node)
                _preOrderPrint(node.left);

            if (node.right != Node.dummy_node)
                _preOrderPrint(node.right);
        }

        private void _inOrderPrint(Node node)
        {
            if (node.left != Node.dummy_node)
                _inOrderPrint(node.left);

            System.out.print(" " + node.key);

            if (node.right != Node.dummy_node)
                _inOrderPrint(node.right);
        }
    }
}

