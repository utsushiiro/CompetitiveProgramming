package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/05.
 */
public class ALDS1_1_B_GreatestCommonDivisor
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int x = Integer.parseInt(scan.next());
        int y = Integer.parseInt(scan.next());
        System.out.println(gcd(x, y));
    }

    static int gcd(int x, int y)
    {
        if (x < y)
        {
            int tmp = x;
            x = y;
            y = tmp;
        }

        int r;
        while (y != 0)
        {
            r = x % y;
            x = y;
            y = r;
        }

        return x;
    }
}
