package AOJ.ALDS;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/04/30.
 */
public class ALDS1_3_C_DoublyLinkedList
{

    public static void main(String[] arg)
    {
        DLL list = new DLL();
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.next());

        for (int i = 0; i < N; i++)
        {
            String command = scan.next();
            int key;

            // if-else switch idiom
            if (command == null)
                System.exit(-1);
            else switch (command)
            {
                case "_insert":
                    key = Integer.parseInt(scan.next());
                    list.insert(key);
                    break;
                case "delete":
                    key = Integer.parseInt(scan.next());
                    list.delete(key);
                    break;
                case "deleteFirst":
                    list.deleteFirst();
                    break;
                case "deleteLast":
                    list.deleteLast();
            }
        }

        list.print();
    }

    static class DLL
    {
        // this is dummy node to_index make it easy to_index manage the DLL
        Node head;

        DLL()
        {
            this.head = new Node(-1);
            this.head.prev = this.head;
            this.head.next = this.head;
        }

        void insert(int key)
        {
            Node tmp = new Node(key);

            if (head.next != null)
            {
                Node first = head.next;

                head.next = tmp;
                tmp.prev = head;

                tmp.next = first;
                first.prev = tmp;
            }
            else
            {
                head.next = tmp;
                tmp.prev = head;

                head.prev = tmp;
                tmp.next = head;
            }
        }

        void deleteFirst()
        {
            if (head.next == head) return;
            Node first = head.next;
            Node second = first.next;

            // this works well in case second == head
            // it can be checked by replacing "second" by "head"
            head.next = second;
            second.prev = head;
        }

        void deleteLast()
        {
            if (head.prev == head) return;
            Node last = head.prev;
            Node previous = last.prev; // previous == next to_index the last

            // this works well in case previous == head
            previous.next = head;
            head.prev = previous;
        }

        void delete(int key)
        {
            // find the first node with the given key
            Node tmp = head.next;
            while(tmp != head)
            {
                if (tmp.key == key)
                    break;
                tmp = tmp.next;
            }
            if (tmp == head) return;

            // delete it
            if (tmp == head.next)
                deleteFirst();
            else if (tmp == head.prev)
                deleteLast();
            else
            {
                Node prev = tmp.prev;
                Node next = tmp.next;
                prev.next = next;
                next.prev = prev;
            }
        }

        void print()
        {
            Node tmp = head.next;
            if (tmp == head) return;

            // use PrintWriter because of TLE
            PrintWriter out = new PrintWriter(System.out);

            while(tmp != head.prev)
            {
                out.print(tmp.key + " ");
                tmp = tmp.next;
            }
            out.println(tmp.key);
            out.flush();
        }
    }

    static class Node
    {
        Node prev;
        Node next;
        int key;

        Node(int key)
        {
            this.key = key;
        }
    }
}
