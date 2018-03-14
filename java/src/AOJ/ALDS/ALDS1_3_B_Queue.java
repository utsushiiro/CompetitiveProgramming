package AOJ.ALDS;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/04/30.
 */
public class ALDS1_3_B_Queue
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.next());
        int quantum = Integer.parseInt(scan.next());

        Queue<Process> queue = new ArrayDeque<>();
        for (int i=0; i<N; i++)
            queue.offer(
                    new Process(scan.next(), Integer.parseInt(scan.next()))
            );

        int total_time = 0;
        while (!queue.isEmpty())
        {
            Process process = queue.poll();
            if (process.time > quantum)
            {
                process.time -= quantum;
                total_time += quantum;
                queue.offer(process);
            }
            else
            {
                total_time += process.time;
                System.out.println(process.name + " " + total_time);
            }
        }
    }

    static class Process
    {
        String name;
        int time;

        public Process(String name, int time)
        {
            this.name = name;
            this.time = time;
        }
    }
}
