package Programmers.Level_1;

public class Pro_CT_16 {
    public String solution(String[] seoul) {
        String answer = "";
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_16 sol = new Pro_CT_16();
        String[] seoul = {"Jane", "Kim"};
        System.out.println(sol.solution(seoul));
    }
}

//import java.util.Arrays;
//
//public class FindKim {
//    public String findKim(String[] seoul){
//        //x에 김서방의 위치를 저장하세요.
//        int x = Arrays.asList(seoul).indexOf("Kim");
//
//        return "김서방은 "+ x + "에 있다";
//    }
//
//    // 실행을 위한 테스트코드입니다.
//    public static void main(String[] args) {
//        FindKim kim = new FindKim();
//        String[] names = {"Queen", "Tod","Kim"};
//        System.out.println(kim.findKim(names));
//    }
//}