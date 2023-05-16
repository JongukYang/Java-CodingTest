package Study_CT.AnswerCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 골드 4 - 백트래킹
public class 백트래킹_알파벳 {

    private static int R, C;
    private static boolean[] used;
    private static char[][] map;
    private static int answer;
    private static int[] rx = {0, 0, -1, 1};
    private static int[] ry = {-1, 1, 0, 0};

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        used = new boolean['Z' - 'A' + 1];
        used[map[0][0] - 'A'] = true;

        backtrack(new Node(0, 0), 1);

        System.out.println(answer);
    }

    private static void backtrack(Node now, int cnt) {
        answer = Math.max(answer, cnt);
        System.out.println("answer = " + answer);
        for (int i = 0; i < 4; i++) {
            int nr = now.r + ry[i];
            int nc = now.c + rx[i];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                continue;
            }
            if (used[map[nr][nc] - 'A']) {
                continue;
            }
            used[map[nr][nc] - 'A'] = true;
            backtrack(new Node(nr, nc), cnt + 1);
            used[map[nr][nc] - 'A'] = false;
        }
    }
}
