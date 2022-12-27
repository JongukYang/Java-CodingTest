package Programmers.Prime_Leve1;

public class P_8 {
    public String solution(String s) {
        String answer = "";
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(new String(arr));
        answer = sb.reverse().toString();
        return answer;
    }

    public static void main(String[] args) {
        P_8 sol = new P_8();
        String s = "Zbcdefg";
        System.out.println(sol.solution(s));
    }
}
