// 함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.

// 제한 조건
// n은 1이상 8000000000 이하인 자연수입니다.
// 입출력 예
// n	return
// 118372	873211
import java.util.*;

public class Pro_CT_13 {
    public long solution(long n) {
        long answer = 0;
        String[] list = String.valueOf(n).split("");
        System.out.println(list);
        Arrays.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<list.length; i++) {
            sb.append(list[i]);
        }
        answer = Long.parseLong(sb.reverse().toString());
        return answer;
    }
    public static void main(String[] args) {
        Pro_CT_13 sol = new Pro_CT_13();
        System.out.println(sol.solution(118372));
    }
}
