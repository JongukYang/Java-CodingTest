import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Pro_CT_48 {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int[] playerHighStages = new int[N]; // 스테이지에 있는 사람 수
        int[] failPlayers = new int[N]; // 실패한 유저

        for(int i = 0; i<stages.length;i++) {
            if(stages[i] != N+1) {
                failPlayers[stages[i]-1]++;
                for(int j = 0; j<stages[i]; j++) {
                    playerHighStages[j]++;
                }
            }
            else {
                for(int k = 0; k<playerHighStages.length; k++) {
                    playerHighStages[i]++;
                }
            }
        }
        ArrayList<Double> failRates = new ArrayList<>();

        for(int i = 0; i<N; i++) {
//            double rate = Double.isNaN((double)failPlayers[i]/playerHighStages[i]) ? 0 : (double)failPlayers[i]/playerHighStages[i];
            double rate = 0;
            if(failPlayers[i]==0) {
                failRates.add(0.0);
            }
            else {
                failRates.add((double)failPlayers[i]/playerHighStages[i]);
            }
        }
        Collections.sort(failRates);
        for(int i = 0; i<failRates.size(); i++) {
            System.out.println(failRates);
        }
//
//        for(int i = 0; i<N; i++) {
//            for(int j=0; j<stages.length; j++){
//                if(stages[j] == i+1) {
//                    playerHighStages[i]++;
//                }
//            }
//        }
//
//        for(int i = 0; i<failRates.length; i++) {
//            System.out.println(playerHighStages[i]);
//        }


        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_48 sol = new Pro_CT_48();
        int N = 5;
        int[] stages = {2,1,2,6,2,4,3,3};
        System.out.println(sol.solution(N,stages));
    }
}
