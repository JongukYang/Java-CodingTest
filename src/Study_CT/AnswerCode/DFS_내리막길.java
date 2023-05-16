package Study_CT.AnswerCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 내리막길 - DFS - 백준 골드3
public class DFS_내리막길 {

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    private static int[] rx = {0, 0, -1, 1};
    private static int[] ry = {-1, 1, 0, 0};
    private static int[][] map; // 입력받은 map
    private static int[][] cnt; // 결과를 저장할 배열
    private static int M,N; // 세로 가로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로

        map = new int[M][N];
        cnt = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // cnt 배열은 방문 후 다음 정점에 갈 수 없다면 무한루프 발생. 따라서 방문체크를 위해 -1로 설정해주기
                cnt[i][j] = -1;
            }
        }

        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        // 마지막 정점(지점)에 초기 값이 1 가지가 있다고 저장해 줘야지 DFS 하는 동안 무한루프가 안돔
        // 마지막 좌표에 최초 값을 지정해 줘야 함
        cnt[M-1][N-1] = 1;

        // DFS 탐색 시작
        dfs(new Node(0, 0));

        // 정답
        System.out.println(cnt[0][0]);

    }

    private static int dfs(Node now) {
        // 방문 체크
        if (cnt[now.r][now.c] > -1) {
            return cnt[now.r][now.c];
        }
        // 방문체크 -> 무한루프 제거
        cnt[now.r][now.c] = 0;

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            // 다음 방문 노드 찾기
            int next_r = now.r + ry[i];
            int next_c = now.c + rx[i];
            System.out.println("#################################");

            // 예외 찾기
            // 맵 밖으로 나가는 경우 -> 맨 먼저 해야함. 안하면 인덱스 에러 (out of index)
            if (next_r < 0 || next_c < 0 || next_r >= M || next_c >= N) {
                continue;
            }

            // 다음 노드의 숫자가 더 작은 경우(내리막일 경우)
            if (map[now.r][now.c] > map[next_r][next_c]) {
                cnt[now.r][now.c] += dfs(new Node(next_r, next_c));
                // cnt[now.r][now.c] = cnt[0][0]
                // map[0][0] = 50 => 1
                System.out.println(map[now.r][now.c] + " " + cnt[now.r][now.c]);
                if (map[now.r][now.c] == 50) {
                    System.out.println("#################################");
                }
            }
        }
        return cnt[now.r][now.c];
    }

}
