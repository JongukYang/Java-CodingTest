
// char배열과 String클래스의 한 가지 중요한 차이가 있는데, 
// String객체(문자열)는 읽을수만 있을 뿐 내용을 변경할 수 없다는 것이다. 
public class Pro_CT_8 {
    static boolean solution(String s) {
        boolean answer = true;

        s = s.toLowerCase();
        int pcnt = 0;
        int ycnt = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
            if (s.charAt(i) == 'p') {
                pcnt++;
            } else if (s.charAt(i) == 'y') {
                ycnt++;
            }
        }
        if (pcnt == ycnt) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "pPoooyY";
        System.out.println(solution(s));
    }
}

// boolean solution(String s) {

//     return s.replaceAll("[^yY]", "").length() - s.replaceAll("[^pP]", "").length() == 0 ? true : false;
// }