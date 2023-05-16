package Baekjoon.완전탐색_백트래킹;
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class 완전탐색_스타트와링크 {
    private static int N; // 모인 사람 (무조건 짝수)
    private static int[][] map;
    private static boolean[] used;
    private static int Minimum = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        used = new boolean[N];

        // cols = i, rows = j, S(ij)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        // N / 2 만큼의 인원수로 2팀을 만들고,
        // 두 팀의 능력치 값을 빼고 절대값을 구해서 0에 가깝게 하기

        backtrack(0, 0);

        System.out.println(Minimum);
    }

    private static void backtrack(int idx, int count) {
        if (count == N / 2) {
            getTeam();
            return;
        }
        for (int i = idx; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                backtrack(i + 1, count + 1);
                used[i] = false;
            }
        }
    }

    private static void getTeam() {
        int team_start_status = 0;
        int team_link_status = 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (used[i] && used[j]) {
                    team_start_status += map[i][j];
                    team_start_status += map[j][i];
                }
                else if (!used[i] && !used[j]) {
                    team_link_status += map[i][j];
                    team_link_status += map[j][i];
                }
            }
        }

        Minimum = Math.min(Minimum, Math.abs(team_start_status - team_link_status));
    }
}
