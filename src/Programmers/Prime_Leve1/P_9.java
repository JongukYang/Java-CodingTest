package Programmers.Prime_Leve1;
// 문자열 다루기 기본
//문제 설명
//문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
//
//제한 사항
//s는 길이 1 이상, 길이 8 이하인 문자열입니다.
//s는 영문 알파벳 대소문자 또는 0부터 9까지 숫자로 이루어져 있습니다.
//입출력 예
//s	return
//"a234"	false
//"1234"	true
public class P_9 {
    public boolean solution(String s) {
        boolean answer = true;
        answer = length_Cnt(s);
        if(answer == true) {
            answer = is_Num(s);
        }
        return answer;
    }

    public boolean length_Cnt(String s) {
        if(s.length() < 4 || s.length() > 6) {
            return false;
        } else {
            return true;
        }
    }

    public boolean is_Num(String s) {
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P_9 sol = new P_9();
        String s = "a234";
        System.out.println(sol.solution(s));
    }
}
