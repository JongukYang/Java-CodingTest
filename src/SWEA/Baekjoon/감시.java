package SWEA.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

import static SWEA.method.printIntMap;

public class 감시 {
    private static int N, M, answer;
    private static int[][] map;
    private static boolean[] visited;
    private static int[] ry = {0, 1, 0, -1};
    private static int[] rx = {1, 0, -1, 0};
    private static class Node {
        int r, c;
        int spinCnt;
        int dir;

        public Node(int r, int c, int spinCnt, int dir) {
            this.r = r;
            this.c = c;
            this.spinCnt = spinCnt;
            this.dir = dir;
        }
    }
    private static ArrayList<Node> cctvQueue = new ArrayList<>();

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
                if (map[i][j] > 0 && map[i][j] < 6) {
                    int cnt = getSpinCnt(map[i][j]);
                    cctvQueue.add(new Node(i, j, cnt, 0));
                }
            }
        }

        printIntMap(map, N);

        backtrack(0, cctvQueue.size());

        System.out.println(answer);
    }
    private static void backtrack(int idx, int cctvCount) {
        if (idx == cctvCount) {
            answer = Math.min(answer, check());
        }

        Node now = cctvQueue.get(idx);

        // 각 cctv마다 돌릴 수 있는 경우의 수 만큼 회전
        for (int i = 0; i < now.spinCnt; i++) {
            int[][] copyMap = new int[N][M];
            copyMap = map.clone();

            // todo : 아직 해야함
            for (int j = 0; j < N; j++) {

            }

            printIntMap(copyMap, N);
        }
    }
    private static int getSpinCnt(int n) {
        switch (n) {
            // 4방향 다 회전
            case 1, 3, 4: return 4;
            // 2방향 회전만 하면 됨
            case 2: return 2;
            // 회전 안해도 됨
            case 5: return 1;
        }
        return 0;
    }
    private static int check() {
        return 0;
    }
}
