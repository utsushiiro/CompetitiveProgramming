package AOJ.ALDS;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/03.
 */
public class ALDS1_9_C_PriorityQueue
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int max_heap_size = 2000000;
        MaxHeap pri_queue = new MaxHeap(max_heap_size);

        boolean hasNextCmd = true;
        while (hasNextCmd)
        {
            String command = scan.next();
            if (command == null)
                System.exit(-1);
            else switch (command)
            {
                case "insert":
                    int key = Integer.parseInt(scan.next());
                    pri_queue.insert(key);
                    break;

                case "extract":
                    System.out.println(pri_queue.extractMax());
                    break;

                case "end":
                    hasNextCmd = false;
                    break;
            }
        }

    }

    static class MaxHeap
    {
        // 1-Origin
        int[] heap;

        // heapの末尾の要素を指すindex
        int heap_index;

        MaxHeap(int heap_size)
        {
            heap = new int[heap_size + 1];
            heap_index = 0;
        }

        private void add(int key)
        {
            heap_index++;
            heap[heap_index] = key;
        }

        void insert(int key)
        {
            add(key);

            int parent = heap_index / 2;
            int self = heap_index;

            if (parent == 0)
                return;

            // heap[self] == key
            while (heap[parent] < heap[self])
            {
                int tmp = heap[parent];
                heap[parent] = heap[self];
                heap[self] = tmp;

                self = parent;
                parent = parent / 2;

                if (parent == 0)
                    break;
            }
        }

        // ignore the empty case
        int extractMax()
        {
            int max = heap[1];

            heap[1] = heap[heap_index];
            heap_index--;
            maxHeapify(1);

            return max;
        }

        private void maxHeapify(int root_index)
        {
            int max_index = root_index;
            int left_index  =  root_index * 2 ;
            int right_index =  root_index * 2 + 1;

            if (left_index <= heap_index)
            {
                if (heap[max_index] < heap[left_index])
                    max_index = left_index;
            }
            if (right_index <= heap_index)
            {
                if (heap[max_index] < heap[right_index])
                    max_index = right_index;
            }

            if (max_index != root_index)
            {
                int tmp = heap[max_index];
                heap[max_index] = heap[root_index];
                heap[root_index] = tmp;

                maxHeapify(max_index);
            }
        }

        void dump()
        {
            PrintWriter pw = new PrintWriter(System.out);
            for (int i = 1; i <= heap_index; i++)
                pw.print(" " + heap[i]);
            pw.print("\n");
            pw.flush();
        }
    }
}


