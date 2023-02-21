package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class HashMap_회사에_있는_사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 4

        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String val = st.nextToken();

            if (hashMap.containsKey(name)) {
                hashMap.remove(name);
            } else {
                hashMap.put(name, val);
            }
        }

        ArrayList<String> arrayList = new ArrayList<>();
        hashMap.forEach((key, Value) -> {
//            System.out.println(key + " " + Value);
            arrayList.add(key);
        });

        Collections.sort(arrayList, Collections.reverseOrder()); // 내림차순 정렬
        System.out.println(arrayList);

        for (String item : arrayList) {
            bw.write(item + "\n");
        }

        bw.flush();
    }
}


// 예제 입력
//4
//Baha enter
//Askar enter
//Baha leave
//Artem enter

// 예제 출력 -> 조건 : 현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력한다.
//Askar
//Artem