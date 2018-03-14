package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/02.
 */
public class ALDS1_6_C_QuickSort
{
    static final int MAX_SIZE = 50000;
    static Card[] L = new Card[MAX_SIZE];
    static Card[] R = new Card[MAX_SIZE];

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.next());
        Card[] cards = new Card[n];

        for (int i = 0; i < n; i++)
            cards[i] = new Card(
                    scan.next().charAt(0),
                    Integer.parseInt(scan.next())
            );

        Card[] cards_dup = cards.clone();

        quickSort(cards, 0, n - 1);
        mergeSort(cards_dup, 0, n - 1);

        if (isStable(cards, cards_dup))
            System.out.println("Stable");
        else
            System.out.println("Not stable");

        for (int i = 0; i < n; i++)
            System.out.println(cards[i].suit + " " + cards[i].number);
    }

    private static void quickSort(Card[] C, int start, int end)
    {
        if (start < end)
        {
            int mid = partition(C, start, end);
            quickSort(C, start, mid - 1);
            quickSort(C, mid + 1, end);
        }
        // ここで各quickSortの mid + 1, mid - 1 の部分を mid にすると
        // 要素数が2の時は mid == start or mid == endとなり
        // 前者の場合は、quickSort(mid, end)が無限再帰
        // 後者の場合は、quickSort(start, mid)が無限再帰となってしまう
    }

    private static int partition(Card[] C, int start, int end)
    {
        Card mid = C[end];
        int mid_index = start;

        for (int i = start; i < end; i++)
        {
            if (C[i].number <= mid.number)
            {
                Card tmp = C[i];
                C[i] = C[mid_index];
                C[mid_index] = tmp;
                mid_index++;
            }
        }

        C[end] = C[mid_index];
        C[mid_index] = mid;

        return mid_index;
    }

    private static void mergeSort(Card[] C, int left, int right)
    {
        if (left < right)
        {
            int mid = (left + right)/2;
            mergeSort(C, left, mid);
            mergeSort(C, mid + 1, right);
            merge(C, left, mid, right);
        }
    }

    private static void merge(Card[] C, int start, int mid, int end)
    {
        // R[start ... mid]
        // L[(mid+1) ... end]
        int L_len = mid - start + 1;
        int R_len = end - (mid + 1) + 1;

        System.arraycopy(C, start, L, 0, L_len);
        System.arraycopy(C, (mid + 1), R, 0, R_len);

        int L_i = 0, R_i = 0;
        for (int i = start; i <= end; i++)
        {
            if (L_i == L_len)
                C[i] = R[R_i++];
            else if (R_i == R_len)
                C[i] = L[L_i++];
            else if (L[L_i].number <= R[R_i].number)
                C[i] = L[L_i++];
            else
                C[i] = R[R_i++];
        }
    }

    private static class Card
    {
        char suit;
        int number;

        public Card(char suit, int number)
        {
            this.suit = suit;
            this.number = number;
        }
    }

    private static boolean isStable(Card[] cards, Card[] base)
    {
        // 同じCardオブジェクトを参照する配列なので同値判定で良い
        for (int i = 0; i < cards.length; i++)
            if (cards[i] != base[i])
                return false;
        return true;
    }
}


