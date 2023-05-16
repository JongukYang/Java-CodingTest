package Programmers.Level_4;

public class test {

    private static int N, K;
    private static int[] A, NUMS, RESULT_NUMS;
    private static boolean visited[];
    private static int resultSum;

    public int[] solution(int n, int k, int[] arrNum) {
//        Arrays.sort(arrNum);
        N = n; // 뽑을 수의 개수
        K = k; // Limit
        A = arrNum; // 원본 배열
        NUMS = new int[N]; // 완전탐색을 위한 배열 N개
        visited = new boolean[N]; // 방문 여부 체크 N개

        dfs(0);

        for (int i = 0; i < N; i++) {
            System.out.println(RESULT_NUMS[i]);
        }

        return RESULT_NUMS;
    }

    private static void dfs(int cnt) {
        // N개의 배열이 다 뽑혔을 때
        if (cnt == N) {
            // 최대값 계산
            resultSum = Math.max(getSum(), resultSum);
            // NUMS 배열의 합이 최대가 된다면 결과 배열에 NUMS 배열 삽입
            if (getSum() >= resultSum) {
                RESULT_NUMS = NUMS;
            }
            return;
        }
        // 4개씩 뽑을 수 있도록 반복
        for (int i = 0; i < N; i++) {
            // 방문하지 않았다면
            if (!visited[i]) {
                visited[i] = true; // 방문처리
                NUMS[cnt] = A[i]; // 배열의 인덱스에 원본 배열 값 삽입
                dfs(cnt + 1);
                visited[i] = false; // 방문처리 해제
            }
        }
    }
    // 만들어진 NUMS 배열의 합 구하기
    private static int getSum() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += NUMS[i];
            // K 보다 크다면 옳은 답이 아니니 return 0
            if (sum > K) {
                return 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        test p = new test();
        int n = 3;
        int k = 9;
        int[] arrNum = { 2, 1, 5, 3, 2, 9, 8};
        System.out.println(p.solution(n, k, arrNum)); // 3
    }
}
