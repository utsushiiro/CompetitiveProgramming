package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/01.
 *
 * 要素を順番に見ていき使うか使わないかで分岐
 * こちらのほうがわかりやすいが処理速度は劣る
 */
public class ALDS1_5_A_ExhaustiveSearch_Alt
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
        boolean left;
        boolean right = false;

        if (index == A.length)
            return false;

        if (m == A[index])
            return true;

        left = search(A, index + 1, m);

        if (left)
            return true;

        if (m > A[index])
            right = search(A, index + 1, m - A[index]);

        return left || right;
    }
}
