package Study_CT.AnswerCode;

import java.util.PriorityQueue;

public class 징검다리_건너기 {
    // 징검다리 건너기

    private static class Stone {
        int idx, val;

        public Stone(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public int solution(int[] stones, int k) {
        PriorityQueue<Stone> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.val, o1.val));
        int i;
        for (i = 0; i < k; i++) {
            pq.add(new Stone(i, stones[i]));
        }

        int answer = pq.peek().val; // 건너는 친구들 수 // 처음엔 5

        while (i < stones.length) {
            pq.add(new Stone(i, stones[i])); // 처음 i = 3
            i++; // i = 4

            while (pq.peek().idx < i - k) {
                System.out.println("pq.peek() : " + pq.peek().val);
                pq.poll();
            }

            answer = Math.min(answer, pq.peek().val);
        }

        return answer;
    }

    public static void main(String[] args) {
        징검다리_건너기 p = new 징검다리_건너기();
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}; // 디딤돌에 적힌 숫자, 한번 밟으면 -1
        int k = 3; // 한 번에 건널 수 있는 디딤돌의 최대 칸수
        System.out.println(p.solution(stones, k));
    }
}
