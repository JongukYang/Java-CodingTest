package A_기업코테;

import java.util.Arrays;

public class naver {
    public int[] solution(int x, int y, String[] pays) {
        int[] answer = new int[4];
        int totalCharge = 0; // 전체 충전 금액
        int totalReturn = 0; // 전체 출금 금액
        int moneyPoint = 0; // 충전되고 남아있는 금액
        int mPoint = 0; // 마일리지
        int[] mPointReturn = new int[30 + y]; // 마일리지 적립 날짜별 금액

        for (int i = 0; i < pays.length; i++) {
            String[] s = pays[i].split(" ");

            // 출금
            if (s[2].startsWith("-")) {
                int money = Integer.parseInt(s[2].substring(1, s[2].length()));
                System.out.println("출금 수행 " + pays[i]+ " "  + money);
                // 출금 금액이 가진 moneyPoint 보다 클 때
                if (money > moneyPoint) {
                    totalReturn += moneyPoint;
                    moneyPoint = 0;
                }
                // 출금 금액이 moneyPoint 작을 때
                else if (money < moneyPoint) {
                    totalReturn += money;
                    moneyPoint -= money;
                }
                // 같을 때
                else {
                    totalReturn += money;
                    moneyPoint = 0;
                }
            }
            // 구매
            else {
                int money = Integer.parseInt(s[2]);
                int day = Integer.parseInt(s[0]);
                System.out.println("구매 수행 " + pays[i]);
                System.out.println("day: " + day + " money: " + money);

                // 마일리지 적립
                mPointReturn[day + y] += (int) (money * 0.1);
                mPoint += mPointReturn[day];
                mPointReturn[day] = 0;
                System.out.println(Arrays.toString(mPointReturn));

                // 구매할 때 moneyPoint가 부족할 때
                if (moneyPoint + mPoint < money) {
                    int temp = money;
                    temp -= (mPoint + moneyPoint);
                    // 얼만큼 부족한지 계산 후 충전
                    if (temp % x > 0) {
                        totalCharge += x;
                        moneyPoint += x;
                    }
                    totalCharge += x * (int)(temp / x);
                    moneyPoint += x * (int)(temp / x);

                    // 구매 계산하기
                    System.out.println("mPoint : "+mPoint);
                    money -= mPoint;
                    System.out.println("money : "+money);
                    mPoint = 0; // 부족했었으니까 무조건 0으로
                    moneyPoint -= money; // 마일리지를 사용하고 나서 계산
                }
                // 구매 금액이 딱 맞아 떨어지는 경우
                else if (moneyPoint + mPoint == money) {
                    System.out.println("mPoint : "+mPoint);
                    money -= mPoint;
                    System.out.println("money : "+money);
                    mPoint = 0; // 무조건 먼저 다 쓰기
                    moneyPoint -= money;
                }
                // 구매 금액이 마일리지로도 가능할 때
                else if (money == mPoint) {
                    System.out.println("mPoint : "+mPoint);
                    mPoint -= money;
                    System.out.println("money : "+money);
                }
                // 구매 금액이 여유로울 때
                else {
                    System.out.println("mPoint : "+mPoint);
                    money -= mPoint;
                    System.out.println("money : "+money);
                    mPoint = 0; // 무조건 먼저 다 쓰기
                    moneyPoint -= money;
                }
            }
            System.out.println("전체 충전 금액 : " + totalCharge);
            System.out.println("전체 출금 금액 : " + totalReturn);
            System.out.println("현재 남은 금액 : " + moneyPoint);
            System.out.println("현재 남은 마일리지 : " + mPoint);
            System.out.println("#################################");
        }
        for (int i = 0; i < mPointReturn.length; i++) {
            mPoint += mPointReturn[i];
        }
        System.out.println("전체 충전 금액 : " + totalCharge);
        System.out.println("전체 출금 금액 : " + totalReturn);
        System.out.println("현재 남은 금액 : " + moneyPoint);
        System.out.println("현재 남은 마일리지 : " + mPoint);

        return answer;
    }

    public static void main(String[] args) {
        String[] pays = {"2 0 30000", "2 0 -50000", "5 0 15000", "5 0 180000", "10 0 -30000"};
        // 300000, 78000, 0, 19500
        int x = 100000;
        int y = 3;
        naver n = new naver();
        System.out.println(n.solution(x, y, pays));
    }
}
