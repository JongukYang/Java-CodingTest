import java.util.ArrayList;
import java.util.Collections;

public class Pro_CT_38 {
    //    문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때,
//    각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
//    예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면
//    각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
    public String[] solution(String[] strings, int n) {
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0; i<strings.length; i++) {
            arrayList.add(strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arrayList);

        String[] answer = new String[arrayList.size()];
        for (int i = 0 ; i<arrayList.size(); i++) {
            answer[i] = arrayList.get(i).substring(1, arrayList.get(i).length());
        }

        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_38 sol = new Pro_CT_38();
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        System.out.println(sol.solution(strings, n));
    }
}
