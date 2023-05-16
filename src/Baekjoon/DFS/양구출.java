package Baekjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양구출 {
    // 백준 골드3
    private static int N;
    private static long answer;
    private static Node[] nodes;
    private static boolean[] visited;

    private static class Node {
        long wolf, sheep;
        int idx, conn;

        public Node(long wolf, long sheep, int idx, int conn) {
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
        visited = new boolean[N + 1];
        visited[0] = true;

        nodes = new Node[N + 1];
        for (int i = 0; i <= N; i++) {
            nodes[i] = new Node(0, 0, 0, 0);
        }

        nodes[1] = new Node(0, 0, 1, 0);

        for (int i = 2; i <= N; i++) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("S")) {
                nodes[i].sheep = Integer.parseInt(s[1]);
                nodes[i].wolf = 0;
            } else {
                nodes[i].wolf = Integer.parseInt(s[1]);
                nodes[i].sheep = 0;
            }
            nodes[i].idx = i;
            nodes[i].conn = Integer.parseInt(s[2]);
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(nodes[i].idx + " " + nodes[i].conn + " " + nodes[i].wolf + " " + nodes[i].sheep);
        }

        for (int i = N; i >= 2; i--) {
            if (nodes[i].sheep > 0) {
                System.out.printf("포문에서 시작 node[%d]\n", i);
                dfs(nodes[i], 0, 0);
                System.out.println(answer);
            }
        }
        System.out.println(answer);
    }

    private static void dfs(Node now, int savedSheep, int nodeIdx) {
        // 위 포문에서는 양일때만 dfs 수행 시작
        System.out.println("현재 노드 : " + now.idx);
        if (nodeIdx == 1) {
            answer += savedSheep;
            return;
        }
        // 양이라면
        if (now.sheep > 0) {
            savedSheep += now.sheep;
            dfs(nodes[now.conn], savedSheep, now.conn);
        }
        // 늑대라면
        if (now.wolf > 0) {
            if (savedSheep >= now.wolf) {
                savedSheep -= now.wolf;
                dfs(nodes[now.conn], savedSheep, now.conn);
            } else {
                savedSheep = 0;
                dfs(nodes[now.conn], savedSheep, now.conn);
            }
        }
    }

}
