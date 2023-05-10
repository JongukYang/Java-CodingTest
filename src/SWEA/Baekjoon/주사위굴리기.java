package SWEA.Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 주사위굴리기 {
    private static int N, M;
    private static int[][] map;
    private static int r, c;
    private static int[] rx = {1, -1, 0, 0}; // 우 좌 상 하 순서대로 idx 설정
    private static int[] ry = {0, 0, -1, 1}; // 우 좌 상 하 순서대로 idx 설정
    private static int[] dice = new int[6 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        // 처음 좌표 (r, c)
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int commandCnt = Integer.parseInt(st.nextToken()); // 명령의 개수

        // 좌표 (x,y)는 (y,x)라고 이해해야함
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        printMap(map);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < commandCnt; i++) {
            int idx = Integer.parseInt(st.nextToken());
            moveMap(idx);
        }

    }

    private static void moveMap(int idx) {
        int nr = r + ry[idx - 1];
        int nc = c + rx[idx - 1];

        if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
            return;
        }

        diceMove(idx);

        if (map[nr][nc] == 0) {
            map[nr][nc] = dice[6];
        } else {
            dice[6] = map[nr][nc];
            map[nr][nc] = 0;
        }

        r = nr;
        c = nc;

        System.out.println(dice[1]);
    }

    private static void diceMove(int idx) {
        int temp = dice[6];
        switch (idx) {
            case 1: // 동
                dice[6] = dice[3];
                dice[3] = dice[1];
                dice[1] = dice[4];
                dice[4] = temp;
                break;
            case 2: // 서
                dice[6] = dice[4];
                dice[4] = dice[1];
                dice[1] = dice[3];
                dice[3] = temp;
                break;
            case 3: // 남
                dice[6] = dice[5];
                dice[5] = dice[1];
                dice[1] = dice[2];
                dice[2] = temp;
                break;
            case 4: // 북
                dice[6] = dice[2];
                dice[2] = dice[1];
                dice[1] = dice[5];
                dice[5] = temp;
                break;
        }
    }

    private static void printMap(int[][] currMap) {
        System.out.println("#########################");
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
}
