import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Pro_CT_54 {
//    체육복
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌 체육복을 가져온 학생이 도난당한 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        // 도난당한 학생에게 체육복 빌려주는 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
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
//    public int solution(int n, int[] lost, int[] reserve) {
//        int answer=n-lost.length;
//        HashSet<Integer> ko = new HashSet<Integer>();
//        for(int k : reserve) {
//            ko.add(k);
//        }
//        for(int i =0;i<lost.length;i++) {
//            if(ko.contains(lost[i])) {
//                //System.out.println("내껀내가입지");
//                answer++;
//                ko.remove(lost[i]);
//                lost[i]=-1;
//            }
//        }
//
//
//        for(int i =0;i<lost.length;i++) {
//            //System.out.println(i);
//
//            if(ko.contains(lost[i]-1)) {
//                //System.out.println("있다");
//                answer++;
//                ko.remove(lost[i]-1);
//            }else if(ko.contains(lost[i]+1)) {
//                //System.out.println("있다");
//                answer++;
//                ko.remove(lost[i]+1);
//            }
//            //System.out.println("없다");
//        }
//
//
//        return answer;
//    }
