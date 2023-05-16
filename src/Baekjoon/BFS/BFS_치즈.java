package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BFS_치즈 {
    // 백준 골드 3
    private static int N, M;
    private static int ANSWER, cheeseCnt;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] rx = {0, 0, -1, 1};
    private static int[] ry = {1, -1, 0, 0};
    private static ArrayDeque<Node> airQueue;
    private static ArrayDeque<Node> cheeseQueue;
    private static ArrayList<Node> disappearCheeseList;

    private static class Node {
        int r, c;
        int status;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Node(int r, int c, int status) {
            this.r = r;
            this.c = c;
            this.status = status;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 4
        M = Integer.parseInt(st.nextToken()); // 3
        map = new int[N][M]; // [4 , 3]
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeseCnt++;
                }
            }
        }
        System.out.println("원본 맵");
        printMap();

        while (cheeseCnt > 0) {
            // 바깥 공기 부분을 2로 초기화
            visited = new boolean[N][M];
            setAir(0, 0);

            System.out.println("cheeseCnt :" + cheeseCnt + " 2로 초기화");
            printMap();

            // 사라질 치즈 저장할 배열
            disappearCheeseList = new ArrayList<>();

            // 치즈 부분 탐색 -> 외부 공기와 2면 이상 닿는 것은 다음 수행때 삭제됨.
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        // 사라질 치즈 탐색
                        setCheese(i, j);
                    }
                }
            }

            ANSWER++;
            System.out.println("ANSWER :" + ANSWER + " bfs수행 완료");

            // 외부 공기 맛본 치즈는 외부공기 2로 초기화
            for (int k = 0; k < disappearCheeseList.size(); k++) {
                Node cheese = disappearCheeseList.get(k);
                map[cheese.r][cheese.c] = 2;
                cheeseCnt--;
            }

            System.out.println("cheeseCnt :" + cheeseCnt + " 치즈 삭제 후 맵");
            printMap();

        }
        System.out.println(ANSWER);
    }

    private static void setCheese(int r, int c) {
        visited[r][c] = true;

        // status 0 = 안사라짐, 1 = 사라짐
        cheeseQueue = new ArrayDeque<>();
        cheeseQueue.addLast(new Node(r, c, 0));

        while (!cheeseQueue.isEmpty()) {
            Node now = cheeseQueue.pollFirst();
            int outerAirCnt = 0;
            int innerAirCnt = 0;
            for (int i = 0; i < 4; i++) {
                int nr = now.r + ry[i];
                int nc = now.c + rx[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }
                if (map[nr][nc] == 2) { // 외부공기 맛보는 치즈
                    outerAirCnt++;
                    continue;
                }
                if (map[nr][nc] == 0) { // 내부공기 맛보는 치즈
                    innerAirCnt++;
                    continue;
                }
                if (map[nr][nc] == 1) { // 그냥 치즈일 때 다음거
                    visited[nr][nc] = true;
                    cheeseQueue.addLast(new Node(nr, nc));
                }
            }
            // 4 방면 확인 후 현재 치즈의 상태를 케이스에 따라 분리
            // 1. 2면 이상이 외부 공기 접촉일 경우 -> 사라짐
            if (outerAirCnt >= 2) {
                disappearCheeseList.add(now);
            }
            // 2. 1면 이하로 외부 공기 접촉일 경우 -> 안사라짐
            else if (outerAirCnt <= 1 && innerAirCnt == 0) {
                continue;
            }
            // 3. 1면은 외부, 1면은 내부 공기 접촉일 경우 -> 안사라짐
            else if (outerAirCnt <= 1 && innerAirCnt >= 1) {
                continue;
            }
            // 4. 2면 이상 내부 공기 접촉일 경우 -> 안사라짐
            else if (outerAirCnt == 0 && innerAirCnt >= 0) {
                continue;
            }
        }
    }

    private static void setAir(int r, int c) {
        visited[r][c] = true;
        map[r][c] = 2;

        airQueue = new ArrayDeque<>();
        airQueue.addLast(new Node(r, c));

        while (!airQueue.isEmpty()) {
            Node now = airQueue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + ry[i];
                int nc = now.c + rx[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }
                if (map[nr][nc] == 1) {
                    continue;
                }
                // 외부공기 초기화된 2일 경우
                if (map[nr][nc] == 2) {
                    visited[nr][nc] = true;
                    map[nr][nc] = 2;
                    airQueue.addLast(new Node(nr, nc));
                }
                // 외부공기가 아닌 경우
                else if (map[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    map[nr][nc] = 2;
                    airQueue.addLast(new Node(nr, nc));
                }
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
}
