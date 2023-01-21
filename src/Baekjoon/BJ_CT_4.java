package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 오큰수
public class BJ_CT_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // A 수열 크기

        int[] A = new int[N]; // A 수열 [ 3, 5, 2, 7 ]

        // A 수열 초기값 입력
        st = new StringTokenizer(br.readLine()); // 3 5 2 7
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // stack에 A 배열의 index를 저장
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peekLast()] < A[i]) {
                A[stack.pollLast()] = A[i];
            }
            // 스택이 비었거나 A[stack.peek()]가 A[i]보다 작은 경우 stack에 push
            stack.addLast(i);
        }

        // 끝나고 스택에 남은 index에 해당하는 A배열의 값은 자신보다 큰 수가 없기 떄문에 -1로 초기화
        while (!stack.isEmpty()) {
            A[stack.pollLast()] = -1;
        }

        // 출력
        for(int i =0; i<A.length; i++) {
            bw.write(A[i] + " ");
        }
        bw.flush();
    }
}


// 첫 번째 풀이
//package Baekjoon;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.ArrayDeque;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//// 오큰수
//public class BJ_CT_4 {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken()); // A 수열 크기
//
//        int[] A = new int[N]; // A 수열 [ 3, 5, 2, 7 ]
//
//        // A 수열 초기값 입력
//        st = new StringTokenizer(br.readLine()); // 3 5 2 7
//        for(int i = 0; i < N; i++) {
//            A[i] = Integer.parseInt(st.nextToken());
//        }
//
//        // 오큰수 찾기
//        int[] res = new int[A.length];
//        for(int i = 0; i < A.length; i++) {
//            res[i] = findRightBiggerNum(i, A);
//            bw.write(res[i] + " ");
//        }
//        bw.flush();
//
//    }
//
//    private static int findRightBiggerNum(int idx, int[] A) {
//        // 가장 왼 쪽 찾기
//        for(int i = idx+1; i<A.length; i++) {
//            if (A[i] > A[idx]) {
//                return A[i];
//            }
//        }
//        return -1;
//    }
//}
