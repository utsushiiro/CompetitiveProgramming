package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/01.
 */
public class ALDS1_4_A_LinerSearch
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.next());
        int[] S = new int[n];
        for (int i = 0; i < n; i++)
            S[i] = Integer.parseInt(scan.next());

        int q = Integer.parseInt(scan.next());
        int C = 0;
        for (int i = 0; i < q; i++)
        {
            int T = Integer.parseInt(scan.next());
            for (int j = 0; j < n; j++)
                if (T == S[j]) {
                    C++;
                    break;
                }
        }

        System.out.println(C);
    }
}
