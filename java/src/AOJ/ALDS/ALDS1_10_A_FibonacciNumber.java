package AOJ.ALDS;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/03.
 */
public class ALDS1_10_A_FibonacciNumber
{
    static int[] dp;

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        System.out.println(fibonacci(n));
    }

    static int fibonacci(int n)
    {
        if (dp[n] != -1)
            return dp[n];

        if (n < 2)
            return dp[n] = 1;
        else
            return dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
