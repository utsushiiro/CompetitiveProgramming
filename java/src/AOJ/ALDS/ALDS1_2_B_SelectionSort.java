package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/04/30.
 */
public class ALDS1_2_B_SelectionSort
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.next());
        int[] elem = new int[N];
        for (int i=0; i<N; i++)
            elem[i] = Integer.parseInt(scan.next());

        int inversion = 0;

        for (int i=0; i<N-1; i++)
        {
            int min_i = i;

            for (int j=i+1; j<N; j++)
            {
                if (elem[j] < elem[min_i])
                    min_i = j;
            }

            if (min_i != i)
            {
                int tmp = elem[i];
                elem[i] = elem[min_i];
                elem[min_i] = tmp;
                inversion++;
            }
        }

        int k;
        for (k=0; k<N-1; k++)
            System.out.print(elem[k] + " ");
        System.out.println(elem[k]);
        System.out.println(inversion);
    }
}
