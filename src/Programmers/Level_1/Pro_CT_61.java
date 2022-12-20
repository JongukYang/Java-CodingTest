package Programmers.Level_1;

import java.util.HashMap;

public class Pro_CT_61 {
//    숫자 짝꿍
//    StringBuilder를 사용해서 int[] 과 함께 사용해 풀어보기
    public String solution(String X, String Y) {
        String answer = "";
        HashMap<String, Integer> XhashMap = new HashMap<>();
        HashMap<String, Integer> YhashMap = new HashMap<>();
        for(String key : X.split("")) {
            XhashMap.put(key, XhashMap.getOrDefault(key, 0)+1);
        }
        for(String key : Y.split("")) {
            YhashMap.put(key, YhashMap.getOrDefault(key, 0)+1);
        }

        StringBuilder sb = new StringBuilder();
        for(String key : XhashMap.keySet()) {
            if(YhashMap.containsKey(key)) {
                for(int i = 0; i<Math.min(XhashMap.get(key), YhashMap.get(key)); i++) {
                    sb.append(key);
                }
            }
        }
        answer = sb.reverse().toString();
        if(answer.equals("")) {
            return "-1";
        } else if (answer.startsWith("0")) {
            return "0";
        } else {
            return answer;
        }
//        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_61 sol = new Pro_CT_61();
        String X = "12321";
        String Y = "42531";
        System.out.println(sol.solution(X,Y));
    }
}
