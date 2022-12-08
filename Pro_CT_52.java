import java.util.ArrayList;

public class Pro_CT_52 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero_cnt = 0;
        int corr_cnt = 0;
        for(int i = 0; i<lottos.length; i++) {
            if(lottos[i] == 0) {
                zero_cnt++;
            }
        }
        System.out.println(zero_cnt);

        for(int i = 0; i<lottos.length; i++) {
            for(int j=0; j<win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    corr_cnt++;
                }
            }
        }
        System.out.println(corr_cnt);

        switch (corr_cnt) {
            case 0: answer[1] = 6; break;
            case 1: answer[1] = 6; break;
            case 2: answer[1] = 5; break;
            case 3: answer[1] = 4; break;
            case 4: answer[1] = 3; break;
            case 5: answer[1] = 2; break;
            case 6: answer[1] = 1; break;
        }

        switch (corr_cnt+zero_cnt) {
            case 0: answer[0] = 6; break;
            case 1: answer[0] = 6; break;
            case 2: answer[0] = 5; break;
            case 3: answer[0] = 4; break;
            case 4: answer[0] = 3; break;
            case 5: answer[0] = 2; break;
            case 6: answer[0] = 1; break;
        }

//        int zero_cnt = 0;
//        ArrayList<Integer> lotto_arr = new ArrayList<>();
//        ArrayList<Integer> except_nums = new ArrayList<>();
//
//        for (int i = 0; i<lottos.length; i++) {
//            if(lottos[i] == 0) {
//                zero_cnt++;
//            }
//            lotto_arr.add(lottos[i]);
//        }
//        System.out.println("lotto_nums : "+lotto_arr + " " + zero_cnt);
//
//        int corr_cnt = 6;
//
//        for(int i = 0; i<lotto_arr.size(); i++) {
//            if (!lotto_arr.contains(win_nums[i])) {
//                except_nums.add(win_nums[i]);
//                corr_cnt--;
//            }
//        }
//        System.out.println("except_nums : "+except_nums + " " + corr_cnt);
//
//        answer[0] = corr_cnt + zero_cnt;
//        answer[1] = corr_cnt;

        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_52 sol = new Pro_CT_52();
        int[] lottos = {44, 1, 0 ,0, 31, 25}; // 구매한 로또 번호
        int[] win_nums = {31,10,45,1,6,19}; // 당첨 번호
        System.out.println(sol.solution(lottos,win_nums));
    }
}
//
//    public int[] solution(int[] lottos, int[] win_nums) {
//        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
//        int zeroCount = 0;
//
//        for(int lotto : lottos) {
//            if(lotto == 0) {
//                zeroCount++;
//                continue;
//            }
//            map.put(lotto, true);
//        }
//
//
//        int sameCount = 0;
//        for(int winNum : win_nums) {
//            if(map.containsKey(winNum)) sameCount++;
//        }
//
//        int maxRank = 7 - (sameCount + zeroCount);
//        int minRank = 7 - sameCount;
//        if(maxRank > 6) maxRank = 6;
//        if(minRank > 6) minRank = 6;
//
//        return new int[] {maxRank, minRank};
//    }