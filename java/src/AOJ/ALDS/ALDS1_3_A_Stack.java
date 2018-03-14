package AOJ.ALDS;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/04/30.
 */
public class ALDS1_3_A_Stack
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while(scan.hasNext())
        {
            String elem = scan.next();
            if (elem.equals("+"))
            {
                int a = stack.pollFirst();
                int b = stack.pollFirst();
                stack.offerFirst(b + a);
            }
            else if (elem.equals("-"))
            {
                int a = stack.pollFirst();
                int b = stack.pollFirst();
                stack.offerFirst(b - a);
            }
            else if (elem.equals("*"))
            {
                int a = stack.pollFirst();
                int b = stack.pollFirst();
                stack.offerFirst(b * a);
            }
            else
            {
                int a = Integer.parseInt(elem);
                stack.offerFirst(a);
            }
        }

        System.out.println(stack.pollFirst());
    }
}
