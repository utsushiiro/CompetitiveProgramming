package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/01.
 */
public class ALDS1_5_A_ExhaustiveSearch
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.next());
        int[] A = new int[n];
        for (int i=0; i < n; i++)
            A[i] = Integer.parseInt(scan.next());

        int q = Integer.parseInt(scan.next());
        for (int i=0; i < q; i++)
        {
            int m = Integer.parseInt(scan.next());
            if (search(A, 0, m))
                System.out.println("yes");
            else
                System.out.println("no");

        }
    }

    static boolean search(int[] A, int index, int m)
    {
        int tmp_m;
        boolean res;

        for (int i = index; i < A.length; i++)
        {
            tmp_m = m - A[i];

            if (tmp_m == 0)
                return true;
            else if (tmp_m > 0)
            {
                res = search(A, i + 1, tmp_m);
                if (res)
                    return true;
                // in case(res == false):
                //  mustn't return false not to_index skip the following loops
            }

            //in case(tmp_m < 0): go to_index the next loop
        }

        return false;
    }
}
