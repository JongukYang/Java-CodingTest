package Baekjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DFS_알파벳 {
    // 백준 골드4
    private static int R, C;
    private static char[][] map;
    private static boolean[] visited;
    private static int[] rx = {0, 0, -1, 1};
    private static int[] ry = {1, -1, 0, 0};

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean['Z' - 'A' + 1];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 첫 방문 지점을 true로 해줘야 무한루프 제거됨
        visited[map[0][0] - 'A'] = true;
        dfs(new Node(0, 0), 1);
        System.out.println(answer);
    }
    private static void dfs(Node now, int count) {
        answer = Math.max(answer, count);
        System.out.println("map: " + map[now.r][now.c] + " answer: "+answer);
        for (int i = 0; i < 4; i++) {
            int nr = now.r + ry[i];
            int nc = now.c + rx[i];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                continue;
            }
            if (visited[map[nr][nc] - 'A']) {
                continue;
            }
            visited[map[nr][nc] - 'A'] = true;
            dfs(new Node(nr, nc), count + 1);
            visited[map[nr][nc] - 'A'] = false;
        }

    }
}
