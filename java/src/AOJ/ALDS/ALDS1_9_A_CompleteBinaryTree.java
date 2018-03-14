package AOJ.ALDS;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/03.
 */
public class ALDS1_9_A_CompleteBinaryTree
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int heap_size = Integer.parseInt(scan.next());

        // Zero Origin
        int[] heap = new int[heap_size];
        for (int i = 0; i < heap_size; i++)
            heap[i] =Integer.parseInt(scan.next());

        printHeap(heap);
    }

    static void printHeap(int[] heap)
    {
        PrintWriter pw = new PrintWriter(System.out);
        int heap_size = heap.length;

        for (int i = 0; i < heap_size; i++)
        {
            pw.print("node " + (i+1) + ": key = " + heap[i] + ", ");
            if (i != 0)
            {
                if (i % 2 != 0)
                    pw.print("parent key = " + heap[i / 2] + ", ");
                else
                    pw.print("parent key = " + heap[(i - 1) / 2] + ", ");
            }
            if (i * 2 + 1 < heap_size)
                pw.print("left key = " + heap[i * 2 + 1] + ", ");
            if ((i + 1) * 2 < heap_size)
                pw.print("right key = " + heap[(i + 1) * 2] + ", ");
            pw.print("\n");
        }

        pw.flush();
    }
}
