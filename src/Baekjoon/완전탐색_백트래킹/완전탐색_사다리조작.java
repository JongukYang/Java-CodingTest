package Baekjoon.완전탐색_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 완전탐색_사다리조작 {
    // 백준 골드3 사다리 조작
    private static int N, M, H;
    private static int[][] map;
    private static int MinResult;
    private static boolean isFinish = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사다리게임
        // 5 5 6
        // 1 1
        // 3 2
        // 2 3
        // 5 1
        // 5 4
        // N개의 세로선, M개의 가로선, 각각의 세로선마다 가로선을 놓을 수 있는 위치의 개수는 H
        // i번 세로선에서 시작하면 결과가 i번 세로선의 끝으로 내려와야함.
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 가로선의 y좌표
            int b = Integer.parseInt(st.nextToken()); // 가로선의 x좌표
            // 원본 map 배열
            map[a][b] = 1;
            map[a][b + 1] = 2;
        }

        for (int i = 1; i < map[i].length; i++) {
            map[0][i] = -1;
            map[map.length - 1][i] = -2;
        }

        // map 출력 예상
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        for (int i = 0; i <= 3; i++) {
            MinResult = i;
            dfs(1, 1, 0);
            if (isFinish) {
                break;
            }
        }
        System.out.println(isFinish ? MinResult : -1);

    }

    private static void dfs(int y, int x, int cnt) {
        if (isFinish) {
            return;
        }
        if (cnt == MinResult) {
            if (check()) {
                isFinish = true;
            }
            return;
        }
        for (int i = y; i <= H; i++) {
            for (int j = x; j < N; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    dfs(1, 1, cnt + 1);
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }

    }

    private static boolean check() {
        for (int i = 1; i <= N; i++) {
            int x = i;
            int y = 1;

            while (y <= H) {
                if (map[y][x] == 1) {
                    x++;
                } else if (map[y][x] == 2) {
                    x--;
                }
                y++;
            }
            if (x != i) {
                return false;
            }
        }
        return true;
    }
}


//if (visited[now.r][now.c]) {
//        return;
//        }
//        // 방문체크 -> 무한루프 제거
//        visited[now.r][now.c] = true;

//for (int i = 0; i < 3; i++) {
//        int next_r = now.r + ry[i];
//        int next_c = now.c + rx[i];
//
//        // 맵 밖으로 나가는 경우 예외처리
//        if (next_r < 1 || next_c < 1 || next_r >= H || next_c >= N) {
//        continue;
//        }
//        // 시작지점에서 바로 왼쪽 또는 오른쪽으로 가는걸 막기
//        if (map[next_r][next_c] == -1) {
//        continue;
//        }
//        // 도착지점일경우
//        if (map[next_r][next_c] == -2) {
//        // 끝내기?
//        return;
//        }
//        // 다음 노드가 무조건 지나가야 하는 길
//        if (map[next_r][next_c] == 1 || map[next_r][next_c] == 2) {
//        dfs(new Node(next_r,next_c));
//        }
//        // 내려가기만 해야 하니가 다음 노드가 0이고 우,좌 쪽이라면 안해도됨
//        if (map[next_r][next_c] == 0 && (i == 0 || i == 2)) {
//        continue;
//        }
//        }