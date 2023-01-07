package Programmers.Prime_Leve1;

import java.util.Arrays;

// [1차] 비밀지도
public class P_14 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            // Integer.toBinaryString() : 이진수로 바꿔줌
            String binaryNum1 = Integer.toBinaryString(arr1[i]);
            String binaryNum2 = Integer.toBinaryString(arr2[i]);
            System.out.println("binaryNum1: " + binaryNum1 + " binaryNum2: " + binaryNum2);
            // 숫자의 길이 맞추기 위해 0 삽입
            String[] binaryNum1Arr = insertZero(binaryNum1, n);
            String[] binaryNum2Arr = insertZero(binaryNum2, n);
            System.out.println("binaryNum1Arr : "+Arrays.toString(binaryNum1Arr) + " binaryNum2Arr : "+Arrays.toString(binaryNum2Arr));
            // 한 행씩 비밀지도 맞추기
            StringBuilder sb = new StringBuilder();
            for(int j= 0; j<n; j++) {
                if(binaryNum1Arr[j].equals("1") || binaryNum2Arr[j].equals("1")) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            // 완성 행 answer배열 삽입
            answer[i] = sb.toString();
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
    private String[] insertZero(String binaryNum, int n) {
        if(binaryNum.length() != n) {
            String zero = "";
            for(int j = 0; j<n-binaryNum.length(); j++) {
                zero += "0";
            }
            binaryNum = zero + binaryNum;
        }
        return binaryNum.split("");
    }


    public static void main(String[] args) {
        P_14 p = new P_14();
        int n = 5; // 한 변의 길이가 n인 정사각형 배열,각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(p.solution(n, arr1, arr2));
    }
}
//지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
//전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 "지도 1"과 "지도 2"라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
//"지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
//암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.