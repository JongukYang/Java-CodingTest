package Study_CT.AnswerCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백트래킹_N과M_1 {
    private static boolean[] used;
    private static int N, M;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        used = new boolean[N + 1];

        sb = new StringBuilder();

        backtrack(0, "");

        System.out.println(sb);
    }

    private static void backtrack(int cnt, String s) {
        // cnt는 현재까지 고른 숫자의 개수, s는 현재까지 만들어진 String
        if (cnt == M) {
            sb.append(s.trim() + "\n");
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                backtrack(cnt + 1, s + " " + i);
                used[i] = false;
            }
        }

    }
}
