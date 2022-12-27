package Programmers.Prime_Leve1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//제일 작은 수 제거하기
//문제 설명
//정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
//
//제한 조건
//arr은 길이 1 이상인 배열입니다.
//인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
public class P_6 {
    public int[] solution(int[] arr) {
        if(arr.length < 2) {
            int[] none = {-1};
            return none;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int n : arr) {
            arrayList.add(n);
        }
        Collections.sort(arrayList, Collections.reverseOrder());
        arrayList.remove(arrayList.size()-1);
        int[] answer = new int[arrayList.size()];
        for(int i = 0; i<arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        P_6 sol = new P_6();
        int[] arr = {4, 3, 2, 1};
        System.out.println(sol.solution(arr));
    }
}
