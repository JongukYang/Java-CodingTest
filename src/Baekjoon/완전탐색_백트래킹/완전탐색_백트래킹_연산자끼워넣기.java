package Baekjoon.완전탐색_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 완전탐색_백트래킹_연산자끼워넣기 {
    // 백준 실버 1 연산자 끼워넣기

    private static int N;
    private static int[] A;
    private static int[] operators = new int[4]; // 연산자
    private static int MaxResult = Integer.MIN_VALUE;
    private static int MinResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 배열 원소의 개수
        A = new int[N];

        // N개의 원소를 가진 A배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 개수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken()); // 연산자 개수 배열
        }

        backtrack(A[0],1); // idx 가 1인 이유는 다음 연산을 할 다음 인덱스를 전달하기 떄문

        System.out.println(MaxResult);
        System.out.println(MinResult);
    }

    private static void backtrack(int num, int idx) {
        if (idx == N) {
            // 인덱스가 N이 되면 모든 연산자를 사이에 넣었다는 뜻
            MaxResult = Math.max(MaxResult, num);
            MinResult = Math.min(MinResult, num);
            return;
        }

        // +, -, *, / 네 가지 경우 돌리기
        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 1개 이상일 경우
            if (operators[i] > 0) {
                // 해당하는 연산자 1 감소
                operators[i]--;

                // 연산자의 경우에 따라서 케이스마다 backtrack 수행
                switch (i) {
                    case 0: backtrack(num + A[idx], idx + 1); break;
                    case 1: backtrack(num - A[idx], idx + 1); break;
                    case 2: backtrack(num * A[idx], idx + 1); break;
                    case 3: backtrack(num / A[idx], idx + 1); break;
                }

                // 완전 탐색을 위해 연산이 끝난 후 감소한 연산자 ++
                operators[i]++;
            }
        }
    }
}
