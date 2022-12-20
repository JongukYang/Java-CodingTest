package Programmers.Level_1;

import java.util.Arrays;

public class Pro_CT_39 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i<commands.length; i++) {
            int[] tmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(tmp);
            answer[i] += tmp[commands[i][2]-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_39 sol = new Pro_CT_39();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
        System.out.println(sol.solution(array, commands));
    }
}
