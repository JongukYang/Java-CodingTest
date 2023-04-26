package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BFS_연구소 {
    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int[] rx = {1, -1, 0, 0};
    private static int[] ry = {0, 0, 1, -1};
    private static int N, M, ANSWER;
    private static int[][] MAP;
    private static boolean[][] visited;
    private static ArrayList<Node> virusList;
    private static ArrayDeque<Node> blockQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MAP = new int[N][M]; // 원본 배열
        virusList = new ArrayList<>(); // 바이러스의 위치를 저장하는 리스트

        // 0:안전영역, 1:벽, 2:바이러스
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
                if (MAP[i][j] == 2) {
                    virusList.add(new Node(i, j));
                }
            }
        }

        printMAP(MAP);

        blockQueue = new ArrayDeque<>(); // 3개 세운 벽을 저장하는 큐

        // 벽을 꼭 3개 세워야 함. 따라서 벽을 세운 위치마다 모두 BFS 수행하고 안전영역의 쵀대값 찾기
        for (int i = 0; i < N * M - 2; i++) {
            // 빈칸에만 벽을 세워야 함
            if (MAP[i / M][i % M] != 0) {
                continue;
            }
            blockQueue.addLast(new Node(i / M, i % M)); // 첫 번째 벽
            for (int j = i + 1; j < N * M - 1; j++) {
                if (MAP[j / M][j % M] != 0) {
                    continue;
                }
                blockQueue.addLast(new Node(j / M, j % M)); // 두 번째 벽
                for (int k = j + 1; k < N * M; k++) {
                    if (MAP[k / M][k % M] != 0) {
                        continue;
                    }
                    blockQueue.addLast(new Node(k / M, k % M)); // 세 번째 벽

                    // 안전영역 BFS 탐색 시작
                    ANSWER = Math.max(ANSWER, bfs());

                    // 벽 제거
                    blockQueue.pollLast(); // 세 번째 벽 세웠던거 제거
                }
                blockQueue.pollLast(); // 두 번째 벽 세웠던거 제거
            }
            blockQueue.pollLast(); // 첫 번째 벽 세웠던거 제거
        }

        // 정답 출력
        System.out.println(ANSWER);
    }

    private static int bfs() {
        visited = new boolean[N][M]; // 방문했는지 여부 체크용
        int[][] copyMap = new int[N][M]; // 원본 배열 유지를 위해 변하는 배열 생성
        // 깊은 복사(Deep Copy) : 새로운 메모리 할당
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = MAP[i][j];
            }
        }
        // 큐에 저장한 블록 세우기
        for (Node node : blockQueue) {
            copyMap[node.r][node.c] = 1;
        }
        // 바이러스 위치 가지고 bfs 돌리기
        ArrayDeque<Node> virusQueue = new ArrayDeque<>();
        for (Node node : virusList) {
            virusQueue.addLast(node);
        }
        // bfs 수행부분
        while (!virusQueue.isEmpty()) {
            Node now = virusQueue.pollFirst(); // 현재 바이러스의 위치
            // 상하좌우 탐색
            for (int j = 0; j < 4; j++) {
                // 다음 노드 위치
                int nr = now.r + ry[j];
                int nc = now.c + rx[j];
                // 예외처리
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue; // 맵 밖으로 나가는 경우
                }
                if (copyMap[nr][nc] == 1) {
                    continue; // 벽인 경우
                }
                if (visited[nr][nc]) {
                    continue;
                }
                // 벽이 아닌 경우 감염시키기
                if (copyMap[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    copyMap[nr][nc] = 2;
                    virusQueue.addLast(new Node(nr, nc));
                }
            }
        }

        // 현재 남은 0(안전영역)의 개수 세기
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        return safeArea;
    }

    private static void printMAP(int[][] currMAP) {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(currMAP[i]));
        }
    }
}
