package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/01.
 */
public class ALDS1_5_B_MergeSort
{
    static final int  MAX_SIZE = 5000000;
    static int[] L = new int[MAX_SIZE/2 + 1];
    static int[] R = new int[MAX_SIZE/2 + 1];
    static int num_of_exchange = 0;

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.next());
        int[] A = new int[n];

        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(scan.next());

        mergeSort(A, 0, n-1);

        for (int i = 0; i < n - 1; i++)
            System.out.print(A[i] + " ");
        System.out.println(A[n-1]);
        System.out.println(num_of_exchange);
    }

    static void mergeSort(int[] A, int left, int right)
    {
        if (left < right)
        {
            int mid = (left + right) / 2;
            mergeSort(A, left, mid);
            mergeSort(A, mid + 1, right);
            merge(A, left, mid, right);
        }
        // intの丸めにより、left = right + 1 の時(つまり要素が２の配列のマージソート)
        // mid は left と同じ値になり、mid + 1 は rightと同じ値になるため
        // それぞれのmergeSortには mid と mid + 1 を渡している
    }

    static void merge(int[] A, int left, int mid, int right)
    {
        int L_len = mid - left + 1;
        int R_len = right - (mid + 1) + 1;

        for (int i = 0; i < L_len; i++)
            L[i] = A[left + i];
        for (int i = 0; i < R_len; i++)
            R[i] = A[mid + 1 + i];

        int L_i = 0, R_i = 0;
        for (int i = left; i <= right; i++)
        {
            num_of_exchange++;
            if (L_i == L_len)
                A[i] = R[R_i++];
            else if (R_i == R_len)
                A[i] = L[L_i++];
            else if (L[L_i] < R[R_i])
                A[i] = L[L_i++];
            else
                A[i] = R[R_i++];
        }
    }
}
