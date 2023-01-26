package Programmers.Level_2;

import java.util.Arrays;

public class PL2_10 {
    public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i<A.length; i++) {
            answer += A[i]*B[B.length- 1 - i];
        }

        return answer;
    }

    public static void main(String[] args) {
        PL2_10 p = new PL2_10();
        int[] A = {1, 2, 3};
        int[] B = {5, 6, 7};
        System.out.println(p.solution(A, B));
    }

}
