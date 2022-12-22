package Baekjoon;

// 이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다.
// 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
// 조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고,
// 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때,
// 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.

import java.util.Scanner;

public class BJ_CT_2 {

    public static void main(String[] args) {
        BJ_CT_2 sol = new BJ_CT_2();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int testcase = 0; testcase < T; testcase++) {
            // 0 0 13 40 0 37
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();

            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
            System.out.println(sol.solution(x1, y1, r1, x2, y2, r2));
        }
    }

    public int solution(int x1, int y1, int r1, int x2, int y2, int r2) {
        // 조규현의 좌표 (x1, y1) , 백승환의 좌표 (x2, y2)
        // -> (0,0) : 13 / (40,0) : 37
        // 조규현이 계산한 류재명과의 거리 r1 -> 13
        // 백승현이 계산한 류재명과의 거리 r2 -> 37
        int between_distance = (int)Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

        // 중심점이 같고 반지름이 같은 경우
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }
        // 중심점간의 거리가 두 원의 반지름 길이의 합보다 클 때
        else if (between_distance > Math.pow(r1 + r2, 2)) {
            return 0;
        }
        // 두 원 중 하나가 작고 원 안에서 내접하지 않을 때
        else if (between_distance < Math.pow(r1 - r2,2)) {
            return 0;
        }
        // 두 원이 외접할 때
        else if (between_distance == Math.pow(r1 + r2, 2)) {
            return 1;
        }
        // 두 원이 내접할 때
        else if (between_distance == Math.pow(r1 - r2, 2)) {
            return 1;
        }
        // 중심점간의 거리가 두 원의 반지름 길이의 합보다 작을 때 2개의 접점 생김
        else {
            return 2;
        }
    }

}
