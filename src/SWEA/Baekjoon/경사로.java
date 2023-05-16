package SWEA.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 경사로 {
    //백준 골드3 경사로 포기!
    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int[] ry = {0, 0, -1, 1};
    private static int[] rx = {-1, 1, 0, 0};
    private static int N, L, answer;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정사각형 map 크기
        L = Integer.parseInt(st.nextToken()); // 경사로의 길이

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] rowArray = new int[N][N];
        int[][] colArray = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rowArray[i][j] = map[i][j]; // 행 기준으로 한 줄 입력
                colArray[i][j] = map[j][i]; // // 열 기준으로 한 줄 입력
            }
        }

        printMap(rowArray, "행 기준 배열");
        printMap(colArray, "열 기준 배열");

        for (int i = 0; i < N; i++) {
            if (calcArray(rowArray, i)) {
                answer++;
            }
            if (calcArray(colArray, i)) {
                answer++;
            }
        }

        System.out.println(answer);

    }

    private static boolean calcArray(int[][] currArray, int idx) {
        printMap(currArray, "arr");

        boolean[] isSlope = new boolean[N]; // 경사로 설치했는지?

        for (int i = 0; i < N - 1; i++) {
            int now = currArray[idx][i];
            int next = currArray[idx][i + 1];
            int heightGap = now - next;

            // 경사가 2 이상 차이나면 실패
            if (heightGap > 1 || heightGap < -1) {
                return false;
            }
            // 다음 경사가 높은 경우
            else if (heightGap == -1) {
                for (int j = 0; j < L; j++) { // 올라가는 경사로를 설치할 수 있는지 확인한다.
                    // 지면의 길이가 2 이하이면 실패 return
                    if (i - j < 0 || isSlope[i - j]) {
                        return false;
                    }
                    if (currArray[idx][i] != currArray[idx][i - j]) {
                        return false;
                    }
                    isSlope[i - j] = true; //경사면 설치
                }
            }
            // 다음 경사가 낮은 경우
            else if (heightGap == 1) {
                for (int j = 1; j <= L; j++) { // 올라가는 경사로를 설치할 수 있는지 확인한다.
                    if (i + j >= N || isSlope[i + j]) {
                        return false;
                    }
                    if (currArray[idx][i] - 1 != currArray[idx][i + j]) {
                        return false;
                    }
                    isSlope[i + j] = true; //경사면 설치
                }
            }
        }

        return true;
    }

    private static void printMap(int[][] currMap, String s) {
        System.out.println(s);
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(currMap[i]));
        }
        System.out.println("#############################");
    }

}
