package Study_CT;

import java.util.Collections;
import java.util.PriorityQueue;

// 디펜스 게임 - lv2
// 우선순위 큐
public class 디펜스_게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int e : enemy) {
            pq.add(e * -1);
            // 무적권 사용해야 하는 경우
            if (k > 0 && n < e) {
                n += pq.poll() * -1; // 내림차순 하기 위해서 -1 곱하기
                k--;
            }
            n -= e;
            if (n < 0) {
                break;
            }
            answer++;
        }


        return answer;
    }

    public static void main(String[] args) {
        디펜스_게임 p = new 디펜스_게임();
        int n = 7;
        int k = 3;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        System.out.println(p.solution(n, k, enemy));
    }
}
