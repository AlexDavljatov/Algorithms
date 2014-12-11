package stepic.algosAndStructs.Structs.intervals;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by alexander on 12.12.14.
 */
public class IntervalTree {
    public static void main(String[] args) {
        int[] tree;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int size = 1;
        while (size < n) size <<= 1;
        tree = new int[2 * size];
        Arrays.fill(tree, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            tree[size + i] = in.nextInt();
        }
        for (int i = size - 1; i >= 0; i--) {
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }
        System.out.println(Arrays.toString(tree));
    }
}
