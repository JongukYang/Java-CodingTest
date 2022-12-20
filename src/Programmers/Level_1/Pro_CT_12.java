package Programmers.Level_1;

public class Pro_CT_12 {
    public int solution(int n) {
        int answer = 0; // x
        int x = 1;
        while (true) {
            if (n % x == 1) {
                answer = x;
                break;
            }
            x++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_12 sol = new Pro_CT_12();
        System.out.println(sol.solution(10));
    }
}
