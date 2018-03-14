package AOJ.ALDS;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/03.
 */
public class ALDS1_9_B_MaximumHeap
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int heap_size = Integer.parseInt(scan.next());

        MaxHeap heap = new MaxHeap(heap_size);
        for (int i = 0; i < heap_size; i++)
            heap.add(Integer.parseInt(scan.next()));

        heap.buildMaxHeap();
        heap.dump();
    }

    private static class MaxHeap
    {
        // 1-Origin
        private int[] heap;

        // heapの末尾要素が格納されているindex
        private int heap_index;

        MaxHeap(int heap_size)
        {
            heap = new int[heap_size + 1];
            heap_index = 0;
        }

        void add(int key)
        {
            // assert: 1 <= heap_index <= heap_size
            heap_index++;
            heap[heap_index] = key;
        }

        private void maxHeapify(int i)
        {
            int max_index = i;

            int left_index = i*2;
            int right_index = i*2 + 1;

            if (left_index <= heap_index)
                if (heap[i] < heap[left_index])
                    max_index = left_index;

            /*
                Miss :
                heap[max_index] < heap[right_index] を heap[i] < heap[right_index] にしていた
                これだと自分,右子,左子の中での最大にならない
            */
            if (right_index <= heap_index)
                if (heap[max_index] < heap[right_index])
                    max_index = right_index;

            if (max_index != i)
            {
                int tmp = heap[i];
                heap[i] = heap[max_index];
                heap[max_index] = tmp;

                maxHeapify(max_index);
            }
        }

        void buildMaxHeap()
        {
            for (int i = heap_index/2; i > 0; i--)
                maxHeapify(i);
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
