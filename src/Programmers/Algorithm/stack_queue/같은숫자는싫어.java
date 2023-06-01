package Programmers.Algorithm.stack_queue;

import java.util.ArrayDeque;
import java.util.Stack;

public class 같은숫자는싫어 {
    private static class Solution {
        public int[] solution(int[] arr) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < arr.length; i++) {
                if (!stack.isEmpty()) {
                    if (stack.peekLast() == arr[i]) {
                        continue;
                    } else {
                        stack.addLast(arr[i]);
                    }
                } else {
                    stack.addLast(arr[i]);
                }
            }
            int[] answer = new int[stack.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = stack.pollFirst();
            }
            return answer;
        }


        public static void main(String[] args) {
            Solution s = new Solution();
            int[] arr = {1, 1, 3, 3, 0, 1, 1};
            System.out.println(s.solution(arr));
        }
    }
}
