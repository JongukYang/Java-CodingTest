package Programmers.Level_2;
// 피보나치
public class PL2_13 {
    public int solution(int n) {
        int answer = 0;

        int[] fiboNum = new int[n + 1];
        fiboNum[0] = 0;
        fiboNum[1] = 1;

        return Fibo(n, fiboNum);
    }

    private int Fibo(int n, int[] fiboNum) {
        for(int i = 2; i <= n; i++) {
            fiboNum[i] = (fiboNum[i-2] + fiboNum[i-1]) % 1234567;
        }
        return fiboNum[n];
    }

    public static void main(String[] args) {
        PL2_13 p = new PL2_13();
        int n = 3;
        System.out.println(p.solution(n));
    }
}
