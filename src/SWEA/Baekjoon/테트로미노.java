package SWEA.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 테트로미노 {
    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int[] ry = {0, 0, -1, 1};
    private static int[] rx = {-1, 1, 0, 0};
    private static int N, M, answer;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 백트래킹 dfs 풀기
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(new Node(i, j), 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(Node now, int size, int sum) {
        if (size == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = now.r + ry[i];
            int nc = now.c + rx[i];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                continue;
            }
            if (!visited[nr][nc]) {
                if (size == 2) {
                    visited[nr][nc] = true;
                    dfs(new Node(now.r, now.c), size + 1, sum + map[nr][nc]);
                    visited[nr][nc] = false;
                }
                visited[nr][nc] = true;
                dfs(new Node(nr, nc), size + 1, sum + map[nr][nc]);
                visited[nr][nc] = false;
            }
        }
    }
}
