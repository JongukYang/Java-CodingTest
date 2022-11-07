import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

public class Pro_CT_18 {
//    public int[] solution(int[] arr, int divisor) {
//        List<Integer> answer = new ArrayList<>();
//        for(int i = 0; i<arr.length; i++) {
//            if (arr[i] % divisor == 0) {
//                answer.add(arr[i]);
//            }
//        }
//        answer.sort(Comparator.naturalOrder());
//
//        return answer.stream().mapToInt(Integer::intValue).toArray();
//    }
    public int[] solution(int[] arr, int divisor) {
        int cnt = 0;
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] % divisor == 0) {
                cnt++;
            }
        }

        if(cnt == 0) {
            int[] answer = {-1};
            return answer;
        }

        int[] answer = new int[cnt];
        for(int i = 0, j = 0; i<arr.length; i++) {
            if(arr[i] % divisor == 0) {
                answer[j] = arr[i];
                j++;
            }
        }
        Arrays.sort(answer);
        return answer;
}

    public static void main(String[] args) {
        Pro_CT_18 sol = new Pro_CT_18();
        int[] arr = {5,9,7,10};
        int divisor = 5;
        System.out.println(sol.solution(arr, divisor));
    }
}
