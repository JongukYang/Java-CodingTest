import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Pro_CT_54 {
//    체육복
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int cnt= 0;
        for(int i = 0; i<lost.length; i++) {
            for(int j = 0; j<reserve.length; j++) {
                if(lost[i] == reserve[j])
                {
                    lost[i] = reserve[i] = -1;
                    cnt++;
                    break;
                }
            }
        }
        for(int i = 0; i<lost.length; i++) {
            for(int j = 0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]-1 || lost[i] == reserve[j] +1)
                {
                    reserve[i] = -1;
                    cnt++;
                    break;
                }
            }
        }
        answer = n - lost.length + cnt;
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_54 sol = new Pro_CT_54();
        int n = 5; // 전체 학생 수
        int[] lost = {2,4}; // 체육복을 도난당한 학생들의 번호
        int[] reverse = {1,3,5}; // 여벌의 채육복을 가져온 학생들의 번호
        System.out.println(sol.solution(n, lost, reverse));
    }
}
