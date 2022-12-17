import java.util.ArrayList;
import java.util.Arrays;

public class Pro_CT_64 {
    // 기사단원의 무기
    public int solution(int number, int limit, int power) {
        // 각 기사는 자신의 기사 번호의 약수 개수에 해당하는 공격력을 가진 무기 구매
        // 단, 이웃나라와의 협약에 의해 공격력의 제한수치를 정하고,
        // 제한수치보다 큰 공격력을 가진 무기를 구매해야 하는 기사는
        // 협약기관에서 정한 공격력을 가지는 무기를 구매해야 합니다.
        int answer = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 1; i<=number; i++) {
            int factorCnt = 0;
            for(int j = 1; j<=i; j++) {
                if(i%j == 0) {
                    factorCnt++;
                }
            }
            arrayList.add(factorCnt);
        }

        for(int i : arrayList) {
            System.out.println(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_64 sol = new Pro_CT_64();
        int number = 10; // 기사단원의 수
        int limit = 3; // 공격력의 제한 수치
        int power = 2; // 제한수치를 초과한 기사가 사용할 무기의 공격력
        System.out.println(sol.solution(number,limit,power));
//        입출력 예 #2
//        1부터 10까지의 약수의 개수는 순서대로 [1, 2, 2, 3, 2, 4, 2, 4, 3, 4]개입니다.
//        공격력의 제한수치가 3이기 때문에, 6, 8, 10번 기사는 공격력이 2인 무기를 구매합니다.
//        따라서 해당 수들의 합인 21을 return 합니다.
    }
}
