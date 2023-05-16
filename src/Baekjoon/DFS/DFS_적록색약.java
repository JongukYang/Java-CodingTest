package Baekjoon.DFS;

import java.awt.geom.Area;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class DFS_적록색약 {
    private static int N, AreaNum, cAreaNum;
    private static String[][] map;
    private static boolean[][] visited;
    private static int[] rx = {-1, 1, 0, 0};
    private static int[] ry = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        visited = new boolean[N][N];

        //데이터 삽입
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.substring(j, j + 1);
            }
        }

        String[] colors = {"R", "G", "B"};
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j].equals(colors[k])) {
                        AreaNum++;
                        dfs(i, j, colors[k]);
                    }
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].equals("G")) {
                    map[i][j] = "R";
                }
            }
        }

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j].equals(colors[k])) {
                        cAreaNum++;
                        dfs(i, j, colors[k]);
                    }
                }
            }
        }

        System.out.println(AreaNum + " " + cAreaNum);
    }

    private static void dfs(int i, int j, String color) {
        if (visited[i][j]) {
            return;
        }
        //방문처리
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nr = i + ry[k];
            int nc = j + rx[k];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                continue;
            }
            if (visited[nr][nc]) {
                continue;
            }
            if (map[nr][nc].equals(color)) {
                dfs(nr, nc, color);
            }
        }
    }
}
