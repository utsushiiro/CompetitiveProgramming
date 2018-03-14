package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/01.
 */
public class ALDS1_4_B_BinarySearch
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
            if (binarySearch(S, T))
                C++;
        }

        System.out.println(C);
    }

    static boolean binarySearch(int[] elem, int key)
    {
        int left = 0;
        int right = elem.length - 1;
        int mid;

        while(left <= right)
        {
            mid = (left+right)/2;
            if (key == elem[mid])
                return true;
            else if (key < elem[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }
}
