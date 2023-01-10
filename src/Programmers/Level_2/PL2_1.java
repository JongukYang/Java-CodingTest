package Programmers.Level_2;

import java.util.Arrays;

// 줄 서는 방법
public class PL2_1 {
    public int[] solution(int n, long k) {
        int[] answer = {};

        int num = 10;
        long find = 282621L;

        long[] factorial = new long[n];

        for(int i = 1; i <= n; i++) {
            factorial[i-1] = fact(n-i+1);
        }
        System.out.println("factorial = " + Arrays.toString(factorial));

        for(int i = 1; i < n; i++) {
            if(factorial[i-1] >= k && k >= factorial[i]) {
                System.out.println(factorial[i-1] + " " + factorial[i]);
                long div = k / factorial[i];
                long rest = k % factorial[i];
                System.out.println("div = " + div + " div*factorial[i] = " + factorial[i]*div);
                System.out.println("rest = " + rest);
            }
        }

        return answer;
    }

    private long fact(int num) {
        if(num == 1) {
            return 1;
        } else {
            return num * fact(num-1);
        }
    }

    public static void main(String[] args) {
        PL2_1 p = new PL2_1();
        int n = 3;
        long k = 5L;
        System.out.println(p.solution(n, k));
    }
}

//문제 설명
//n명의 사람이 일렬로 줄을 서고 있습니다. n명의 사람들에게는 각각 1번부터 n번까지 번호가 매겨져 있습니다. n명이 사람을 줄을 서는 방법은 여러가지 방법이 있습니다. 예를 들어서 3명의 사람이 있다면 다음과 같이 6개의 방법이 있습니다.
//
//[1, 2, 3]
//[1, 3, 2]
//[2, 1, 3]
//[2, 3, 1]
//[3, 1, 2]
//[3, 2, 1]
//사람의 수 n과, 자연수 k가 주어질 때, 사람을 나열 하는 방법을 사전 순으로 나열 했을 때, k번째 방법을 return하는 solution 함수를 완성해주세요.
//
//제한사항
//n은 20이하의 자연수 입니다.
//k는 n! 이하의 자연수 입니다.
//입출력 예
//n	k	result
//3	5	[3,1,2]
