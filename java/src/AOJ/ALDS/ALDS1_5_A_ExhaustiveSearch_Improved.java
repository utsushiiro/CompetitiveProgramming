package AOJ.ALDS;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/03.
 */
public class ALDS1_5_A_ExhaustiveSearch_Improved
{
    private static int[][] dp;

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.next());
        int[] A = new int[n];
        for (int i = 0; i < n   ; i++)
            A[i] = Integer.parseInt(scan.next());


        dp = new int[n + 1][]; //(1)

        int q = Integer.parseInt(scan.next());
        for (int i = 0; i < q; i++)
        {
            int m = Integer.parseInt(scan.next());

            // わざわざ毎回mにあったサイズの配列を生成しなくてもm最大の大きさに合わせて
            // 一回だけ生成したほうが高速でサイズも節約できる
            // つまり(1)で dp = new int[n+1][2000 + 1]とすると良い
            for (int j = 0; j < n + 1; j++)
            {
                dp[j] = new int[m + 1];
                Arrays.fill(dp[j], -1);
            }

            int res = search(A, 0, m);
            if (res == 0)
                System.out.println("no");
            else
                System.out.println("yes");
        }
    }

    private static int search(int[] A, int index, int m)
    {
        if(dp[index][m] != -1)
            return dp[index][m];

        if (index == A.length)
            return dp[index][m] = 0;

        if (A[index] == m)
            return dp[index][m] = 1;

        if (search(A, index + 1, m) == 1)
            return dp[index][m] = 1;

        if (m - A[index] > 0)
            return dp[index][m] = search(A, index + 1, m - A[index]);
        else
            return dp[index][m] = 0;
    }
}
