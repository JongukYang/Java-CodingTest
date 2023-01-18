package Programmers.Level_2;

import java.util.ArrayDeque;

public class PL2_5 {
    // 괄호 회전하기
    public int solution(String s) {
        int answer = 0;
        // 길이가 홀수거나 0일 때 괄호 만들어 지지 않음
        if (s.length() == 1 || s.length() % 2 != 0) {
            return 0;
        }

        // 문자열 회전
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s);
            // 괄호 확인
            if (confirmStr(s)) {
                answer++;
            }
            s = s.substring(1, s.length()) + s.substring(0, 1);
        }

        return answer;
    }

    private boolean confirmStr(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] c = s.toCharArray();
        for (char item : c) {
            if(stack.isEmpty()) {
                stack.addLast(item);
                continue;
            }
            if (item == '[' || item == '{' || item == '(') {
                stack.addLast(item);
            } else if (item == ']' && stack.peekLast().equals('[')) {
                stack.pollLast();
            } else if (item == '}' && stack.peekLast().equals('{')) {
                stack.pollLast();
            } else if (item == ')' && stack.peekLast().equals('(')) {
                stack.pollLast();
            } else {
                return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        PL2_5 p = new PL2_5();
        String s = "[](){}";
//        String s = "}]()[{";
        System.out.println(p.solution(s));
    }
}
