package Baekjoon.완전탐색_백트래킹;

import java.io.*;

public class 완전탐색_좋은수열 {
    //    백준 골드4
    // 길이가 N인 수열을 N자리의 정수로 모아
    // 그중 가장 작은 수를 나타내는 수열을 구하기
    // 수열은 1, 2, 3으로만 이루어져 있음
    // 같은 수가 반복되면 안됨
    private static int N; // 수열의 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        backtrack("");
    }
    private static void backtrack(String result) {
        if (result.length() == N) {
            System.out.println(result);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            if (checkSequence(result + i)) {
                backtrack(result + i);
            }
        }
    }
    private static boolean checkSequence(String s) {
        // 수열의 길이를 확인한 후 최대 앞의 3자리까지 동일하게 나왔는지만 체크
        // 11, 1212, 123123 같은 형식은 불가
        System.out.println("현재 문자열 s : " +s);
        for (int i = 1; i <= s.length() / 2; i++) {
            String front = s.substring(s.length() - i * 2, s.length() - i);
            String back = s.substring(s.length() - i, s.length());
            System.out.println("front: " + front + " back: " + back);
            if (front.equals(back)) {
                return false;
            }
        }
        return true;
    }
}


