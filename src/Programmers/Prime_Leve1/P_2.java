package Programmers.Prime_Leve1;

import java.util.Arrays;

//자연수 뒤집어 배열로 만들기
//문제 설명
//자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
public class P_2 {
    public int[] solution(long n) {
        // 풀이 1
        String str = String.valueOf(n);
        System.out.println("str:" + str);

        int[] answer = new int[str.length()];
        for (int i = str.length()-1; i >= 0; i--) {
            answer[str.length()-1-i] += str.charAt(i) - '0';
            System.out.println(Arrays.toString(answer));
        }

//        풀이 2
//        StringBuilder sb = new StringBuilder();
//        sb.append(n).reverse();
//        int[] answer = new int[sb.length()];
//        for (int i = 0; i < sb.length(); i++) {
//            answer[i] += Integer.parseInt(sb.substring(i, i + 1));
//            System.out.println(Arrays.toString(answer));
//        }

        return answer;
    }

    public static void main(String[] args) {
        P_2 sol = new P_2();
        System.out.println(sol.solution(12345));
    }
}

// String.valueOf()와 Object.toString()의 차이
// 두 메서드의 차이는 크게 두 가지가 존재합니다.
// 첫 번째는 변환 가능 자료형의 종류 및 개수입니다.
// 두 번째는 NULL 값의 처리 여부에 따른 차이입니다.
// 보통 문자열로 형 변환 시 toString()을 자주 사용하는데,
// null값을 문자열로 형 변환 시 NullPointerException를 발생시킵니다.
// 그에 반해 String.valueOf()를 사용하면 전달받은 파라미터가 null이 전달될 경우 문자열 "null"을 반환합니다.
