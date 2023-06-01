package Programmers.Algorithm.stack_queue;

import java.util.HashMap;
import java.util.Stack;

public class 올바른괄호 {
    // TODO: 2023/06/01 다시 풀기 : 효율성 시간초과
    private static class Solution {
        boolean solution(String s) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("(", ")");
            hashMap.put("{", "}");
            hashMap.put("[", "]");

            String[] sSplit = s.split("");
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < sSplit.length; i++) {
                if (hashMap.containsKey(sSplit[i])) { // (
                    stack.push(sSplit[i]);
                } else { // )
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (!hashMap.get(stack.peek()).equals(sSplit[i])) { // ()()
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }

            return stack.isEmpty() ? true : false;
        }
    }
}
