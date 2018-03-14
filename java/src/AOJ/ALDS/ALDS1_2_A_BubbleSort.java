package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/04/30.
 */
public class ALDS1_2_A_BubbleSort
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.next());
        int[] elem = new int[N];
        for (int i=0; i<N; i++)
            elem[i] = Integer.parseInt(scan.next());

        int inversion = bubbleSort(elem);

        int k;
        for (k=0; k<N-1; k++)
            System.out.print(elem[k] + " ");
        System.out.println(elem[k]);
        System.out.println(inversion);
    }

    private static int bubbleSortDescend(int[] elem)
    {
        int N = elem.length;
        int inversion = 0;

        for (int i=0; i<N-1; i++)
            for (int j = N - 1; j > i; j--)
                if (elem[j - 1] > elem[j]) {
                    int tmp = elem[j - 1];
                    elem[j - 1] = elem[j];
                    elem[j] = tmp;
                    inversion++;
                }
        return inversion;
    }

    private static int bubbleSortAscend(int[] elem)
    {
        int N = elem.length;
        int inversion = 0;

        for(int i=N-1; i>0; i--)
            for (int j = 0; j < i; j++)
                if (elem[j] > elem[j + 1])
                {
                    int tmp = elem[j];
                    elem[j] = elem[j + 1];
                    elem[j + 1] = tmp;
                    inversion++;
                }
        return inversion;
    }

    private static int bubbleSort(int[] elem)
    {
        int N = elem.length;
        int inversion = 0;
        boolean isChanged = true;

        while(isChanged)
        {
            isChanged = false;
            for (int i=0; i<N-1; i++)
                for (int j = N - 1; j > i; j--)
                    if (elem[j] < elem[j - 1])
                    {
                        int tmp = elem[j - 1];
                        elem[j - 1] = elem[j];
                        elem[j] = tmp;
                        inversion++;
                        isChanged = true;
                    }
        }

        return inversion;
    }

}
