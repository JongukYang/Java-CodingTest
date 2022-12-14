import java.util.LinkedList;

public class Pro_CT_62 {
    //    명예의 전당
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
//        int day = 0;
        for (int i = 0; i < score.length; i++) {
//          첫 날
            if (linkedList.isEmpty()) {
                linkedList.add(score[i]);
                answer[i] = linkedList.getLast();
            }
            // 다른 날 점수가 더 작은 사람
            else if (score[i] <= linkedList.getLast()) {
                if (linkedList.size() <3) {
                    linkedList.add(score[i]);
                    answer[i] = linkedList.getLast();
                } else {
                    answer[i] = linkedList.getLast();
                }
            }
            // 다른 날 점수가 더 큰 사람
            else if (score[i] > linkedList.getLast()) {
                if(linkedList.getFirst() > score[i]) {
                    linkedList.add(score[i]);
                    answer[i] = linkedList.getLast();
                }
                else if (linkedList.getFirst()+1 > score[i]) {

                }
                else {

                }
            }
            // 점수가 같으면 continue
            else {
                continue;
            }
            if (linkedList.size() > k) {
                linkedList.remove(k);
            }
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int k = 3; // 명예이 전당에 올라가는 개수 -> 차례대로 밀려나간다는 뜻
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        Pro_CT_62 sol = new Pro_CT_62();
        System.out.println(sol.solution(k, score));
    }
}
