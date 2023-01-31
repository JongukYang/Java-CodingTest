package Programmers.Level_2;

import java.util.HashMap;
// 영어 끝말잇기
public class PL2_16 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!hashMap.containsKey(words[i])) {
                if (hashMap.size() > 0 && !(words[i].charAt(0) == words[i - 1].charAt(words[i - 1].length() - 1))) {
                    int who = ((i+1) % n);
                    int when = ((i+1) / n);
                    if (who > 0) {
                        answer[0] = who;
                        answer[1] = when + 1;
                    } else {
                        answer[0] = n;
                        answer[1] = when;
                    }
                    break;
                }
                hashMap.put(words[i], hashMap.getOrDefault(words[i], 0) + 1);
            } else {
                int who = ((i+1) % n);
                int when = ((i+1) / n);
                if (who > 0) {
                    answer[0] = who;
                    answer[1] = when + 1;
                } else {
                    answer[0] = n;
                    answer[1] = when;
                }
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        PL2_16 p = new PL2_16();
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(p.solution(n, words));
    }
}
