import java.util.Arrays;

public class Pro_CT_40 {
//    숫자 문자열과 영단어
//    public int solution(String s) {
//        int answer = 0;
//        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
//        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
//        for(int i = 0; i< number.length; i++) {
//            if (s.contains(number[i])) {
//                // true 이면
////                int startIdx = s.indexOf(number[i]);
////                int endIdx = number[i].length()-1;
////                System.out.println("num = "+ number[i] +" startIdx: "+startIdx+" endIdx: "+endIdx);
//                // 문자열 바꾸기
//                s = s.replace(number[i],num[i]);
////                System.out.println(s);
//            }
//        }
//        answer = Integer.parseInt(s);
//        return answer;
//    }
    public int solution(String s) {
        int answer = 0;
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for(int i = 0; i< number.length; i++) {
            if (s.contains(number[i])) {
                s = s.replace(number[i],num[i]);

            }
        }
        answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_40 sol = new Pro_CT_40();
//        String s = "one4seveneight";
        String s = "123";
        System.out.println(sol.solution(s));
    }
}
