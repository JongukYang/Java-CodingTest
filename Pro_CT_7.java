import java.net.Socket;

public class Pro_CT_7 {
    public static int[] solution(long n) {
        int[] answer = {};
        // 문자로 바꾸고 하나씩 끊고 하나씩 정수로 변환해 넣어주기
        String s = Long.toString(n);
        
        for(int i=0; i<s.length(); i++) {
            answer[s.length()-1] = Integer.parseInt(s.substring(s.length()-2, s.length()-1));
            // answer[i] = Long.parseLong(s.substring(i, i-1));
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 12345;
        System.out.println(solution(n));
    }
}
