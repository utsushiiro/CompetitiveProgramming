package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/02.
 */
public class ALDS1_6_B_Partition
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.next());
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(scan.next());

        int mid_index = partition(A, 0, n-1);

        for (int i = 0; i < n; i++)
        {
            if (i == mid_index)
                System.out.print("[" + A[i] + "]");
            else
                System.out.print(A[i]);

            if (i != n-1)
                System.out.print(" ");
            else
                System.out.print("\n");
        }
    }

    private static int partition(int[] A, int start, int end)
    {
        int mid = A[end];
        int mid_index = start;

        for (int i = start; i < end; i++)
        {
            if (A[i] <= mid)
            {
                int tmp = A[i];
                A[i] = A[mid_index];
                A[mid_index] = tmp;

                mid_index++;
            }
        }

        A[end] = A[mid_index];
        A[mid_index] = mid;

        return mid_index;
    }


}

