package Programmers.Level_1;

public class Pro_CT_6 {
    public static long solution(long n) {
        long answer = 0;
        long sqrt = (long)Math.sqrt(n);
        if(n == Math.pow(sqrt, 2)) {
            return (long)Math.pow(sqrt+1, 2);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int n = 121;
        System.out.println(solution(n));
    }
}
