package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class HashMap_베스트셀러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        }

        // HashMap 출력해보기
        hashMap.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });

        // 가장 많이 팔린 도서의 개수 찾기
        Integer bestselling = Collections.max(hashMap.values());
        System.out.println("bestselling = " + bestselling);

        ArrayList<String> arrayList = new ArrayList<>();

        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) == bestselling) {
                arrayList.add(key);
            }
        }

        System.out.println("arrayList = " + arrayList);

        Collections.sort(arrayList);

        bw.write(arrayList.get(0));

        bw.flush();
    }
}
