package SWEA.D2;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class 백만장자 {

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("/Users/jongukyang/GitHub-LocalRepo/Java-CodingTest/src/SWEA/D2/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T;
        T=sc.nextInt();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt(); // 날짜
            int[] price = new int[N]; // 날짜별 가격
            for (int i = 0; i < N; i++) {
                price[i] = sc.nextInt();
            }

            long totalBenefit = 0;
            int maxSalePrice = price[N - 1];

            for (int i = N-2; i >= 0; i--) {
                if (maxSalePrice > price[i]) {
                    totalBenefit += maxSalePrice - price[i];
                } else {
                    maxSalePrice = price[i];
                }
            }
            bw.append("#"+test_case+" "+totalBenefit+"\n");
        }
        bw.flush();
        bw.close();
        sc.close();
    }

}
