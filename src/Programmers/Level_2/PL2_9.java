package Programmers.Level_2;

import java.util.ArrayDeque;

// 2022 KAKAO TECH INTERNSHIP
// 두 큐 합 같게 만들기
public class PL2_9 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0; // count를 세는 변수
        // 큐의 합을 저장할 변수
        long q1_Sum = 0L, q2_Sum = 0L;
        // 합 구하기
        for(int i = 0; i < queue1.length; i++){
            q1_Sum += queue1[i];
            q2_Sum += queue2[i];
        }
        // 홀수면 절대 만들 수 없음
        if((q1_Sum+q2_Sum) % 2 != 0) { return -1; }
        // 처음부터 같은 경우
        if(q1_Sum == q2_Sum) { return 0; }
        // 큐
        ArrayDeque<Integer> arrQueue1 = new ArrayDeque<>();
        ArrayDeque<Integer> arrQueue2 = new ArrayDeque<>();
        // 큐 초기화
        for(int i = 0; i< queue1.length; i++){
            arrQueue1.addLast(queue1[i]);
            arrQueue2.addLast(queue2[i]);
        }
        // 찾을 중간 수
        long findNum = (q1_Sum + q2_Sum) / 2;
        // 최대 횟수
        int limit = queue1.length*3;
        // 바꾸는 횟수가 최대 바꾸는 횟수까지 반복
        while(answer <= limit) {
            if (q1_Sum > findNum) {
                q1_Sum -= arrQueue1.peekFirst();
                q2_Sum += arrQueue1.peekFirst();
                arrQueue2.addLast(arrQueue1.pollFirst());
            } else {
                q2_Sum -= arrQueue2.peekFirst();
                q1_Sum += arrQueue2.peekFirst();
                arrQueue1.addLast(arrQueue2.pollFirst());
            }
            answer++;
            if((q1_Sum == findNum)){
                return answer;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PL2_9 p = new PL2_9();
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        System.out.println(p.solution(queue1, queue2));
    }
}
//public int solution(int[] queue1, int[] queue2) {
//        int answer = 0;
//        long q1_Sum = 0L;
//        long q2_Sum = 0L;
//        ArrayDeque<Long> arrQueue1 = new ArrayDeque<Long>();
//        ArrayDeque<Long> arrQueue2 = new ArrayDeque<Long>();
//        ArrayDeque<Long> arrQueue3 = new ArrayDeque<Long>();
//
//        for(int i = 0; i < queue1.length; i++){
//            arrQueue1.addLast((long) queue1[i]);
//            q1_Sum += (long)queue1[i];
//            arrQueue2.addLast((long) queue2[i]);
//            q2_Sum += (long)queue2[i];
//        }
//        System.out.println("arrQueue1 = " + arrQueue1);
//        System.out.println("arrQueue2 = " + arrQueue2);
//        System.out.println("q1_Sum = " + q1_Sum);
//        System.out.println("q2_Sum = " + q2_Sum);
//
//        // 홀수면 절대 만들 수 없음
//        if((q1_Sum+q2_Sum) % 2 != 0) {
//            return -1;
//        }
//
//        long findNum = (q1_Sum + q2_Sum) / 2;
//        System.out.println("findNum = " + findNum);
//
//        for(long i = 0; i<(arrQueue1.size()-1) * (arrQueue2.size()-1); i++) {
//            long switchNumAmount;
//            if (q1_Sum < q2_Sum) {
//                switchNumAmount = findNum - q1_Sum;
//                System.out.println("switchNumAmount = " + switchNumAmount);
//
//                long a = arrQueue2.pollFirst();
//                q2_Sum -= a;
//                System.out.println(a + " " + q2_Sum);
//
//                arrQueue1.addLast(a);
//                q1_Sum += a;
//
//            } else {
//                switchNumAmount = findNum - q2_Sum;
//                System.out.println("switchNumAmount = " + switchNumAmount);
//
//                long a = arrQueue1.pollFirst();
//                q1_Sum -= a;
//                System.out.println(a + " " + q1_Sum);
//
//                arrQueue2.addLast(a);
//                q2_Sum += a;
//
//            }
//            System.out.println(q1_Sum + " " + q2_Sum);
//            answer++;
//
//            if (q1_Sum == q2_Sum) {
//                break;
//            }
//            if(i == (arrQueue1.size()-1) * (arrQueue2.size()-1)){
//                answer = -1;
//                break;
//            }
//        }
//
//        return answer;
//    }