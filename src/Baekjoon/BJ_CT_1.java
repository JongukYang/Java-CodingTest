package Baekjoon;

import java.util.Scanner;

public class BJ_CT_1 {
    public int plus(int A, int B) {
        return A+B;
    }
    public static void main(String[] args) {
        BJ_CT_1 sol = new BJ_CT_1();
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(sol.plus(A,B));
    }
}
