package Study_CT.AnswerCode;

// LV3 - DFS - 네트워크
public class DFS_네트워크 {

    private static int[][] COMPUTERS;
    private static boolean[] visited;

    public int solution(int n, int[][] computers) {
        COMPUTERS = computers;
        visited = new boolean[n];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                dfs(i); // 처음 방문 노드 전달
                answer++;
            }
        }
        return answer;
    }

    private static void dfs(int now) {
        // 방문 체크
        if (visited[now] == true) {
            return;
        }
        // 처음 방문한거라면
        visited[now] = true;

        // now 부터 DFS 탐색 시작
        for (int i = 0; i < COMPUTERS.length; i++) {
            if (COMPUTERS[now][i] == 1) {
                dfs(i); // 재귀 호출
            }
        }
    }

    public static void main(String[] args) {
        DFS_네트워크 p = new DFS_네트워크();
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(p.solution(n, computers));
    }
}
