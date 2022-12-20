package Programmers.Level_1;

public class Pro_CT_20 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 123456789;
        answer = 0;
        for(int i = 0; i<absolutes.length; i++) {
            if(signs[i] == false) {
                absolutes[i] = -(absolutes[i]);
            }
            answer += absolutes[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_20 sol = new Pro_CT_20();
        int[] absolutes = {4,7,12};
        boolean[] signs = {true, false, true};
        System.out.println(sol.solution(absolutes, signs));
    }
}
