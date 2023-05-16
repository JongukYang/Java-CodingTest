package Programmers.Level_2;

import java.util.ArrayDeque;

// 게임 맵 최단거리 - BFS - LV2
public class 게임_맵_최단거리_bfs {

    private static int[] rx = {0, 0, -1, 1};
    private static int[] ry = {-1, 1, 0, 0};

    class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] maps) {
        int N = maps.length; // rows
        int M = maps[0].length; // cols

        ArrayDeque<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int[][] dist = new int[N][M];

        // 초기 시작 위치
        queue.addLast(new Node(0, 0));
        visited[0][0] = true; // 첫 시작지점은 방문체크
        dist[0][0] = 1; // 시작지점부터 1씩 count 하므로 1로 설정

        while (!queue.isEmpty()) {
            // 현재 노드 찾기
            Node now = queue.pollFirst();

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                // 다음 위치 찾기
                int next_r = now.r + ry[i];
                int next_c = now.c + rx[i];

                // 예외 경우 찾기
                // 1. 맵 밖으로 나가는 경우
                if (next_r < 0 || next_c < 0 || next_r >= N || next_c >= M) {
                    continue;
                }
                // 2. 다음 벽이 막혀있는 경우
                if (maps[next_r][next_c] == 0) {
                    continue;
                }

                // 방문 처리 하기
                if (visited[next_r][next_c] == false) {
                    visited[next_r][next_c] = true;
                    dist[next_r][next_c] = dist[now.r][now.c] + 1;
                    queue.addLast(new Node(next_r, next_c));
                }
            }
        }

        // 내가 리턴 할 dist[N-1][M-1]의 값
        System.out.println(dist[N-1][M-1]);

        return dist[N-1][M-1] == 0 ? -1 : dist[N-1][M-1];
    }

    public static void main(String[] args) {
        게임_맵_최단거리_bfs p = new 게임_맵_최단거리_bfs();
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        System.out.println(p.solution(maps));
    }

}
