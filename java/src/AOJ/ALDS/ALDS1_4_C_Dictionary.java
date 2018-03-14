package AOJ.ALDS;

import java.util.Scanner;

/**
 * Created by @utsushiiro on 2016/05/01.
 */
public class ALDS1_4_C_Dictionary
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.next());
        Dictionary dict = new Dictionary(1046527);

        for (int i = 0; i < N; i++)
        {
            String command = scan.next();
            String value = scan.next();

            if (command == null)
                System.exit(-1);
            else switch (command)
            {
                case "_insert":
                    dict.insert(value);
                    break;
                case "find":
                    dict.find(value);
                    break;
            }
        }

    }

    static class Dictionary
    {
        String[] dictionary;
        int size;

        // size should be a prime number
        Dictionary(int size)
        {
            this.size = size;
            this.dictionary = new String[size];
        }

        // the case where dictionary becomes full isn't taken into account
        void insert(String str)
        {
            int seed = convertHashSeed(str);
            for (int i = 0;; i++)
            {
                int index = hash(seed, i);

                if (dictionary[index] == null)
                {
                    dictionary[index] = str;
                    return;
                }
                else if (dictionary[index] != null)
                {
                    if (str.equals(dictionary[index]))
                        return;
                }
            }
        }

        // the case where dictionary becomes full isn't taken into account
        void find(String str)
        {
            int seed = convertHashSeed(str);
            for (int i = 0;; i++)
            {
                int index = hash(seed, i);

                if (dictionary[index] == null)
                {
                    System.out.println("no");
                    return;
                }
                else if (str.equals(dictionary[index]))
                {
                    System.out.println("yes");
                    return;
                }
            }
        }

        private int convertHashSeed(String str)
        {
            int hash_seed = 0;
            // weight for the character position in a string
            int weight = 1;
            int length = str.length();

            for (int i = 0; i < length; i++)
            {
                char c = str.charAt(i);
                hash_seed += c*weight;
                weight += 3;
            }

            return hash_seed;
        }

        // find Double-Hash method
        private int hash(int seed, int i)
        {
            return  (firstHash(seed) + i * secondHash(seed)) % size;
        }

        private int firstHash(int seed)
        {
            return seed % size;
        }


        private int secondHash(int seed)
        {
            // add 1 to_index avoid a secondHash's becoming 1
            // in that case, searching address in hash() becomes a liner-find(not good)
            return 1 + seed % (size - 1);
        }
    }

}
