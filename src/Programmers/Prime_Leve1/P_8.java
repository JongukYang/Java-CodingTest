package Programmers.Prime_Leve1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//문자열 내림차순으로 배치하기
//문제 설명
//문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
//s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
//
//제한 사항
//str은 길이 1 이상인 문자열입니다.
public class P_8 {
    public String solution(String s) {
        String answer = "";
        char[] charArr = s.toCharArray(); // 배열로 만들어서 정렬하기 위해
//        System.out.println(charArr);
        Arrays.sort(charArr);

        StringBuilder sb = new StringBuilder(new String(charArr));
        sb.reverse();
        answer = sb.toString();
        //
        return answer;
    }

    public static void main(String[] args) {
        P_8 sol = new P_8();
        String s = "Zbcdefg";
        System.out.println(sol.solution(s));
    }
}
