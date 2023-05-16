package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BFS_다리만들기 {
    // 백준 골드3
    private static int N;
    private static int ANSWER = Integer.MAX_VALUE;
    private static int IslandNum = 1;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] rx = {0, 0, -1, 1};
    private static int[] ry = {1, -1, 0, 0};

    private static class Node {
        int r, c;
        int dist;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 마다 번호 다르게 부여하기 -> BFS
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    map[i][j] = IslandNum;
                    setIslandNum(i, j);
                    IslandNum++;
                }
            }
        }

        // 섬 간의 거리 측정하기 -> BFS
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    setBridgeDist(i, j, map[i][j]);
                    visited = new boolean[N][N];
                }
            }
        }
        System.out.println(ANSWER);
    }

    private static void setBridgeDist(int r, int c, int islandNum) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(r, c, 0));

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nr = now.r + ry[i];
                int nc = now.c + rx[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    continue;
                }
                if (visited[nr][nc] || map[nr][nc] == islandNum) {
                    continue;
                }
                if (map[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    queue.addLast(new Node(nr, nc, now.dist + 1));
                } else {
                    ANSWER = Math.min(ANSWER, now.dist);
                    return;
                }
            }
        }
    }

    private static void setIslandNum(int r, int c) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(r, c, 0));

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nr = now.r + ry[i];
                int nc = now.c + rx[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    continue;
                }
                if (visited[nr][nc] || map[nr][nc] == 0) {
                    continue;
                }
                visited[nr][nc] = true;
                map[nr][nc] = IslandNum;
                queue.addLast(new Node(nr, nc, 0));
            }
        }
    }
}

