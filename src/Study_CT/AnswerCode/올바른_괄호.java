package Study_CT.AnswerCode;

import java.util.ArrayDeque;
import java.util.HashMap;
// 올바른 괄호 HashMap 풀이
public class 올바른_괄호 {
    boolean solution(String s) {

        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('{', '}');
        hashMap.put('[', ']');

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                stack.addLast(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                else if (hashMap.get(stack.pollLast()) != c) {
                    return false;
                }
            }
        }

        return (!stack.isEmpty()) ? false : true;

    }

    public static void main(String[] args) {
        올바른_괄호 p = new 올바른_괄호();
        String s = "(())()";
        System.out.println(p.solution(s));
    }
}
