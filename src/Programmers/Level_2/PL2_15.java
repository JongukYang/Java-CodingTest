package Programmers.Level_2;

import java.util.ArrayDeque;

public class PL2_15 {
    // 짝지어 제거하기
    public int solution(String s) {
        int answer = 0;
        char[] c = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < c.length; i++) {
            if (stack.isEmpty()) {
                stack.addLast(c[i]);
            } else {
                if (stack.peekLast() == c[i]) {
                    stack.pollLast();
                } else {
                    stack.addLast(c[i]);
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        PL2_15 p = new PL2_15();
        String s = "baabaa";
        System.out.println(p.solution(s));
    }
}
