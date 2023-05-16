package Baekjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS_양구출작전 {
    // 백준 골드3
    private static int N;
    private static long answer;
    private static ArrayList<Node> nodes;
    private static boolean[] visited;

    private static class Node {
        int div; // 양 1 vs 늑대 2
        long wolf, sheep; // 양, 늑대 수
        int idx, conn; // 노드 인덱스, 연결된 노드
        public Node(int div, long wolf, long sheep, int idx, int conn) {
            this.div = div;
            this.wolf = wolf;
            this.sheep = sheep;
            this.idx = idx;
            this.conn = conn;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        nodes = new ArrayList<>();
        nodes.add(new Node(0, 0, 0, 0, 0)); // 0
        nodes.add(new Node(0, 0, 0, 1, 0)); // 1

        for (int i = 2; i <= N; i++) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("S")) {
                nodes.add(new Node(1, 0, Long.parseLong(s[1]), i, Integer.parseInt(s[2])));
            } else {
                nodes.add(new Node(2, Long.parseLong(s[1]), 0, i, Integer.parseInt(s[2])));
            }
        }

        visited = new boolean[N + 1];
        visited[0] = true;

        for (int i = N; i >= 2; i--) {
            // 방문하지 않은 양이 있는 곳일 때 수행
            if (!visited[i] && nodes.get(i).div == 1) {
                System.out.println("포문에서 시작 node[i]" + i);
                dfs(nodes.get(i), 0);
                System.out.println("answer : " + answer);
            }
        }
        System.out.println(answer);
    }

    private static void dfs(Node now, long savedSheep) {
        System.out.println("현재 노드 : " + now.idx);
        if (now.conn == 0) {
            return;
        }
        // 1번 노드에 도착하면 구한 양들 저장하고 리턴
        if (now.idx == 1) {
            answer += savedSheep;
            return;
        }

        // 현재 노드가 양이라면
        if (now.div == 1 ) {
            // 방문하지 않았다면
            if (!visited[now.idx]) {
                visited[now.idx] = true;
                savedSheep += now.sheep;
            }
            dfs(nodes.get(now.conn), savedSheep);
            return;
        }
        // 현재 노드가 늑대라면
        else if (now.div == 2) {
            // 현재 늑대가 구한 양보다 같거나 많다면
            if (now.wolf >= savedSheep) {
                now.wolf -= savedSheep;
                savedSheep = 0;
            }
            // 늑대가 현재 양보다 적다면
            else {
                savedSheep -= now.wolf;
                now.wolf = 0;
            }
            dfs(nodes.get(now.conn), savedSheep);
            return;
        }

    }

}
