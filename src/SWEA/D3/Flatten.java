package SWEA.D3;

import java.util.Scanner;
import java.io.FileInputStream;
public class Flatten
{
    private static int min, max;
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("/Users/jongukyang/GitHub-LocalRepo/Java-CodingTest/src/SWEA/D3/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int dump = sc.nextInt(); // 옮기기 가능 횟수
            int[] boxes = new int[100]; // 항상 가로는 100개
            for (int i = 0; i < boxes.length; i++) {
                boxes[i] = sc.nextInt();
            }

            int answer = 0;

            while (dump >= 0) {
                dump--;

                getMinMax(boxes);

                answer = max - min;

                if (answer == 0) {
                    break;
                }
                // 최대 - 1
                for (int i = 0; i < boxes.length; i++) {
                    if (boxes[i] == max) {
                        boxes[i]--;
                        break;
                    }
                }
                // 최소 + 1
                for (int i = 0; i < boxes.length; i++) {
                    if (boxes[i] == min) {
                        boxes[i]++;
                        break;
                    }
                }
                // 1회 완료

            }
            System.out.println("#" + test_case + " " + answer);
        }

    }
    private static void getMinMax(int[] boxes) {
        max = Integer.MIN_VALUE; // 최대값
        min = Integer.MAX_VALUE; // 최소값

        // 최대값 최소값을 찾기
        for (int i = 0; i < boxes.length; i++) {
            if (min >= boxes[i]) {
                min = boxes[i];
            } else if(max <= boxes[i]) {
                max = boxes[i];
            }
        }
    }
}