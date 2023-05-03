package Baekjoon.DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DP_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];
        System.out.println(Arrays.toString(dp));

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 먼저 1을 빼준다
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 1을 뺀 값과 2로 나눈 값 중 최솟값을 dp[i]에 저장한다
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 1을 뺀 값과 2로 나눈 값 중 최소값인 dp[i] 와 3으로 나눈 값 중 최솟값을 dp[i]에 저장한다
        }
        System.out.println(Arrays.toString(dp));

        System.out.println(dp[N]);
    }
}
