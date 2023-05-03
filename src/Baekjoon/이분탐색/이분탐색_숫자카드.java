package Baekjoon.이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이분탐색_숫자카드 {
    // 백준 실버5
    private static int[] myCards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        myCards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            myCards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(myCards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            if (binarySearch(Integer.parseInt(st.nextToken()))) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }

        bw.flush();
        bw.close();
    }

    private static boolean binarySearch(int num) {
        int leftIdx = 0;
        int rightIdx = myCards.length - 1;

        while (leftIdx <= rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;
            if (num < myCards[midIdx]) {
                rightIdx = midIdx - 1;
            } else if (num > myCards[midIdx]) {
                leftIdx = midIdx + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
