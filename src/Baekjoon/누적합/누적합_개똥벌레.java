package Baekjoon.누적합;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 누적합_개똥벌레 {
    // 백준 골드5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 길이 = 석순 + 종유석 개수
        int H = Integer.parseInt(st.nextToken()); // 높이 = H개의 층
        int[] bottom = new int[H + 2]; // 석순
        int[] top = new int[H + 2]; // 종유석

        // 석순 , 종유석 순서대로 삽입
        for (int i = 1; i <= N / 2; i++) {
            bottom[Integer.parseInt(br.readLine())]++; // 석순
            top[H - Integer.parseInt(br.readLine()) + 1]++; // 종유석 = 높이 - 종유석 길이 + 1
        }

        System.out.println(Arrays.toString(bottom));
        System.out.println(Arrays.toString(top));
        System.out.println("#############################");

        // 석순, 종유석 누적합 계산
        for (int i = 1; i <= H; i++) {
            bottom[i] += bottom[i - 1];

        }
        for (int i = H; i >= 1; i--) {
            top[i] += top[i + 1];
        }
        System.out.println(Arrays.toString(bottom));
        System.out.println(Arrays.toString(top));
        System.out.println("#############################");

        // 정답 구하기
        int minCruch = Integer.MAX_VALUE;
        int minfloorCnt = 0;

        for (int i = 1; i <= H; i++) {
            // 1층부터 H층까지 반복하며 석순 + 종유석 개수 카운트
            int calcCruch = (bottom[H] - bottom[i - 1]) + (top[1] - top[i + 1]);
            if (minCruch > calcCruch) {
                minCruch = calcCruch;
                minfloorCnt = 1;
            } else if (calcCruch == minCruch) {
                minfloorCnt++;
            }
        }
        bw.write(minCruch + " " + minfloorCnt);
        bw.flush();
        br.close();
        bw.close();
    }

}
