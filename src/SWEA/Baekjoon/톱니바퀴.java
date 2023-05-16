//package SWEA.Baekjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class 톱니바퀴 {
//    // 백준 골드5 톱니바퀴
//    private static String[] sawWheel;
//    private static char[][] middleSaw;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        middleSaw = new char[4][2];
//        sawWheel = new String[4];
//        for (int i = 0; i < 4; i++) {
//            sawWheel[i] = br.readLine();
//        }
//
//        int rotateCnt = Integer.parseInt(br.readLine());
//        int[][] rotate = new int[rotateCnt][2];
//
//        for (int i = 0; i < rotateCnt; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < 2; j++) {
//                rotate[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        // 탐색 시작
//        for (int i = 0; i < rotateCnt; i++) {
//            searchMiddle(); // 중간인 2, 6 idx 값 저장하기
//
//            int mainSaw = rotate[i][0];
//            char mainRight = middleSaw[mainSaw][0];
//            char mainLeft = middleSaw[mainSaw][1];
//
//            int[] cnt = new int[4];
//
//            if (mainSaw == 1) {
//                if (mainRight != middleSaw[mainSaw + 1 -1][1]) {
//                    cnt[mainSaw]++;
//                    cnt[mainSaw + 1]++;
//                }
//                if (middleSaw[mainSaw + 1][0] != middleSaw[mainSaw + 2][1]) {
//                    cnt[mainSaw + 2]++;
//                }
//                if(middleSaw[mainSaw + 2][0] == middleSaw[mainSaw + 3][0])
//            } else if (mainSaw == 2) {
//
//            } else if (mainSaw == 3) {
//
//            } else if (mainSaw == 4) {
//                if (mainLeft == middleSaw[mainSaw - 1][0]) {
//
//                }
//            }
//        }
//
//
//    }
//
//    // index 2, 6만 체크
//    private static void reverseRotate(int main) {
//        // 반시계방향 회전
//        String temp = sawWheel[main].substring(0, 1);
//        sawWheel[main] = sawWheel[main].substring(1) + temp;
//        System.out.println(sawWheel[main]);
//    }
//
//    private static void clockwiseRotate(int main) {
//        // 시계방향 회전
//        String temp = sawWheel[main].substring(0, 1);
//        sawWheel[main] = sawWheel[main].substring(1) + temp;
//        System.out.println(sawWheel[main]);
//    }
//
//    private static void searchMiddle() {
//        for (int i = 0; i < 4; i++) {
//            middleSaw[i][0] = sawWheel[i].charAt(2); // right
//            middleSaw[i][1] = sawWheel[i].charAt(6); // left
//        }
//    }
//
//}
