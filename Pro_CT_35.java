import java.util.*;

public class Pro_CT_35 {
    //    부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때, 최대 몇 개의 부서에 물품을 지원할 수 있는지 return
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int cnt = 0;
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
            if (d[i] > budget) {
                continue;
            } else if (d[i] <= budget) {
                budget -= d[i];
                cnt++;
            }
        }
        answer = cnt;

        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_35 sol = new Pro_CT_35();
        int[] d = {1, 3, 2, 5, 4};
        int budget = 9;
        System.out.println(sol.solution(d, budget));
    }
}
