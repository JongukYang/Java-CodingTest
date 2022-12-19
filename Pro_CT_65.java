import java.util.HashMap;

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

//        hashMap_type_of_character.forEach((key, value) -> {
//            System.out.println(key + " : " + value);
//        });
//        System.out.println("##################################");

        // survay 배열의 비동의/동의 나누기
        for(int i = 0; i<survey.length; i++) {
            String[] sarr = survey[i].split("");
            if(choices[i] > 4) {
                hashMap_type_of_character.put(sarr[1], hashMap_type_of_character.getOrDefault(sarr[1], 0) + point[choices[i]-1]);
            } else if(choices[i] < 4) {
                hashMap_type_of_character.put(sarr[0], hashMap_type_of_character.getOrDefault(sarr[0], 0) + point[choices[i]-1]);
            }
        }

//        hashMap_type_of_character.forEach((key, value) -> {
//            System.out.println(key + " : " + value);
//        });
//        System.out.println("##################################");

        // 성격 유형 분석 -> 같을 경우 알파벳 순으로 빠른거 고르기
        for(int i = 0; i<7; i+=2) {
            if(hashMap_type_of_character.get(char_type_list[i]) > hashMap_type_of_character.get(char_type_list[i+1])) {
                answer += char_type_list[i];
            } else if (hashMap_type_of_character.get(char_type_list[i]) < hashMap_type_of_character.get(char_type_list[i+1])) {
                answer += char_type_list[i+1];
            } else if(hashMap_type_of_character.get(char_type_list[i]) == hashMap_type_of_character.get(char_type_list[i+1])) {
                answer += (char_type_list[i].compareTo(char_type_list[i+1]) < 0) ? char_type_list[i] : char_type_list[i+1];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_65 sol = new Pro_CT_65();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(sol.solution(survey, choices));
    }
}


// HashMap 반복문 예시
//        hashMap_type_of_character.forEach((key, value) -> {
//                System.out.println(key + " : " + value);
//                });

//        Set<String> keyset = hashMap_type_of_character.keySet();
//        for(String key : keyset) {
//            System.out.println(key.getClass().getName());
//            System.out.println(key + " : " + hashMap_type_of_character.get(key));
//        }