package Baekjoon.BFS;

import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class BFS_미로탐색 {
    // 백준 실버 1
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] rx = {0, 0, -1, 1};
    private static int[] ry = {1, -1, 0, 0};
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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = c[j] - '0';
            }
        }

        printMap();

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + ry[i];
                int nc = now.c + rx[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }
                if (visited[nr][nc] || map[nr][nc] == 0) {
                    continue;
                }
                if (map[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.addLast(new Node(nr, nc));
                    map[nr][nc] = map[now.r][now.c] + 1;
                }
            }
        }
        printMap();

        System.out.println(map[N-1][M-1]);
    }

    private static void printMap() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println("#############################");
    }
}
