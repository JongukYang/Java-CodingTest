package Programmers.Algorithm.hash;

import java.util.*;

public class 의상 {
    private static class Solution {
        public int solution(String[][] clothes) {
            int answer = 0;
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < clothes.length; i++) {
                hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 0) + 1);
            }

            int count = 1;
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                count *= entry.getValue() + 1;
            }
            answer += count - 1;
            return answer;
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            String[][] clothes = {
                    {"yellow_hat", "headgear"},
                    {"blue_sunglasses", "eyewear"},
                    {"green_turban", "headgear"}};
            System.out.println(s.solution(clothes));
        }
    }
}
