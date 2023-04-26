package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS_단지번호붙이기 {
    // 백준 실버 1
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] rx = {0, 0, -1, 1};
    private static int[] ry = {-1, 1, 0, 0};

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
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = c[j] - '0';
            }
        }

        // 원본 map 출력해보기
        printMap();

        // bfs 구현
        ArrayList<Integer> arrayList = new ArrayList<>(); // 단지 카운트
        int houseNum = 0;
        for (int i = 0; i < N; i++) {
            ArrayDeque<Node> queue = new ArrayDeque<>();

            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int houseCount = 0;

                    queue.addLast(new Node(i, j));
                    visited[i][j] = true;
                    houseNum++;
                    houseCount++;
                    map[i][j] = houseNum;

                    while (!queue.isEmpty()) {
                        Node now = queue.pollFirst(); // 현재 노드

                        // 상하좌우 탐색
                        for (int k = 0; k < 4; k++) {
                            // 다음 노드
                            int nr = now.r + ry[k];
                            int nc = now.c + rx[k];

                            // 예외처리
                            if (nr < 0 || nc < 0 || nr >= N || nc >= N) { // 맵 밖으로 나가는 경우
                                continue;
                            }
                            if (map[nr][nc] == 0) {
                                continue;
                            }
                            if (map[nr][nc] == 1 && !visited[nr][nc]) {
                                visited[nr][nc] = true;
                                queue.addLast(new Node(nr, nc));
                                houseCount++;
                                map[nr][nc] = houseNum;
                            }
                        }
                    }
                    arrayList.add(houseCount);
                }
            }
        }

        System.out.println("#####################");
        printMap();
        System.out.println("#####################");
        System.out.println(arrayList);
        System.out.println("houseNum : " + houseNum);
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

    }

    private static void printMap() {
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
}
