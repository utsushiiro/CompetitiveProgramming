package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/04/30.
 */
public class ALDS1_1_A_InsertionSort
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.next());
        int[] elem = new int[N];
        for (int i=0; i<N; i++)
            elem[i] = Integer.parseInt(scan.next());

        int k;
        for(k=0; k<N-1; k++)
            System.out.print(elem[k] + " ");
        System.out.println(elem[k]);

        for(int i=1; i<N; i++)
        {
            int now = elem[i];
            int j = i;
            while (j>0 && elem[j-1]>now)
            {
                elem[j] = elem[j-1];
                j--;
            }
            elem[j] = now;

            for(k=0; k<N-1; k++)
                System.out.print(elem[k] + " ");
            System.out.println(elem[k]);
        }
    }
}
