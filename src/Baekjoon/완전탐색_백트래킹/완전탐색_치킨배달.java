package Baekjoon.완전탐색_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 완전탐색_치킨배달 {
    // 백준 골드5 치킨배달
    // 빈 칸 0 / 일반집 1 / 치킨집 2 세가지 유형으로 이루어져 있음
    private static int N, M;
    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    private static int[][] map;
    private static int MinDistance = Integer.MAX_VALUE;
    private static ArrayList<Node> house;
    private static ArrayList<Node> chicken;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시의 크기 N*N
        M = Integer.parseInt(st.nextToken()); // 폐업시킬 치킨집 개수

        map = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    house.add(new Node(i, j));
                }
                else if (map[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        visited = new boolean[chicken.size()];

        backtrack(0, 0);
        System.out.println(MinDistance);
        br.close();
    }

    private static void backtrack(int cnt, int start) {
        if (cnt == M) {
            int total = 0;
            for (int i = 0; i < house.size(); i++) {
                int sum = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        int dist = Math.abs(house.get(i).c - chicken.get(j).c)
                                + Math.abs(house.get(i).r - chicken.get(j).r);
                        sum = Math.min(sum, dist);
                    }
                }
                total += sum;
            }
            MinDistance = Math.min(MinDistance, total);
            return;
        }
        // 백트래킹
        for (int i = start; i < chicken.size(); i++) {
                visited[i] = true;
                backtrack(cnt + 1, start + 1);
                visited[i] = false;
        }
    }
}
