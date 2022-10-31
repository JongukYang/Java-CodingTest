package Level1;
import java.util.Stack;

public class Pro_CT_1 {

    public static int solution(int[] ingredient) {
        int answer = 0;
        int bread_cnt = 0;
        int i = 0;

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        // stack.push(ingredient[i]);
        // System.out.println(stack);

        while (true) {
            // System.out.println(ingredient.length);
            if (!(ingredient[i] == 1)) {
                stack.push(ingredient[i]);
                System.out.println(stack);
                i++;
            }
            if (ingredient[i] == 1) {
                stack.push(ingredient[i]);
                System.out.println(stack);
                i++;
            }
            if (i == ingredient.length) {
                break;
            }
        }

        return answer;
        // System.out.println(answer);
    }

    public static void main(String[] args) {
        int[] ingredient = { 2, 1, 1, 2, 3, 1, 2, 3, 1 };
        System.out.println("Solution : " + solution(ingredient));
    }

}