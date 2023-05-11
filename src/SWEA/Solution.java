package SWEA;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {


    private static int switchCnt, answer;
    private static String[] nums;

    public static void main(String args[]) throws Exception {

//        System.setIn(new FileInputStream("src/SWEA/D3/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            nums = sc.next().split("");
            switchCnt = sc.nextInt();

            answer = Integer.MIN_VALUE;
            if (nums.length < switchCnt) {
                switchCnt = nums.length;
            }
            backtrack(0, 0);

            System.out.printf("#%d %d\n", test_case, answer);
        }
    }

    private static void backtrack(int start, int cnt) {
        if (cnt == switchCnt) {
            StringBuilder sb = new StringBuilder();
            for (String n : nums) {
                sb.append(n);
            }
            answer = Math.max(answer, Integer.parseInt(sb.toString()));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                String temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                backtrack(i, cnt + 1);

                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }


    }
}



