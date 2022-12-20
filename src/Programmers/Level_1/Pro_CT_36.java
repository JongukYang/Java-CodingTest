package Programmers.Level_1;

public class Pro_CT_36 {
//    어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
//    예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다.
//    "z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수 solution 작성
    public String solution(String s, int n) {
        String answer = "";
        for(char c : s.toCharArray()) {
            if (c == ' ') {
                answer += c;
            }
            else if (c >= 'a' && c <= 'z') {
                answer += (char)('a' + (c + n - 'a')%26);
            }
            else {
                answer += (char)('A' + (c + n - 'A')%26);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_36 sol = new Pro_CT_36();
        String s = "AB";
        int n = 1;
        System.out.println(sol.solution(s, n));
    }
}
