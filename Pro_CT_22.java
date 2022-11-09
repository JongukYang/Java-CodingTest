public class Pro_CT_22 {
    public String solution(String s) {
        String answer = "";
        int n = 0;

        if(s.length() % 2 != 0) {
            n = (int)(s.length()/2) + (int)(s.length()%2);
            answer = s.substring(n-1, n);
        }
        else {
            n = (s.length()/2);
            answer = s.substring(n-1, n+1);
        }
        return answer;
//        return word.substring((word.length()-1) / 2, word.length()/2 + 1);
    }

    public static void main(String[] args) {
        Pro_CT_22 sol = new Pro_CT_22();
        String s = "bcde";
        System.out.println(sol.solution(s));
    }
}
//코테 23번 다른데 풀었음
