import java.util.*;
public class Pro_CT_5 {
    public static int solution(int n) {
        int answer = 0;
        // n = 123
        String s = Integer.toString(n);
        for(int i = 0; i<s.length(); i++) {
            answer += Integer.parseInt(s.substring(i, i+1));
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 123;
        System.out.println(solution(n));
        
        // String s = "hello";
        // System.out.println(s[0]);
    }
}
