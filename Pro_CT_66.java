import java.util.HashMap;

public class Pro_CT_66 {
    // 문자열 나누기
    public int solution(String s) {
        int answer = 0;
        int cnt = 0;
        int diff = 0;
        char start = s.charAt(0);
        for(int i = 0; i<s.length(); i++) {
            if(cnt == diff) {
                answer++;
                start = s.charAt(i);
            }
            if (start == s.charAt(i)) {
                cnt++;
            }
            else {
                diff++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_66 sol = new Pro_CT_66();
        String s = "abracadabra";
        System.out.println(sol.solution(s));
    }
}
