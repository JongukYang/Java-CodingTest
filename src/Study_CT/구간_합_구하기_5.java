package Study_CT;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 구간_합_구하기_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // N * N의 사각형
        int[][] N_Square = new int[N + 1][N + 1];

        int M = Integer.parseInt(st.nextToken()); // 구해야 하는 횟수

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            N_Square[i][1] = Integer.parseInt(st.nextToken());
            for (int j = 2; j <= N; j++) {
                N_Square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // N_Square([i][j]위치 값) + dp(위의 값) + dp(왼쪽 값) - dp(중복되는 값)
                dp[i][j] = N_Square[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }

        System.out.println();
        for (int i = 0; i < N_Square.length; i++) {
            System.out.println(Arrays.toString(N_Square[i]));
        }

        System.out.println();
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()); //
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()); //
            int y2 = Integer.parseInt(st.nextToken());

            bw.write(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1] + "\n");
        }

        bw.flush();

    }
}
