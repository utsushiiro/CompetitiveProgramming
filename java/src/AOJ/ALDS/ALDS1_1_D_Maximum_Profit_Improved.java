package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/04/30.
 *
 * 現在のRtの最大値(current_max_value)を保持せずに直接利益の最大値(max_profit)を更新
 */

public class ALDS1_1_D_Maximum_Profit_Improved
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int line_num = Integer.parseInt(scan.next());

        int min_val = Integer.parseInt(scan.next());
        int max_profit = Integer.MIN_VALUE;
        int Rt;

        for(int i=1; i<line_num; i++)
        {
            Rt = Integer.parseInt(scan.next());
            max_profit = Math.max(max_profit, Rt - min_val);
            min_val = Math.min(min_val, Rt);
        }

        System.out.println(max_profit);
        scan.close();
    }
}
