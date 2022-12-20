package Programmers.Level_1;

public class Pro_CT_15 {
    public int solution(int num) {
        int answer = 0;
        long n = (long)num;
        while (n != 1) {
            if (n == 1) {
                answer = 0;
            } else if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
            answer++;
            if (answer > 500) {
                answer = -1;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_15 sol = new Pro_CT_15();
        System.out.println(sol.solution(626331));
    }
}
