import java.util.Arrays;
import java.util.Stack;

public class Pro_CT_60 {
    public String solution(String new_id) {
        String answer = "";
        int dotcnt = 0;
        System.out.println(new_id);
        new_id = new_id.toLowerCase().replaceAll("[^a-z,._(-)]", "");

        System.out.println(new_id.toString());
        String[] id = new_id.split("");
        Stack<String> stack = new Stack<>();
        for(int i = 0; i<id.length; i++) {
            if(stack.isEmpty()) {
                stack.push(id[i]);
            }else {
                if(stack.peek().equals(".")) {
                    dotcnt++;
                    if(dotcnt == 1) {
                        stack.pop();
                    } else {
                        dotcnt--;
                        stack.push(id[i]);
                    }
                } else {
                    stack.push(id[i]);
                }
            }
        }
        System.out.println(stack);


        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_60 sol = new Pro_CT_60();
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(sol.solution(new_id));
    }
}
