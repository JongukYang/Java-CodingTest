package Baekjoon.DFS;

import Study_CT.AnswerCode.DFS_내리막길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class DFS_단지번호붙이기 {
    // 백준 실버1 DFS 단지번호붙이기
    private static int N;
    private static int aptCnt = 0, aptComplexNum = 0;
    private static int[][] map, visited, apart;
    private static int[] rx = {0, 0, -1, 1};
    private static int[] ry = {1, -1, 0, 0};

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new int[N][N];
        apart = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = c[j] - '0';
                visited[i][j] = -1;
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        // 시작 위치를 바꿔가며 dfs 수행
        // why? : 모든 아파트가 이어져 있지 않기 때문
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && visited[i][j] == -1) {
                    aptCnt = 0;
                    aptComplexNum++;
                    dfs(new Node(i, j));
                    System.out.println(aptCnt);
                    arrayList.add(aptCnt);
                }
            }
        }


        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(apart[i]));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arrayList.size() + "\n");
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i) + "\n");
        }

        System.out.println(sb.toString());
    }

    private static void dfs(Node now) {
        // 방문했었는지 체크
        if (visited[now.r][now.c] > -1) {
            return;
        }
        // 처음이라면 방문체크 -> 무한루프 제거
        visited[now.r][now.c] = 0;

        if (map[now.r][now.c] == 1) {
            apart[now.r][now.c] = aptComplexNum;
            aptCnt++;
        }

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            // 다음 방문 노드 찾기
            int next_r = now.r + ry[i];
            int next_c = now.c + rx[i];
            // 맵 밖으로 나가는 경우 -> 맨 먼저 해야함. 안하면 인덱스 에러 (out of index)
            if (next_r < 0 || next_c < 0 || next_r >= N || next_c >= N) {
                continue;
            }
            // dfs 재귀 : 현재 노드가 아파트인 좌표 + 다음 노드가 방문하지 않은 곳일 경우에 수행
            if (map[now.r][now.c] == 1 && visited[next_r][next_c] == -1) {
                dfs(new Node(next_r, next_c));
            }
        }
    }
}
