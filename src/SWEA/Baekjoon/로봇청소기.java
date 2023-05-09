package SWEA.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 로봇청소기 {
    // 백준 골드 5 로봇청소기 시뮬레이션
    private static class Node {
        int r, c, direction;

        public Node(int r, int c, int direction) {
            this.r = r;
            this.c = c;
            this.direction = direction;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", direction=" + direction +
                    '}';
        }
    }

    private static int N, M, answer;
    private static int[][] map;
    private static int[] rx = {0, 0, -1, 1}; // 상, 하, 좌, 우
    private static int[] ry = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    private static int[][] vector = {
            // 0,1후진 2,3전진
            {1, 0, -1, 0}, // 북
            {0, -1, 0, 1}, // 동
            {-1, 0, 1, 0}, // 남
            {0, 1, 0, -1}  // 서
    };
    private static ArrayDeque<Node> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // r 헹
        M = Integer.parseInt(st.nextToken()); // c 열
        map = new int[N][M];

        // 현재 청소 시작 할 위치
        queue = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        queue.addLast(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

//        System.out.println();
//        System.out.println(queue);

        // 맵 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        printMap(map);

        bfs(queue.peekFirst().r, queue.peekFirst().c, queue.peekFirst().direction);

        System.out.println(answer);
    }
    private static void bfs(int y, int x, int dir) {
        // 현재 노드부터 시작
        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();
            // 현재 칸이 아직 청소되지 않은 경우
            if (map[now.r][now.c] == 0) {
                map[now.r][now.c] = 2;
                answer++;
            }

            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nr = now.r + ry[i];
                int nc = now.c + rx[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }
                if (map[nr][nc] == 1 || map[nr][nc] == 2) {
                    continue;
                }
                // 현재 칸의 주변 4칸 중 벽이 아니고, 청소되지 않은 빈 칸이 있는 경우
                cnt++;
            }

            // 다음 노드 생각하기
            Node next = new Node(now.r, now.c, now.direction);

            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (cnt == 0) {
                // 벽이 아닌 경우 후진, 벽일 경우 종료
                next.r = now.r + vector[now.direction][0];
                next.c = now.c + vector[now.direction][1];
                if (map[next.r][next.c] == 1) {
                    return;
                } else {
                    queue.addLast(next);
                }
            }
            // 청소되지 않은 빈 칸이 있는 경우
            else {
                // 일단 90도 회전
                for (int i = 0; i < 4; i++) {
                    now.direction -= 1;
                    if (now.direction == -1) {
                        now.direction = 3;
                    }

                    next.r = now.r + vector[now.direction][2];
                    next.c = now.c + vector[now.direction][3];
                    next.direction = now.direction;

                    if (map[next.r][next.c] == 0) {
                        queue.addLast(next);
                        break;
                    } else {
                        continue;
                    }
                }

            }
        }

    }

    private static void printMap(int[][] currMap) {
        System.out.println("#########################");
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
}
