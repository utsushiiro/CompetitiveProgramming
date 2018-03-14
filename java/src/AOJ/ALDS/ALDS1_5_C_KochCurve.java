package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/01.
 */
public class ALDS1_5_C_KochCurve
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Point p1 = new Point(0.0, 0.0);
        Point p2 = new Point(100.0, 0.0);

        System.out.println(p1);
        kochCurve(n, p1, p2);
        System.out.println(p2);
    }

    static void kochCurve(int n, Point p1, Point p2)
    {
        if (n == 0)
            return;

        Point s = new Point();
        Point t = new Point();
        Point u = new Point();

        s.x = (2*p1.x + p2.x)/3;
        s.y = (2*p1.y + p2.y)/3;
        t.x = (p1.x + 2*p2.x)/3;
        t.y = (p1.y + 2*p2.y)/3;

        double PI = Math.PI;
        u.x = Math.cos(PI/3)*(t.x - s.x) - Math.sin(PI/3)*(t.y - s.y) + s.x;
        u.y = Math.sin(PI/3)*(t.x - s.x) + Math.cos(PI/3)*(t.y - s.y) + s.y;

        kochCurve(n - 1, p1, s);
        System.out.println(s);
        kochCurve(n - 1, s, u);
        System.out.println(u);
        kochCurve(n - 1, u, t);
        System.out.println(t);
        kochCurve(n - 1, t, p2);
    }

    private static class Point
    {
        double x;
        double y;

        Point() {}

        Point(double x, double y)
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
