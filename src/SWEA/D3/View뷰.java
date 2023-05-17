package SWEA.D3;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

public class View뷰 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("/Users/jongukyang/GitHub-LocalRepo/Java-CodingTest/src/SWEA/D3/input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] aptHeight = new int[N];

            for (int i = 0; i < N; i++) {
                int h = sc.nextInt();
                aptHeight[i] = h;
            }

            int cnt = 0;
            for (int i = 2; i < N - 2; i++) {
                int left = Math.max(aptHeight[i - 1], aptHeight[i - 2]);
                int right = Math.max(aptHeight[i + 1], aptHeight[i + 2]);
                int maxNextHeight = Math.max(left, right);

                if (aptHeight[i] > maxNextHeight) {
                    cnt += aptHeight[i] - maxNextHeight;
                }
            }

            System.out.println("#" + test_case + " " + cnt);
        }
    }
}