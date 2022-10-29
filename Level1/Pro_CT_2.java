package Level1;
public class Pro_CT_2 {

    public static double solution(int[] arr) {
        double answer = 0;
        for(int i =0; i<arr.length; i++) {
            answer += arr[i];
        }
        answer = answer/arr.length;
        return answer;
    }

    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3, 4 };
        int[] arr = { 5, 5 };
        System.out.println(solution(arr));
    }

}

// // 모범답안
// import java.util.*;
// import java.lang.*;

// class Solution {
//     public double solution(int[] arr) {

//         return Arrays.stream(arr).average().getAsDouble();
//     }
// }