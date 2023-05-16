package Baekjoon.완전탐색_백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class 완전탐색_블랙잭 {
    private static int N,M,MAX_SUM;
    private static int[] CARDS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 필드에 있는 카드의 수
        M = Integer.parseInt(st.nextToken()); // 카드의 합은 M을 넘을 수 없다.
        CARDS = new int[N]; // CARDS : 팔드에 있는 N개의 카드 목록
        MAX_SUM = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            CARDS[i] = Integer.parseInt(st.nextToken());
        }

        // 3장의 카드를 뽑아서 M을 넘지 않도록 하는 카드 숫자 합의 최대값을 구하기
        int result = getMaxSum();

        System.out.println(result);
    }

    private static int getMaxSum() {
        int sum = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i+1; j < N - 1; j++) {
                for (int k = j+1; k < N; k++) {
                    sum = CARDS[i] + CARDS[j] + CARDS[k];
                    if (sum > M) {
                        continue;
                    } else if (sum == M) {
                        return sum;
                    } else {
                        MAX_SUM = Math.max(MAX_SUM, sum);
                    }
                }
            }
        }
        return MAX_SUM;
    }
}
