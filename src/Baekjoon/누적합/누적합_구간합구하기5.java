package Baekjoon.누적합;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 누적합_구간합구하기5 {
    // 백준 실버 1, 구간 합 구하기 5 , prefix sum
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int[][] prefixSum = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                prefixSum[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println();
        for (int i = 0; i <= N; i++) {
            System.out.println(Arrays.toString(prefixSum[i]));
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 구간합 구하기
                prefixSum[i][j] = prefixSum[i][j] + prefixSum[i][j-1] + prefixSum[i-1][j] - prefixSum[i-1][j-1];
            }
        }

        System.out.println();
        for (int i = 0; i <= N; i++) {
            System.out.println(Arrays.toString(prefixSum[i]));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int answer = prefixSum[y2][x2] - prefixSum[y2][x1 - 1] - prefixSum[y1 - 1][x2] + prefixSum[y1 - 1][x1 - 1];
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
