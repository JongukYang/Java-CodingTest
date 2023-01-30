package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 구간 합 구하기 5
public class BJ_CT_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 4
        int M = Integer.parseInt(st.nextToken()); // 3

        int[][] squared = new int[N + 1][N + 1]; // 좌표를 통해 사각형으로 만들어진 누적 합 배열

        // 좌표를 통해 사각형으로 만들어진 누적 합 배열
        // squared[i][j] = (1,1)에서 (i,j)까지의 합
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                // (왼쪽← 값) + (위에↑ 값) - (↖중복되는 대각선 값) + (input 값)
                squared[i][j] = squared[i - 1][j] + squared[i][j - 1] - squared[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i <= N; i++) {
            System.out.println(Arrays.toString(squared[i]));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // 사각형에서 해당하지 않는 부분 차감 + 공통해서 빼는 부분 더하기
            bw.write(squared[x2][y2] - squared[x2][y1 - 1] - squared[x1 - 1][y2] + squared[x1 - 1][y1 - 1] + "\n");
        }
        bw.flush();
    }
}

//// 구간 합 구하기 5
//public class BJ_CT_3 {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken()); // 4
//        int M = Integer.parseInt(st.nextToken()); // 3
//
//        int[][] input = new int[N + 1][N + 1]; // input 배열
//        int[][] squared = new int[N + 1][N + 1]; // 좌표를 통해 사각형으로 만들어진 누적 합 배열
//
//        // input 배열 입력
//        for (int i = 1; i <= N; i++) { // N = 4
//            st = new StringTokenizer(br.readLine());
//            for (int j = 1; j <= N; j++) {
//                input[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        for (int i = 0; i < input.length; i++) {
//            System.out.println(Arrays.toString(input[i]));
//        }
//
//        // 좌표를 통해 사각형으로 만들어진 누적 합 배열
//        // squared[i][j] = (1,1)에서 (i,j)까지의 합
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                // (왼쪽← 값) + (위에↑ 값) - (↖중복되는 대각선 값) + (인풋값)
//                squared[i][j] = squared[i - 1][j] + squared[i][j - 1] - squared[i - 1][j - 1] + input[i][j];
//            }
//        }
//
//        for (int i = 0; i < squared.length; i++) {
//            System.out.println(Arrays.toString(squared[i]));
//        }
////
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int x1 = Integer.parseInt(st.nextToken());
//            int y1 = Integer.parseInt(st.nextToken());
//            int x2 = Integer.parseInt(st.nextToken());
//            int y2 = Integer.parseInt(st.nextToken());
//
//            bw.write(squared[x2][y2] - squared[x2][y1 - 1] - squared[x1 - 1][y2] + squared[x1 - 1][y1 - 1] + "\n");
//        }
//
//        bw.flush();
//
//    }
//}


