package Programmers.Level_2;

import org.w3c.dom.Node;

// 2023 KAKAO BLIND RECRUITMENT
// 1,2,3 떨어트리기
// Level4
public class PL2_10 {
    public int[] solution(int[][] edges, int[] target) {
        int[] answer = {};

        Node[] nodes = new Node[edges.length];
        


        return answer; // res = { 1, 1, 2, 2, 2, 3, 3 }
    }

    public static void main(String[] args) {
        PL2_10 p = new PL2_10();
        int[][] edges = {{2, 4}, {1, 2}, {6, 8}, {1, 3}, {5, 7}, {2, 5}, {3, 6}, {6, 10}, {6, 9}};
        int[] target = {0, 0, 0, 3, 0, 0, 5, 1, 2, 3};
        System.out.println(p.solution(edges, target));
        // res = { 1, 1, 2, 2, 2, 3, 3 }
    }
}






//import java.util.ArrayList;
//
//class Solution {
//    public int[] solution(int[][] edges, int[] target) {
//
//        // [1] target.length 만큼의 Node배열 생성(1-indexed)
//        Node[] nodes = new Node[target.length + 1];
//        for (int i = 0; i < target.length; i++) {
//            nodes[i + 1] = new Node(i + 1, target[i]);
//        }
//
//        // [2] 부모-자식 연결설정
//        for (int[] edge : edges) {
//            nodes[edge[0]].children.add(nodes[edge[1]]);
//        }
//
//        // [3] leafNode찾기 & node의 road설정
//        ArrayList<Node> leafs = new ArrayList<>();
//
//        for (int idx = 1; idx <= target.length; idx++) {
//            if (nodes[idx].initialize()) {
//                leafs.add(nodes[idx]);
//            }
//        }
//
//        // [4] 숫자가 drop될 순서를 찾음, 도중 burst하는경우 return impossible
//        ArrayList<Node> drops = new ArrayList<>();
//        Node root = nodes[1];
//        while (!checkFinishDrop(leafs)) {
//            Node drop = root.getNextDropLeaf();
//            drops.add(drop);
//            drop.showCnt++;
//            if (drop.isBurst()) {
//                return new int[] { -1 };
//            }
//        }
//
//        /* 주석 부분과 return 문은 같은 기능
//        int[] answer = new int[drops.size()];
//        for(int i = 0 ; i<answer.length ; i++)
//            answer[i] = drops.get(i).nextValue();
//        return answer;
//        */
//
//        return drops.stream().mapToInt(node -> node.nextValue()).toArray();
//    }
//
//    /**
//     * 모든 leafNode에 충분한 횟수의 숫자drop이 이루어졌는지 체크
//     *
//     * @param leafs
//     * @return true:더이상의 drop 필요하지 않음
//     */
//    boolean checkFinishDrop(ArrayList<Node> leafs) {
//        boolean rst = true;
//        for (Node leaf : leafs) {
//            rst &= leaf.isEnough();
//        }
//        return rst;
//    }
//}
//
//class Node {
//
//    int index;
//    int targetValue;
//    int showCnt;
//
//    ArrayList<Node> children;
//
//    Node road = null;
//    Node next = null;
//    boolean isLeaf = false;
//
//    Node(int index, int value) {
//        this.index = index;
//        this.targetValue = value;
//
//        children = new ArrayList<>();
//    }
//
//    /**
//     * 트리노드 연결상태를 기준으로 road노드 구성
//     *
//     * @return isLeaf 리프노드여부 반환
//     */
//    boolean initialize() {
//
//        if (children.size() == 0) {
//            isLeaf = true;
//            return isLeaf;// it's leaf
//        }
//
//        children.sort((a, b) -> a.index - b.index);
//
//        Node temp = null;
//        for (Node child : children) {
//            if (road == null) {
//                road = child;
//                temp = child;
//            } else {
//                temp.next = child;
//                temp = temp.next;
//            }
//        }
//        temp.next = road;
//
//        return isLeaf;// not leaf
//    }
//
//    /**
//     * 숫자의 추가적인 drop이 필요한지 확인
//     *
//     * @return true:충분하다 / false:drop이 더 필요하다
//     */
//    boolean isEnough() {
//        return 3 * showCnt >= targetValue;
//    }
//
//    /**
//     * 너무 많이 drop되었는지 확인
//     *
//     * @return true:너무 많이 drop되었다 / false:적당하다
//     */
//    boolean isBurst() {
//        return showCnt > targetValue;
//    }
//
//    /**
//     * 다음 drop될 최소값 반환
//     *
//     * @return
//     */
//    int nextValue() {
//        showCnt--;
//        int rst = Math.max(1, targetValue - 3 * showCnt);
//        targetValue -= rst;
//        return rst;
//    }
//
//    /**
//     * root를 기준으로 숫자를 drop했을때 숫자가 들어가는 leafNode 반환 및 길의 전환 처리
//     *
//     * @return 숫자가 drop되는 leafNode
//     */
//    Node getNextDropLeaf() {
//
//        if (isLeaf) {
//            return this;
//        } else {
//            Node temp = road.getNextDropLeaf();
//            road = road.next;
//            return temp;
//        }
//    }
//}