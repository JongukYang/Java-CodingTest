package Programmers.Algorithm.stack_queue;
import java.util.*;
public class 기능개발 {

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            ArrayDeque<Integer> speedsQueue = new ArrayDeque<>();
            for (int i = 0; i < progresses.length; i++) {
                queue.addLast(progresses[i]);
                speedsQueue.addLast(speeds[i]);
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (!queue.isEmpty()) {
                for (int i = 0; i < queue.size(); i++) {
                    int a = queue.pollFirst();
                    int b = speedsQueue.pollFirst();
                    queue.addLast(a + b);
                    speedsQueue.addLast(b);
                }
                // 100이 넘으면
                if (queue.peekFirst() >= 100) {
                    int cnt = 0;
                    while (true) {
                        if (queue.isEmpty() || queue.peekFirst() < 100) {
                            break;
                        }
                        if (queue.peekFirst() >= 100) {
                            queue.pollFirst();
                            speedsQueue.pollFirst();
                            cnt++;
                        }
                    }
                    arrayList.add(cnt);
                }
            }

            int[] answer = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                answer[i] = arrayList.get(i);
            }

            return answer;
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            int[] progresses = {93, 30, 55};
            int[] speeds = {1, 30, 5};
            System.out.println(s.solution(progresses, speeds));
        }
    }
}
