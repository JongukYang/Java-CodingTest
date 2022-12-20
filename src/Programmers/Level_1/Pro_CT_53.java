package Programmers.Level_1;

public class Pro_CT_53 {
    public String solution(int[] food) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        for(int i =1;i<food.length;i++) {
            int foodfight = food[i]/2;
            for(int j =0; j<foodfight;j++) {
                sb.append(i);
            }
        }

        answer = sb.toString() + "0" + sb.reverse().toString();

        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_53 sol = new Pro_CT_53();
        int[] food = {1,3,4,6};
        System.out.println(sol.solution(food));
    }
//    1223330333221
}
