package Programmers.Level_2;

import java.util.ArrayDeque;
import java.util.Arrays;

// 올바른 괄호
public class PL2_4 {
    boolean solution(String s) {
        if(s.length() == 0 || s.length()%2 != 0 || s.charAt(0) == ')' || s.charAt(s.length()-1) == '(') {
            return false;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ')') {
                if(stack.size() < 1) {
                    return false;
                }
                stack.pop();
            } else {
                stack.addLast(c);
            }
        }
        return (!stack.isEmpty()) ? false : true;
    }

    public static void main(String[] args) {
        PL2_4 p = new PL2_4();
        String s ="()())(()";
//        String s ="(())()";
//        String s =")()(";
//        String s ="(()()";
        System.out.println(p.solution(s));
    }
}

// 첫 번째 풀이
//import java.util.ArrayDeque;
//class Solution {
//    boolean solution(String s) {
//        boolean answer = true;
//
//        if(s.charAt(0) == ')' || s.charAt(s.length()-1) == '(') {
//            return false;
//        }
//
//        ArrayDeque<String> stack = new ArrayDeque<String>();
//        String[] sArr = s.split("");
//
//        int a = 0;
//        int b = 0;
//
//        for(String item : sArr) {
//            stack.addLast(item);
//            if(")".equals(item)) {
//               a++;
//            } else {
//                b++;
//            }
//        }
//        if(a==b) {
//            answer = true;
//        }
//
//        return answer;
//
//    }
//}

// 두 번째 풀이
//public class PL2_4 {
//    boolean solution(String s) {
//        boolean answer = true;
//        if(s.length()%2 != 0 || s.charAt(0) == ')' || s.charAt(s.length()-1) == '(') {
//            return false;
//        }
//        ArrayDeque<String> stack = new ArrayDeque<String>();
//        String[] sArr = s.split("");
//        System.out.println("sArr = " + Arrays.toString(sArr));
//
//        for(String item : sArr) {
//            System.out.println("item = " + item);
//            if(item.equals(")")) {
//                stack.pop();
//            } else {
//                stack.addLast(item);
//            }
//            System.out.println(stack);
//        }
//        if(!stack.isEmpty()) {
//            return false;
//        } else {
//            return true;
//        }
//    }
