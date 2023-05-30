package SWEA.D3;

import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class 오셀로게임 {
    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int[] ry = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static int[] rx = {-1, 0, 1, 1, 1, 0, -1, -1};
    private static int N, M, black, white;
    private static int[][] map;
    private static ArrayDeque<Node> globalQueue;


    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("/Users/jongukyang/GitHub-LocalRepo/Java-CodingTest/src/SWEA/D3/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt(); // 보드의 크기
            M = sc.nextInt(); // 돌을 놓는 횟수

            map = new int[N][N];

            int mid = N / 2;
            map[mid][mid] = 2;
            map[mid-1][mid -1] = 2;
            map[mid -1][mid] = 1;
            map[mid][mid -1] = 1;

            for (int i = 0; i < M; i++) {
                // (r, c) 좌표에 1흑 2백 돌 놓기
                int r = sc.nextInt() -1;
                int c = sc.nextInt() -1;
                int color = sc.nextInt();

                search(new Node(r, c), color);
            }

            // 게임이 끝난 후 보드 위의 흑돌, 백돌의 개수 출력하기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) {
                        black++;
                    } else {
                        white++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + black + " " + white);
        }
    }

    private static void search(Node now, int color) {
        globalQueue = new ArrayDeque<>();
        // 8방향 탐색
        for (int i = 0; i < 8; i++) {
            int nr = now.r + ry[i];
            int nc = now.c + rx[i];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                continue;
            }
            if (map[nr][nc] == color || map[nr][nc] == 0) {
                continue;
            }

            ArrayDeque<Node> queue = new ArrayDeque<>();
            while (true) {
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    break;
                }
                if (map[nr][nc] != 0 && map[nr][nc] != color) {
                    queue.addLast(new Node(nr, nc));
                }
                else if (map[nr][nc] == color) {
                    while (!queue.isEmpty()) {
                        globalQueue.addLast(queue.pollFirst());
                    }
                    break;
                }
                nr += ry[i];
                nc += rx[i];
            }
        }
        if (globalQueue.size() > 0) {
            map[now.r][now.c] = color;
            while (!globalQueue.isEmpty()) {
                Node n = globalQueue.pollFirst();
                map[n.r][n.c] = color;
            }
        }
    }
}