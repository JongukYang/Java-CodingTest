package Study_CT;

import java.io.*;
import java.util.StringTokenizer;

public class 구간_합_구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 5 3

        int N = Integer.parseInt(st.nextToken()); // 5
        int M = Integer.parseInt(st.nextToken()); // 3

        int[] input = new int[N + 1]; // 누적해서 더한 값을 담을 배열

        st = new StringTokenizer(br.readLine()); // 5 4 3 2 1

        // 배열의 index[0]은 제외하고 [1]부터 시작
        input[1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= N; i++) {
            // 누적합 알고리즘 사용
            // input 배열에 index별로 앞에서 부터 값을 더해서 누적된 값 입력
            input[i] = input[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=M; i++) {
            // 1 3, 2 4, 5 5
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write((input[b]-input[a-1]) + "\n");
        }
        bw.flush();
    }
}
