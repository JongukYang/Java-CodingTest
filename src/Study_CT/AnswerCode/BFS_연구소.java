package Study_CT.AnswerCode;

import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
// bfs
public class BFS_연구소 {
    // 상 하 좌 우 탐색을 위한 [ + - ] 값
    private static final int[] rx = {0, 0, -1, 1};
    private static final int[] ry = {-1, 1, 0, 0};

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int[][] map; // 맵
    private static int N, M; // 세로, 가로
    private static ArrayDeque<Node> virus = new ArrayDeque<>(); // 바이러스 위치 담을 전역변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로 rows
        M = Integer.parseInt(st.nextToken()); // 가로 cols

        // 맵 입력 && 독 위치 virus 큐에 저장
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 바이러스 위치 찾아서 virus 큐에 넣기
                if (map[i][j] == 2) {
                    virus.addLast(new Node(i, j));
                }
            }
        }

        ArrayDeque<Node> block = new ArrayDeque<>();
        int answer = 0; // 안전 영역 크기의 최댓값 저장 변수

        // 첫 번째 벽
        for (int i = 0; i < N * M - 2; i++) {
            if (map[i / M][i % M] != 0) continue; // 벽을 세울 수 없는 케이스
            block.addLast(new Node(i / M, i % M)); // block 큐에 첫 번째 벽 좌표 삽입
            // 두 번째 벽
            for (int j = i + 1; j < N * M - 1; j++) {
                if (map[j / M][j % M] != 0) continue; // 벽을 세울 수 없는 케이스
                block.addLast(new Node(j / M, j % M)); // block 큐에 두 번째 벽 좌표 삽입
                // 세 번째 벽
                for (int k = j + 1; k < N * M; k++) {
                    if (map[k / M][k % M] != 0) continue; // 벽을 세울 수 없는 케이스
                    block.addLast(new Node(k / M, k % M)); // block 큐에 세 번째 벽 좌표 삽입
                    // BFS
                    answer = Math.max(answer, bfs(block)); // 최대 안전구역(0) 구하기
                    block.pollLast(); // 세 번째 블록을 세웠던 곳은 빼기
                }
                block.pollLast(); // 두 번째 블록을 세웠던 곳은 빼기
            }
            block.pollLast(); // 첫 번째 블록을 세웠던 곳은 빼기
        }
        System.out.println(answer);
    }

    // 독성 물질이 퍼지지 않은 구역(0)의 개수를 리턴해줌
    private static int bfs(ArrayDeque<Node> block) { // 독의 시작 위치, 벽
        int[][] bfsMap = new int[N][M]; // bfs를 하며 바뀌는 맵

        // 기존 맵 복사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bfsMap[i][j] = map[i][j]; // 원본 맵 복사
            }
        }

        // 벽 3개 세우기 -> 1로 채우기
        for (Node node : block) {
            // 원본 맵을 변하게 하면 안되니 bfsMap에 세우기
            bfsMap[node.r][node.c] = 1;
        }

        // 독이 있는 곳 부터 BFS 탐색을 위한 큐 생성 및 삽입
        ArrayDeque<Node> queue = new ArrayDeque<>();
        for (Node node : virus) {
            queue.addLast(node);
        }

        // 방문체크 하지 않음

        // 상하좌우 BFS 탐색 시작
        while (!queue.isEmpty()) {
            Node now = queue.pollFirst(); // 독의 현재 위치(r, c), 방문하는 정점
            // 상 하 좌 우 탐색
            for (int i = 0; i < 4; i++) {
                int next_r = now.r + ry[i];
                int next_c = now.c + rx[i];

                // 맵 밖으로 나가는 경우
                if (next_r < 0 || next_c < 0 || next_r >= N || next_c >= M) {
                    continue;
                }
                // 벽인 경우
                if (bfsMap[next_r][next_c] == 1) {
                    continue;
                }
                // 바이러스에 감염시킴
                if (bfsMap[next_r][next_c] == 0) {
                    bfsMap[next_r][next_c] = 2;
                    queue.addLast(new Node(next_r, next_c));
                }
            }
        }

        // 아직까지 남아있는 0의 개수 세야함
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (bfsMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
