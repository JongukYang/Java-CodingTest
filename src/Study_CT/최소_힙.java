package Study_CT;

// 우선순위 큐
// Priority Queue
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class 최소_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        // O(NlogN)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n"); // O(logN)
                }
            }
            else {
                pq.add(x);
            }
        }

//        for (int item : arr) {
//            bw.write();
//        }

        bw.flush();
    }
}

