package SWEA.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 뱀 {
    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int[] ry = {0, 1, 0, -1}; // 행 동 남 서 북
    private static int[] rx = {1, 0, -1, 0}; // 열
    private static int N, K, L;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Map 생성
        N = Integer.parseInt(st.nextToken()); // 맵의 크기
        map = new int[N + 1][N + 1]; // 0 빈칸, 1 몸통, 2 머리, 3 사과
        map[1][1] = 2;

        // 사과 위치 표시
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken()); // 사과의 개수
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 3;
        }

        // 출력 (map, 방향)
        printMap(map);

        int time = 0; // 게임 진행 총 시간

        // 방향전환을 위한 (초, 방향) 입력
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken()); // 방향전환 횟수

        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int turnTime = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            hashMap.put(turnTime, direction);
        }

        int spinIdx = 0;
        ArrayDeque<Node> snakeQueue = new ArrayDeque<>(); // 머리 다음 좌표 저장
        ArrayDeque<Node> queue = new ArrayDeque<>(); // 다음 칸으로
        snakeQueue.addLast(new Node(1, 1));
        queue.addLast(new Node(1, 1));

        // 구현
        while (!queue.isEmpty()) {
            System.out.println("while 반복중");
            time++; // 시간 증가

            Node now = queue.pollFirst();
            int nr = now.r + ry[spinIdx];
            int nc = now.c + rx[spinIdx];

            // 예외처리
            if (nr < 1 || nc < 1 || nr > N || nc > N) {
                // 맵 밖으로 나가는 경우
                break;
            }
            if (map[nr][nc] == 2) {
                // 몸통과 만날 경우
                break;
            }

            if (map[nr][nc] == 3) {
                System.out.println("사과요");
                // 사과를 만날 경우
                map[nr][nc] = 2;
                map[now.r][now.c] = 2;
                queue.addLast(new Node(nr, nc));
                snakeQueue.addLast(new Node(nr, nc));
            } else {
                System.out.println("그냥가여");
                // 맵[nr][nc] 0이면 진행 방향으로 전진
                map[nr][nc] = 2;
                queue.addLast(new Node(nr, nc));
                snakeQueue.addLast(new Node(nr, nc));
                Node snake = snakeQueue.pollFirst();
                map[snake.r][snake.c] = 0;
            }
            System.out.println("time = " + time);
            printMap(map);

            if (hashMap.containsKey(time)) {
                if (hashMap.get(time).equals("D")) {
                    // 오른쪽으로
                    System.out.println("time:" + time + " 오른쪽으로 전환");
                    spinIdx += 1;
                    if (spinIdx == 4) {
                        spinIdx = 0;
                    }
                }
                else {
                    // 왼쪽으로
                    System.out.println("time:" + time + " 왼쪽으로 전환");
                    spinIdx -= 1;
                    if (spinIdx == -1) {
                        spinIdx = 3;
                    }
                }
            }
        }

        System.out.println(time);
    }

    private static void printMap(int[][] currMap) {
//        System.out.println("########################");
        for (int i = 0; i <= N; i++) {
            System.out.println(Arrays.toString(currMap[i]));
        }
        System.out.println("########################");
    }
}
