package SWEA.Baekjoon;
import java.util.*;
import java.io.*;

public class DP_퇴사 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N까지만 일 함

        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] DP = new int[N+2];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken()); // 상담 하는데 걸리는 일 수
            P[i] = Integer.parseInt(st.nextToken()); // 돈
        }

        for(int i = N; i > 0; i--) {
            int next = i + T[i]; // 다음 날짜

            if(next > N + 1) { // 일할 수 있는 날짜를 넘어가는 경우
                // 일을 하지 못하므로 바로 다음 DP값(더 앞쪽의 날짜)로 설정
                DP[i] = DP[i + 1];
            } else { // 일할 수 있는 날짜인 경우
                // 1. 일하지 않았을 때(DP[i + 1])
                // 2. 일 했을 때 총 벌 수 있는 금액(P[i] + DP[next])
                // 위 두 경우 중 더 큰 값을 DP에 넣어준다.
                DP[i] = Math.max(DP[i + 1], P[i] + DP[next]);
            }
        }

        System.out.println(DP[1]);
    }

}