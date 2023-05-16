package Programmers.Level_3;
// LV3 - DFS - 네트워크
public class DFS_네트워크 {
    private static int[][] computer;
    private static boolean[] visited;

    public int solution(int n, int[][] computers) {
        computer = computers;
        visited = new boolean[n]; // 처음 시작 컴퓨터 방문처리

        int answer = 0; // 네트워크의 개수 세기

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                // 처음 시작 또는 연결되어 있지 않다면 dfs 수행
                dfs(i);
                answer++; // 처음 시작한 컴퓨터와 연결된 네트워크 1가지 + 다른 네트워크 개수
            }
        }

        return answer;
    }
    private static void dfs(int now) {
        if (visited[now] == true) {
            return;
        }

        visited[now] = true;

        for(int i = 0; i< computer.length; i++) {
            if (computer[now][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Study_CT.AnswerCode.DFS_네트워크 p = new Study_CT.AnswerCode.DFS_네트워크();
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(p.solution(n, computers));
    }
}
