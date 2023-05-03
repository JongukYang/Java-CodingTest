package SWEA.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백트래킹_퇴사 {
    private static class Node {
        int day, time, pay;

        public Node() {

        }

        public Node(int day, int time, int pay) {
            this.day = day;
            this.time = time;
            this.pay = pay;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "day=" + day +
                    ", time=" + time +
                    ", pay=" + pay +
                    '}';
        }
    }

    private static ArrayList<Node> nodes;
    private static int N, maxPay = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        nodes = new ArrayList<>();
        nodes.add(new Node());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            nodes.add(new Node(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 1; i < nodes.size(); i++) {
            Node now = nodes.get(i);
            System.out.println(now.toString());
        }

        backtrack(1, 0, 0);
        System.out.println(maxPay);

    }

    private static void backtrack(int start, int sum, int pastPay) {
        if ((start == N + 1)) {
            maxPay = Math.max(maxPay, sum);
            return;
        } else if (start > N + 1) {
            sum -= pastPay;
            maxPay = Math.max(maxPay, sum);
            return;
        }

        for (int i = start; i <= N; i++) {
            backtrack(i + nodes.get(i).time, sum + nodes.get(i).pay, nodes.get(i).pay);
        }
    }

}
