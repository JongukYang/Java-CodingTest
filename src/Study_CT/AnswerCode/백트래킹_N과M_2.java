package Study_CT.AnswerCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 실버3 - 백트래킹 - 오름차순으로 바꾸기
public class 백트래킹_N과M_2 {
    private static int N, M;
    private static StringBuilder sb;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        used = new boolean[N + 1];

        sb = new StringBuilder();

        backtrack(0, 0, "");

        System.out.println(sb);
    }

    private static void backtrack(int num, int length, String ans) {
        if (length == M) {
            sb.append(ans.trim() + "\n");
        }
        for (int i = num + 1; i <= N; i++) {
            // 사용을 하지 않았을 때만 돌리기
            if (!used[i]) {
                used[i] = true;
                backtrack(i, length + 1, ans + " " + i);
                used[i] = false;
            }
        }
    }
}
