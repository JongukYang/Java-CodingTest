package Programmers.Algorithm.hash;
import java.util.*;

public class 완주하지못한선수2 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String p : participant) {
            map.put(p, map.getOrDefault(p, 0) +1);
        }

        for(String c : completion) {
            map.put(c, map.getOrDefault(c, 0) -1);
        }

        for(String s : map.keySet()) {
            if(map.get(s) != 0) {
                answer += s;
            }
        }

        return answer;
    }
}