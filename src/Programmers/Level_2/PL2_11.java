package Programmers.Level_2;
//이진 변환 반복하기
public class PL2_11 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int changeBinaryCnt = 0;
        int zeroCnt = 0;

        String removeZeroStr;

        while (s.length() != 1) {
            System.out.println("#####################################");
            System.out.println("현재 s : " + s);
            // s에서 0 제거
            removeZeroStr = s.replaceAll("0", "");
            System.out.println("0이 제거된 s : " + removeZeroStr);

            // 제거된 0의 개수
            zeroCnt += s.length() - removeZeroStr.length();

            // 이진 변환
            String binary = Integer.toBinaryString(removeZeroStr.length());
            System.out.println("이진 변환 : "+binary);
            changeBinaryCnt++;

            System.out.println("zeroCnt = " + zeroCnt);
            System.out.println("changeBinaryCnt = " + changeBinaryCnt);

            s = binary;
            System.out.println("이진변환 후 s = " + s);
        }

        answer[0] = changeBinaryCnt;
        answer[1] = zeroCnt;

        return answer;
    }

    public static void main(String[] args) {
        PL2_11 p = new PL2_11();
        String s = "110010101001";
        System.out.println(p.solution(s));
    }
}
