package Programmers.Level_1;

import java.util.Arrays;
import java.util.Collections;

public class Pro_CT_59 {
//  과일장수
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Integer[] scores = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scores, Collections.reverseOrder());

        for(int i = 0; i<scores.length; i++) {
            if((i+1)%m == 0 ) {
                answer += scores[i]*m;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Pro_CT_59 sol = new Pro_CT_59();
        int k = 4; // 최상 k, 최하 1
        int m = 3; // 사과 m개씩 담음
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}; // m개를 골라서 가장 얻을 수 있는 최대의 이익 계산
        System.out.println(sol.solution(k, m , score)); // p(사과의 가장 낮은 점수) * m = 8
    }
}
