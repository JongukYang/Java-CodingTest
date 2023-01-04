package Programmers.Prime_Leve1;

import java.util.logging.Logger;

public class P_11 {
//    3진법 뒤집기
//문제 설명
//자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//n은 1 이상 100,000,000 이하인 자연수입니다.
//입출력 예
//n	result
//45	7
//125	229
    public int solution(int n) {
        int answer = 0;
        // 방법 1
//        String num = Integer.toString(n, 3);
//        StringBuilder sb = new StringBuilder(num).reverse();
//        answer = Integer.parseInt(sb.toString(), 3);

        // 방법 2
        

        return answer;
    }

    public static void main(String[] args) {
        P_11 sol = new P_11();
        int n = 45;
        System.out.println(sol.solution(n));
    }
}
