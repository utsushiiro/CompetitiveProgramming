package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/04/30.
 */

public class ALDS1_1_D_Maximum_Profit
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int line_num = Integer.parseInt(scan.next());
        int max_profit = Integer.MIN_VALUE;
        int current_max_profit = Integer.MIN_VALUE;
        int current_max_val = 0;
        int current_min_val;

        int Rt = Integer.parseInt(scan.next());
        current_min_val = Rt;
        for (int i=1; i<line_num; i++)
        {
            Rt = Integer.parseInt(scan.next());
            if (Rt > current_max_val)
            {
                current_max_val = Rt;
                current_max_profit = current_max_val - current_min_val;
            }

            if (Rt < current_min_val)
            {
                current_min_val = Rt;
                current_max_val = 0;
                if (current_max_profit > max_profit)
                    max_profit = current_max_profit;
            }
        }
        if (current_max_profit > max_profit)
            max_profit = current_max_profit;

        System.out.println(max_profit);
    }
}
