package Programmers.Level_1;

public class Pro_CT_26 {
    public boolean solution(String s) {
//        문자열 s의 길이가 4 혹은 6이고,
//        숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
//        예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
        //        System.out.println(s.length());
        boolean answer = true;
        if(s.length() == 4 || s.length() == 6) {
            for(int i = 0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(c<'0' || c>'9') {
                    return false;
                }
            }
            answer = true;
        } else {
            return false;
        }

        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_26 sol = new Pro_CT_26();
//        String s = "1234";
        String s = "a234";
        System.out.println(sol.solution(s));
    }
}

// char 안에는 isDigit() 함수로 문자인지 숫자인지 구분해줌
//return (s.length() != 4 && s.length() != 6) || (s.split("[0-9]").length > 0) ? false:true;