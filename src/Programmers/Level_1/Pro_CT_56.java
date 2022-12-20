package Programmers.Level_1;

public class Pro_CT_56 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int leftpos = 10;
        int rightpos = 12;
        int zero = 11;

        for(int i = 0; i<numbers.length; i++) {
            int num = numbers[i];
            if(num==1||num==4||num==7) {
                leftpos = num;
                answer += "L";
            }
            if(num==3||num==6||num==9) {
                rightpos = num;
                answer += "R";
            }
            if(num==2||num==5||num==8||num==0) {
                if(num==0) {
                    num = zero;
                }
                int leftCnt = (Math.abs(num-leftpos)/3) + (Math.abs(num-leftpos)%3);
                int rightCnt = (Math.abs(num-rightpos)/3) + (Math.abs(num-rightpos)%3);
                if(leftCnt == rightCnt) {
                    if(hand.equals("left")) {
                        leftpos = num;
                        answer += "L";
                    } else {
                        rightpos = num;
                        answer += "R";
                    }
                }
                else if(leftCnt > rightCnt) {
                    rightpos = num;
                    answer += "R";
                }
                else {
                    leftpos = num;
                    answer += "L";
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_56 sol = new Pro_CT_56();
        int[] nums = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(sol.solution(nums,hand));
    }
}
