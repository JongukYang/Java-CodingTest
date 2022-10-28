import java.util.Stack;

public class Pro_CT_1 {
    public static void main(String[] args) {
        Solution();
    }

    class Solution {
        public int solution(int[] ingredient) {
            int answer = 0;
            int bread_cnt = 0;
            int i = 0;

            Stack<Integer> stack = new Stack<>();
            // stack.push(ingredient[i]);
            // System.out.println(stack);

            while (true) {
                if (i == ingredient.length + 1) {
                    break;
                }
                if (ingredient[i] == 1) {
                    // bread_cnt++;
                    // if(ingredient[i+1] == 2 && ingredient[i+2] == 3 && ingredient[i+3] == 1) {
                    // answer++;
                    // if(bread_cnt == 2) {
                    // answer++;
                    // }
                    // break;
                    // }
                    // else {
                    // break;
                    // }
                }
                stack.push(ingredient[i]);
                System.out.println(stack);
                i++;
            }
            return answer;
            // System.out.println(answer);
        }

    }
}
