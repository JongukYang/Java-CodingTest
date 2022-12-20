package Programmers.Level_1;

// 문자열 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로
public class Pro_CT_33 {
    public String solution(String s) {
        String answer = "";
        String[] splitStr = s.split("");
        int blankIdx = 0;

        for (int i = 0; i < splitStr.length; i++) {
            if(splitStr[i].equals(" ")) {
                blankIdx = 0;
            }
            else if (blankIdx % 2 == 0) {
                splitStr[i] = splitStr[i].toUpperCase();
                blankIdx++;
            }
            else if (blankIdx %2 != 0) {
                splitStr[i] = splitStr[i].toLowerCase();
                blankIdx++;
            }
            answer += splitStr[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_33 sol = new Pro_CT_33();
        String s = "try hello world";
        System.out.println(sol.solution(s));
    }
}

//########################################
//public String solution(String s) {
//    String answer = "";
//
//    StringBuilder sb = new StringBuilder();
//
//    String a = "";
//    int tmpIdx = 0;
//
//    for(int i = 0; i < s.length(); i++) {
//
//        if(s.charAt(i) == ' ') {
//            sb.append(a).append(s.charAt(i));
//            tmpIdx = 0;
//        } else {
//            if(tmpIdx%2 == 0) {
//                sb.append(a).append(String.valueOf(s.toUpperCase().charAt(i)));
//            } else {
//                sb.append(a).append(String.valueOf(s.toLowerCase().charAt(i)));
//            }
//            tmpIdx++;
//        }
//    }
//    answer = sb.toString();
//
//    return answer;
//}
