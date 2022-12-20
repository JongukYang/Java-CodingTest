package Programmers.Level_1;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Pro_CT_62 {
    //    명예의 전당
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int day = 1;
        for(int i =0; i<score.length; i++) {
            // 첫 날
            if (linkedList.isEmpty()) {
                linkedList.add(score[i]);
                answer[day-1] = linkedList.getLast();
                System.out.println("if");
            }
            // 둘 째 날부터
            else {
                // 명예의 전당 숫자 k 보다 작을 경우
                if(linkedList.size() < k) {
                    // 점수가 linkedList 의 마지막보다 같거나 작으면 맨 뒤에 add
                    if(score[i] <= linkedList.getLast()) {
                        linkedList.add(score[i]);
                        answer[day-1] = linkedList.getLast();
                    }
                    // 점수가 linkedList 의 마지막보다 같거나 크면 같거나 작은 숫자 앞의 위치에 add
                    else if(score[i] >= linkedList.getLast()) {
                        for(int j = 0; j<linkedList.size(); j++) {
                            if(score[i] >= linkedList.get(j)) {
                                linkedList.add(j,score[i]);
                                break;
                            }
                        }
                        answer[day-1] = linkedList.getLast();
                    }
                }
                // 명예의 전당 숫자 k 보다 큰 경우
                else if(linkedList.size() >= k) {
                    // 점수가 명예의 전당 k 내부의 마지막 요소보다 같거나 작을 경우
                    if(score[i] <= linkedList.get(k-1)) {
                        linkedList.add(score[i]);
                        answer[day-1] = linkedList.get(k-1);
                    }
                    // 점수가 명예의 전당 k 내부의 마지막 요소보다 같거나 클 경우
                    else if(score[i] >= linkedList.get(k-1)) {
                        for(int j = 0; j<k; j++) {
                            if(score[i] >= linkedList.get(j)) {
                                linkedList.add(j, score[i]);
                                break;
                            }
                        }
                        answer[day - 1] = linkedList.get(k-1);
                    }
                }
            }
            day++;
        }
//        System.out.println("answer[] : ");
//        for (int i = 0; i < answer.length; i++) {
//            System.out.println(answer[i]);
//        }
//        System.out.println("LinkedList : ");
//        for(int i = 0; i<linkedList.size(); i++) {
//            System.out.println(linkedList.get(i));
//        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 3; // 명예이 전당에 올라가는 개수 -> 차례대로 밀려나간다는 뜻
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        Pro_CT_62 sol = new Pro_CT_62();
        System.out.println(sol.solution(k, score));
    }
}

//
//class Solution {
//    public int[] solution(int k, int[] score) {
//        int[] answer = new int[score.length];
//
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//
//        int temp = 0;
//
//        for(int i = 0; i < score.length; i++) {
//
//            priorityQueue.add(score[i]);
//            if (priorityQueue.size() > k) {
//                priorityQueue.poll();
//            }
//
//            answer[i] = priorityQueue.peek();
//        }
//
//
//
//        return answer;
//    }
//}
