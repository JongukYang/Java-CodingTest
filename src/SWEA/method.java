package SWEA;

import java.util.Arrays;

public class method {
    public static void printIntMap(int[][] currMap, int N) {
        System.out.println("########################");
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(currMap[i]));
        }
        System.out.println("#########################");
    }
}
