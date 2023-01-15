package Study_CT;

import java.util.ArrayDeque;

public class 행렬과_연산 {
    public int[][] solution(int[][] rc, String[] operations) {

        int[][] answer = new int[rc.length][rc[0].length];

        ArrayDeque<Integer> left = new ArrayDeque<>(); // 좌측 열
        ArrayDeque<Integer> right = new ArrayDeque<>(); // 우측 열
        ArrayDeque<ArrayDeque<Integer>> mid = new ArrayDeque<>(); // 가운데 n열

        // 초기 값 Queue에 입력
        // O(N) -> N = rows * cols <= 100,000
        for (int i = 0; i < rc.length; i++) {
            left.addLast(rc[i][0]);
            ArrayDeque<Integer> midQueue = new ArrayDeque<>();
            for (int j = 1; j < rc[i].length - 1; j++) {
                midQueue.addLast(rc[i][j]);
            }
            mid.addLast(midQueue);
            right.addLast(rc[i][rc[i].length - 1]);
        }

        // ShiftRow / Rotate 연산
        // O(N) N = 100,000
        for (String operation : operations) {
            // ShiftRow인 경우
            if ("ShiftRow".equals(operation)) {
                left.addFirst(left.pollLast()); // O(1)
                mid.addFirst(mid.pollLast()); // O(1)
                right.addFirst(right.pollLast()); // O(1)
            }
            // Rotate일 경우
            else {
                mid.peekFirst().addFirst(left.pollFirst()); // O(1)
                right.addFirst(mid.peekFirst().pollLast()); // O(1)
                mid.peekLast().addLast(right.pollLast()); // O(1)
                left.addLast(mid.peekLast().pollFirst()); // O(1)
            }
        }

        // Queue에 담긴 값을 배열로 변환
        for (int i = 0; i < answer.length; i++) {
            answer[i][0] = left.pollFirst();
            ArrayDeque<Integer> midQueue = mid.pollFirst();
            for (int j = 1; j < answer[i].length - 1; j++) {
                answer[i][j] = midQueue.pollFirst();
            }
            answer[i][answer[i].length - 1] = right.pollFirst();
        }

        return answer;
    }

    public static void main(String[] args) {
        행렬과_연산 solution = new 행렬과_연산();
        int[][] rc = {{1, 2, 3}, {4, 5, 6}, {7, 8, 6}};
        String[] operations = {"Rotate", "ShiftRow"};
        System.out.println(solution.solution(rc, operations));
    }
}
