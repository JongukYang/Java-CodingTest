public class Pro_CT_28 {
    public long solution(int price, int money, int count) {
        long answer = -1;
        if(1> price || price > 2500) return -1;
        if(1>money || money > 1000000000) return -1;
        if(1>count || count > 2500) return -1;

        long total = 0;

        for(int i = 1 ; i<= count; i++) {
            total += (i*price);
        }

//        if (total > money) {
//            answer = total-money;
//        } else {
//            answer = 0;
//        }
//
        return total > money ? total-money : 0;

//        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_28 sol = new Pro_CT_28();
        int price = 3;
        int mondy = 20;
        int count = 4;
        System.out.println(sol.solution(price,mondy, count));
    }
}
//##################################
//public long solution(int price, int money, int count) {
//
//    long answer = money;
//
//    for (int cnt = 0; cnt < count; ++cnt) {
//        answer -= (price * (cnt + 1));
//    }
//
//    return (answer > 0 ? 0 : -answer);
//}

//    public long solution(int price, int money, int count) {
//        long answer = -1;
//        answer = (long)price*count*(count+1)/2 - money;
//        return answer<=0?0:answer;
//    }