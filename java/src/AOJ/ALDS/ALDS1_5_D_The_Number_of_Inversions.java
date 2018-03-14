package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/05.
 */
public class ALDS1_5_D_The_Number_of_Inversions
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int input_size = Integer.parseInt(scan.next());
        int[] A = new int[input_size];

        for (int i = 0; i < input_size; i++)
            A[i] = Integer.parseInt(scan.next());

        MergeSorter sorter = new MergeSorter(A);
        System.out.println(sorter.getInversions());
    }

    static class MergeSorter
    {
        private int[] L;
        private int[] R;
        private int[] numbers;
        private long inversions;

        MergeSorter(int[] numbers)
        {
            this.numbers = numbers;
            int len = numbers.length;

            L = new int[len / 2 + 1];
            R = new int[len / 2 + 1];

            this.inversions = mergeSort(0, len - 1);
        }

        private long mergeSort(int left, int right)
        {
            long inversions = 0;

            if (left < right)
            {
                int mid = (left + right) / 2;
                inversions += mergeSort(left, mid);
                inversions += mergeSort(mid + 1, right);
                inversions += merge(left, mid, right);
            }

            return inversions;
        }

        private long merge(int left, int mid, int right)
        {
            int L_len = mid - left + 1;
            int R_len = right - (mid + 1) + 1;
            long inversions = 0;

            for (int i = 0; i < L_len; i++)
                L[i] = numbers[i + left];
            for (int i = 0; i < R_len; i++)
                R[i] = numbers[i + mid + 1];

            int L_i = 0, R_i = 0;
            for (int i = left; i <= right; i++)
            {
                if (L_i == L_len)
                    numbers[i] = R[R_i++];
                else if (R_i == R_len)
                    numbers[i] = L[L_i++];
                else if (L[L_i] <= R[R_i])
                    numbers[i] = L[L_i++];
                else
                {
                    inversions += L_len - L_i;
                    numbers[i] = R[R_i++];
                }
            }

            return inversions;
        }

        long getInversions()
        {
            return inversions;
        }
    }
}
