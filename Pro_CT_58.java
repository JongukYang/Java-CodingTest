import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pro_CT_58 {
//    가장 가까운 글자
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        String[] arr = s.split("");
        ArrayList<String> arrayList = new ArrayList<>();

        for(int i =0; i<arr.length; i++) {
            if(arrayList.contains(arr[i])) {
                int idx = arrayList.lastIndexOf(arr[i]);

                arrayList.add(arr[i]);

                int lastidx = arrayList.lastIndexOf(arr[i]);
                answer[i] = lastidx-idx;
            } else {
                arrayList.add(arr[i]);
                answer[i] = -1;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_58 sol = new Pro_CT_58();
        String s = "banana";
        System.out.println(sol.solution(s));
    }
}

//class Solution {
//    public int[] solution(String s) {
//        int[] answer = new int[s.length()];
//
//        HashMap<Character, Integer> map = new HashMap<>();
//        for(int i=0; i<s.length(); i++) {
//            if(!map.containsKey(s.charAt(i))) {
//                answer[i] = -1;
//                map.put(s.charAt(i), i);
//            }else {
//                int before = map.get(s.charAt(i));
//                answer[i] = i - before;
//                map.put(s.charAt(i), i);
//            }
//        }
//        return answer;
//    }
//}

//class Solution {
//    public int[] solution(String s) {
//        int[] answer = new int[s.length()];
//        HashMap<Character,Integer> map = new HashMap<>();
//        for(int i=0; i<s.length();i++){
//            char ch = s.charAt(i);
//            answer[i] = i-map.getOrDefault(ch,i+1);
//            map.put(ch,i);
//        }
//        return answer;
//    }
//}