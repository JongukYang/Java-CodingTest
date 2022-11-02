public class Pro_CT_17 {
    public String solution(String phone_number) {
        String answer = "";
        for(int i = 0; i< phone_number.length(); i++){
            if(i<phone_number.length()-4) {
                answer += "*";
            } else {
                answer += phone_number.charAt(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_17 sol = new Pro_CT_17();
        String p = "01033334444";
        System.out.println(sol.solution(p));
    }
}
// 오늘은 MOD 하기 때문에 쉬어가는날

//for (int i = 0; i < phone_number.length() - 4; i++)
//        answer += "*";
//
//        answer += phone_number.substring(phone_number.length() - 4);

//class Solution {
//    public String solution(String phone_number) {
//        char[] ch = phone_number.toCharArray();
//        for(int i = 0; i < ch.length - 4; i ++){
//            ch[i] = '*';
//        }
//        return String.valueOf(ch);
//    }
//}

//class Solution {
//    public String solution(String phone_number) {
//        return phone_number.replaceAll(".(?=.{4})", "*");
//    }
//}
