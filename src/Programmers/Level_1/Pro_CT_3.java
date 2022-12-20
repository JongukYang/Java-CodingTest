package Programmers.Level_1;

public class Pro_CT_3 {
    public static int solution(int n) {
        // n = 12 -> 1, 2, 3, 4, 6, 12
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(solution(n));
    }
}
