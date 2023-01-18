package Programmers.Level_2;

import java.util.ArrayDeque;
import java.util.Arrays;

// 주식 가격
public class PL2_6 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {
            if(i < prices.length-1) {
                answer[i] = notDecreased(i, prices);
            }
            if(i == prices.length-1) {
                answer[prices.length-1] = 0;
            }
        }

        return answer;
    }

    private int notDecreased(int idx, int[] prices) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        stack.addFirst(prices[idx]);
        for(int i = idx+1; i < prices.length; i++) {
            if (stack.peekFirst() > prices[i]) {
                stack.addLast(prices[i]);
                break;
            } else {
                stack.addLast(prices[i]);
            }
        }
        return stack.size()-1;
    }

    public static void main(String[] args) {
        PL2_6 p = new PL2_6();
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(p.solution(prices));
    }
}
