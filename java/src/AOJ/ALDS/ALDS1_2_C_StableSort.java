package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/04/30.
 */
public class ALDS1_2_C_StableSort
{
    public static void main(String[] args)
    {
        // read input
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.next());
        Trump[] trumps = new Trump[N];
        for (int i=0; i<N; i++)
        {
            String card = scan.next();
            trumps[i] = new Trump(
                    card.charAt(0),
                    card.charAt(1) - '0'
            );
        }

        // bubbleSort part
        Trump[] trumps_sorted = trumps.clone();
        bubbleSort(trumps_sorted);

        // output a result
        int i;
        for (i=0; i<N-1; i++)
            System.out.print(trumps_sorted[i] + " ");
        System.out.println(trumps_sorted[i]);

        // judge isStable?
        if (isStable(trumps, trumps_sorted))
            System.out.println("Stable");
        else
            System.out.println("Not Stable");

        // selectionSort part
        trumps_sorted = trumps.clone();
        selectionSort(trumps_sorted);

        // output a result
        for (i=0; i<N-1; i++)
            System.out.print(trumps_sorted[i] + " ");
        System.out.println(trumps_sorted[i]);

        // judge isStable?
        if (isStable(trumps, trumps_sorted))
            System.out.println("Stable");
        else
            System.out.println("Not stable");
    }

    private static void bubbleSort(Trump[] trumps)
    {
        int N = trumps.length;
        for (int i = 0; i < N; i++)
            for (int j = N - 1; j > i; j--)
                if (trumps[j].value < trumps[j - 1].value)
                {
                    Trump tmp = trumps[j - 1];
                    trumps[j - 1] = trumps[j];
                    trumps[j] = tmp;
                }
    }

    private  static void selectionSort(Trump[] trumps)
    {
        int N = trumps.length;
        for (int i = 0; i < N; i++)
        {
            int min_i = i;
            for (int j = i; j < N; j++)
            {
                if (trumps[j].value < trumps[min_i].value)
                    min_i = j;
            }

            if (min_i != i)
            {
                Trump tmp = trumps[i];
                trumps[i] = trumps[min_i];
                trumps[min_i] = tmp;
            }
        }

    }

    /**
     * 配列aの要素の内、値が等しい任意の組み合わせ a[i], a[j] (i<j) に対して
     * 配列b(配列aを整列したもの)の b[k](== a[i]), b[l](== a[j]) を考え
     * k < l を満たしているか判定し、安定かどうかを判断している
     *
     * 計算量は O(N^3) だが、(1)の部分をバイナリサーチにすれば O(N^2logN)
     */
    private static boolean isStable(Trump[] a, Trump[] b)
    {
        int N = a.length;
        for (int i=0; i<N-1; i++)
        {
            for (int j=i+1; j<N; j++)
            {
                Trump a1 = a[i];
                Trump a2 = a[j];

                // 値が等しくないカードの組み合わせはスキップ
                if (a[i].value != a[j].value) continue;

                int b1 = -1;
                int b2 = -1;

                // (1)
                for (int k=0; k<N; k++) {
                    if (a1.equals(b[k]))
                        b1 = k;
                    if (a2.equals(b[k]))
                        b2 = k;
                }

                // 順序が変わっているので安定でない
                if (b1 > b2)
                    return false;
            }
        }
        return  true;
    }

    private static class Trump
    {
        char suit;
        int value;

        Trump(char suit, int value)
        {
            this.value = value;
            this.suit = suit;
        }

        @Override
        public boolean equals(Object obj) {
            Trump t = (Trump)obj;
            if (this.value == t.value)
                if (this.suit == t.suit)
                    return true;
            return false;
        }

        @Override
        public String toString() {
            return ""  + suit + value;
        }
    }
}
