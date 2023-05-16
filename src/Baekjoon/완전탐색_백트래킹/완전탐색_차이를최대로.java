package Baekjoon.완전탐색_백트래킹;
import java.io.*;
import java.util.StringTokenizer;

public class 완전탐색_차이를최대로 {
    // 벡준 실버2 10819

    private static int N;
    private static int[] A;
    private static int[] NUMS;
    private static boolean visited[];
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 6
        A = new int[N]; // [20, 1, 15, 8, 4, 10]
        NUMS = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            NUMS[i] = (Integer.parseInt(st.nextToken()));
        }

        // 배열의 값들의 순서를 바꿔서
        // |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
        // 의 값 중에서 가장 큰 것을 구하기
        dfs(0);

        System.out.println(result);
    }

    private static void dfs(int cnt) {
        if (cnt == N) {
            result = Math.max(getSum(), result);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                A[cnt] = NUMS[i];
                dfs(cnt + 1);
                visited[i] = false;
            }
        }
    }
    private static int getSum() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(A[i] - A[i + 1]);
        }
        return sum;
    }


}
