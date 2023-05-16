package Study_CT.AnswerCode;

// LV3 입국심사 - 이분탐색
public class 이분탐색_입국심사 {
    private static final long MAX = 1_000_000_000; // 10억
    private static int N;
    private static int[] TIMES;

    public long solution(int n, int[] times) {
        N = n;
        TIMES = times;

        long left = 1; // 최소 1분 걸림
        long right = MAX * MAX;

        // 왼쪽에 있는걸 찾을 거임
        // 업다운 게임처럼 왼쪽(낮은 수)이 가능하다면 계속 이분탐색 하는 것
        while (left < right) {
            System.out.println("#########################################");
            System.out.println("left = " + left + " | right = " + right);
            long mid = (left + right) / 2; // 왼쪽과 오른쪽을 더 해 1/2하면 중간수가 나옴
            System.out.println("mid = " + mid);
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
        for (int time : TIMES) {
            n = n - (mid / time);
            System.out.println("n = " + n);
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        이분탐색_입국심사 p = new 이분탐색_입국심사();
        int n = 6;
        int[] times = {7, 10};
        System.out.println(p.solution(n, times));
    }
}
