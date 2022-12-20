import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Pro_CT_1 {
    // 햄버거 만들기
    public int solution(int[] ingredient) {
        int answer = 0;
        // 삭제 속도 빠른 linkedList
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for(int i = 0; i<ingredient.length; i++) {
            linkedList.add(ingredient[i]);
            if(linkedList.size() > 3
                    && linkedList.get(linkedList.size()-4) == 1
                    && linkedList.get(linkedList.size()-3) == 2
                    && linkedList.get(linkedList.size()-2) == 3
                    && linkedList.get(linkedList.size()-1) == 1) {
                answer++;
                for(int j = 0; j<4; j++) {
                    linkedList.remove(linkedList.size()-1);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_1 sol = new Pro_CT_1();
        int[] ingredient = { 2, 1, 1, 2, 3, 1, 2, 3, 1 };
        System.out.println(sol.solution(ingredient));

    }

}