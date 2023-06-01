package Programmers.Algorithm.hash;

import java.util.*;
public class 완주하지못한선수 {
    private String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            hashMap.put(participant[i], hashMap.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            if (hashMap.containsKey(completion[i])) {
                hashMap.put(completion[i], hashMap.get(completion[i]) - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) != 0) {
                sb.append(key + " ");
            }
        }


        return sb.toString().trim();
    }

    public static void main(String[] args) {
        완주하지못한선수 s = new 완주하지못한선수();
        String[] participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        System.out.println(s.solution(participant, completion));
    }
}