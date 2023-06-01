package Programmers.Algorithm.stack_queue;

import java.util.*;
public class 프로세스 {
    private static class Solution {
        private static class Node {
            int priority;
            int idx;

            public Node(int priority, int idx) {
                this.priority = priority;
                this.idx = idx;
            }
        }
        public int solution(int[] priorities, int location) {
            int answer = 0;

            ArrayDeque<Node> queue = new ArrayDeque<>();
            for (int i = 0; i < priorities.length; i++) {
                queue.add(new Node(priorities[i], i));
            }
            // 숫자가 높을 수록 우선순위가 높음
            while (!queue.isEmpty()) {
                Node now = queue.pollFirst();
                if (getHighPriority(now.priority, queue)) {
                    // 우선순위가 제일 높으면
                    answer++;
                    if (now.idx == location) {
                        return answer;
                    }
                }
                else {
                    // 우선순위가 낮으면
                    queue.addLast(now);
                }
            }

            return answer;
        }

        private static boolean getHighPriority(int nowPriority, ArrayDeque<Node> queue) {
            ArrayDeque<Node> copy = new ArrayDeque<>();
            copy = queue.clone();
            while (!copy.isEmpty()) {
                Node now = copy.pollFirst();
                if (now.priority > nowPriority) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(s.solution(priorities, location));
    }
}
