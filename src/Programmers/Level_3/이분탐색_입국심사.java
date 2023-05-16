package Programmers.Level_3;

public class 이분탐색_입국심사 {

    private static final long MAX = 1_000_000_000;
    private static int N;
    private static int[] TIMES;

    public long solution(int n, int[] times) {
        N = n;
        TIMES = times;

        long left = 1; // 답으로 나올 수 있는 최소값
        long right = MAX*MAX; // 답으로 나올 수 있는 최대값

        while (left < right) { // 최대 60번 반복
            long mid = (left + right) / 2;
            if (isPossible(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean isPossible(long mid) {
        long n = N;

        for (int time : TIMES) { // 최대 10만번 반복
            n -= mid / time; // 7과 10으로 나눠본다.
            System.out.println(n);
        }
        System.out.println("######################");
        return n <= 0;
    }

    public static void main(String[] args) {
        이분탐색_입국심사 p = new 이분탐색_입국심사();
        int n = 6;
        int[] times = {7, 10};
        System.out.println(p.solution(n, times));
    }
}
