package AOJ.ALDS;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/02.
 */
public class ALDS1_6_A_CountingSort
{
    static int VALUE_RANGE = 10000 - 0 + 1;
    static int[] C = new int[VALUE_RANGE];

    public static void main(String[] argv)
    {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.next());

        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(scan.next());

        A = countingSort(A);

        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < n-1; i++)
            pw.print(A[i] + " ");
        pw.println(A[n-1]);
        pw.flush();
    }

    private static int[] countingSort(int[] A)
    {
        int n = A.length;
        int[] B = new int[n];

        for (int i = 0; i < n; i++)
            C[A[i]]++;

        int B_i = 0;
        for (int i = 0; i < VALUE_RANGE; i++)
            while(C[i] != 0)
            {
                B[B_i] = i;
                B_i++;
                C[i]--;
            }

        return B;
    }
}
