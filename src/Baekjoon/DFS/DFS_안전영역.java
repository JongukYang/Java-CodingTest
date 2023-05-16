package Baekjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS_안전영역 {
    // 백준 실버1
    private static int N, MaxHeight;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] rx = {0, 0, -1, 1};
    private static int[] ry = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > MaxHeight) {
                    MaxHeight = map[i][j];
                }
            }
        }

        // 영역의 개수 세주기, 영역에 속한 지역 수 카운트
        int maxArea = 0;
        for (int k = 0; k < MaxHeight+1; k++) {
            visited = new boolean[N][N];
            int AreaNum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] >= k) {
                        AreaNum += dfs(i, j, k);
                    }
                }
            }
            maxArea = Math.max(maxArea, AreaNum);
        }

        System.out.println(maxArea);

    }

    private static int dfs(int row, int col, int height) {
        // 방문체크
        if (visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int nr = row + ry[i];
            int nc = col + rx[i];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                continue;
            }
            if (!visited[nr][nc] && map[nr][nc] >= height) {
                dfs(nr, nc, height);
            }
        }
        return 1;
    }
}
