import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Pro_CT_65 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        // 선택 점수
        int[] point = {3,2,1,0,1,2,3}; // length = 7 // choices-1

        // 성격 유형 지표 입력
        String[] char_type_list = {"R", "T", "C", "F", "J","M", "A", "N"};
        HashMap<String, Integer> hashMap_type_of_character = new HashMap<>();
        for(String s : char_type_list) {
            hashMap_type_of_character.put(s, hashMap_type_of_character.getOrDefault(s,0));
        }
        hashMap_type_of_character.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });

        // survay 배열의 비동의/동의 나누기


//        Set<String> keyset = hashMap_type_of_character.keySet();
//        for(String key : keyset) {
//            System.out.println(key + " : " + hashMap_type_of_character.get(key));
//        }
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_65 sol = new Pro_CT_65();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(sol.solution(survey, choices));
    }
}
