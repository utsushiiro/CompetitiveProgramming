package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/05.
 */
public class ALDS1_1_C_PrimeNumber
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int prim_count = 0;

        int input_size = Integer.parseInt(scan.next());
        for (int i = 0; i < input_size; i++)
        {
            int num = Integer.parseInt(scan.next());
            if (isPrime(num))
                prim_count++;
        }
        System.out.println(prim_count);
    }

    static boolean isPrime(int n)
    {
        if (n < 2)
            return false;

        if (n == 2)
            return true;

        if (n % 2 == 0)
            return false;

        for (int i = 3; i*i <= n; i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
