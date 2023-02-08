package Study_CT;

// 수 정렬하기 3

// Counting Sort - 개수 정렬
// 배열의 사이즈가 작고, 숫자의 범위가 10_000 이하일 때 사용 가능
// 배열에 입력된 동일한 숫자의 개수를 count 해서 배열이 0이 아닌것을
// 순서대로 count 수만큼 반복 출력하는 것

import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class 수_정렬하기3 {
    private static final int MAX = 10_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] cnt = new int[MAX + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            cnt[x]++;
        }

        for (int i = 0; i <= MAX; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
    }
}

