import java.util.ArrayList;
import java.util.Arrays;

public class Pro_CT_63 {
    // 옹알이
    public int solution(String[] babbling) {
        int answer = 0;
//      String[] babbling= {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
//      조카가 할 수 있는 발음  "aya", "ye", "woo", "ma"
        String[] babyBab = {"aya", "ye", "woo", "ma"};

        for(int i = 0; i<babbling.length; i++) {
            for(int j = 0; j<babyBab.length; j++) {
                String[] canBab = babbling[i].split(babyBab[j]);
                System.out.println("canBab : " + Arrays.toString(canBab));
                ArrayList<String> canBabLiist = new ArrayList<>();
                for(String s : canBab) {
                    canBabLiist.add(s);
                }
                for(int k = 0; k<babyBab.length; k++) {
                    if(canBabLiist.contains(babyBab[k])) {
                        System.out.println("exist : " + babyBab[k]);
                    }
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_63 sol = new Pro_CT_63();
        String[] babbling= {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        System.out.println(sol.solution(babbling));
    }
}
