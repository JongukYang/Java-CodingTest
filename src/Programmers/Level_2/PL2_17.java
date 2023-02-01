package Programmers.Level_2;

import java.util.*;

public class PL2_17 {
    // Level2 가장 큰 수
    public String solution(int[] numbers) {
        // numbers 배열을 String 변환
        String[] sArr = new String[numbers.length];
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = Integer.toString(numbers[i]);
        }

        System.out.println(Arrays.toString(sArr));

        // String으로 변환된 sArr[] 원소들을 사전순으로 내림차순 정렬
        // Arrays.sort 재정의
        Arrays.sort(sArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2); // 내림차순 [9, 5, 34, 3, 30]
//                return (o1+o2).compareTo(o1+o2); // 오름차순 [3, 30, 34, 5, 9]
//                return (o1+o2).compareTo(o2+o1); // [30, 3, 34, 5, 9]
//                return (o2+o1).compareTo(o2+o1); // [3, 30, 34, 5, 9]
//                return (o2).compareTo(o1); // 내림차순 [9, 5, 34, 30, 3]
//                return (o1).compareTo(o2); // 오름차순 [9, 5, 34, 30, 3]
            }
        });

        System.out.println(Arrays.toString(sArr));

        // 문자열 합치기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sArr.length; i++) {
            sb.append(sArr[i]);
        }

        String answer = sb.toString();

        // 0으로 시작하면 모두가 0일테니까 0으로 반환
        if (answer.startsWith("0")) {
            return answer = "0";
        }

        return answer;
    }

    public static void main(String[] args) {
        PL2_17 p2 = new PL2_17();
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(p2.solution(numbers)); //9 5 34 3 30
    }
}
