package Study_CT;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[N];
        for(int i = A.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekLast() <= A[i]) {
                stack.pollLast();
            }
            stack.addLast(A[i]);
            answer[i] = stack.isEmpty() ? -1 : stack.peekLast();
        }

        for (int i : answer) {
            bw.write(i + " ");
        }
        bw.flush();
    }
}
