package Programmers.Level_2;

import java.util.Arrays;

//JadenCase 문자열 만들기
public class PL2_8 {
    public String solution(String s) {
        String answer = "";
        String[] sArr = s.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i].length() != 0) {
                sb.append(sArr[i].substring(0, 1).toUpperCase());
                sb.append(sArr[i].substring(1, sArr[i].length()));
            }
            sb.append(" ");
        }

        if(!(" ".equals(s.substring(s.length()-1, s.length())))) {
            sb.deleteCharAt(sb.lastIndexOf(" "));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        PL2_8 p = new PL2_8();
        String s = "3people  unFollowed  me";
        System.out.println(p.solution(s));
    }
}
//JadenCase 문자열 만들기
//문제 설명
//JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
//문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
//
//제한 조건
//s는 길이 1 이상 200 이하인 문자열입니다.
//s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
//숫자는 단어의 첫 문자로만 나옵니다.
//숫자로만 이루어진 단어는 없습니다.
//공백문자가 연속해서 나올 수 있습니다.
//입출력 예
//s	return
//"3people unFollowed me"	"3people Unfollowed Me"
//"for the last week"	"For The Last Week"

//String[] sArr = s.split(" ");
//        System.out.println(Arrays.toString(sArr));
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i<sArr.length; i++) {
//            char c = sArr[i].charAt(0);
//            // 첫 글자가 숫자일 때
//            if (c < 'a' || c == ' ') {
//                sArr[i] = sArr[i].toLowerCase();
//                sb.append(sArr[i]);
//            }
//            // 첫 글자가 문자일 때
//            else if (('A' < c && c > 'Z') || ('a' < c && c > 'z')) {
//                sArr[i] = sArr[i].toLowerCase();
//                sb.append(sArr[i].substring(0, 1).toUpperCase());
//                sb.append(sArr[i].substring(1, sArr[i].length()));
//            }
//            if(i < sArr.length-1 ){
//                sb.append(" ");
//            }
//        }
//        return sb.toString();

