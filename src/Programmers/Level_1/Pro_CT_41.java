package Programmers.Level_1;

import java.util.ArrayList;
import java.util.Collections;

public class Pro_CT_41 {
//    두 개 뽑아서 더하기
//    정수 배열 numbers가 주어집니다. numbers에서
//    서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는
//    모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
    public int[] solution(int[] numbers) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i< numbers.length; i++) {
            for(int j = i+1; j<numbers.length; j++) {
                int res = numbers[i] + numbers[j];
                if(!arrayList.contains(res)) {
                    arrayList.add(res);
                }
            }
        }
        Collections.sort(arrayList);
        int[] answer = new int[arrayList.size()];
        for (int i = 0; i<answer.length; i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_41 sol = new Pro_CT_41();
        int[] numbers = {2, 1, 3, 4, 1};
        System.out.println(sol.solution(numbers));
    }
}
