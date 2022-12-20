package Programmers.Level_1;

public class Pro_CT_63 {
    // 옹알이
    public int solution(String[] babbling) {
        int answer = 0;
//      String[] babbling= {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
//      조카가 할 수 있는 발음  "aya", "ye", "woo", "ma"
        String[] babyBab = {"aya", "ye", "woo", "ma"};
        String[] cantBab = {"ayaaya", "yeye", "woowoo", "mama"};
        for(int i = 0; i<babbling.length; i++) {
            for(int j = 0; j<babyBab.length; j++) {
                if(babbling[i].contains(babyBab[j])) {
                    if(babyBab[j].equals("aya")) {
                        babbling[i] = babbling[i].replaceAll(babyBab[j], "1");
                    }
                    if(babyBab[j].equals("ye")) {
                        babbling[i] = babbling[i].replaceAll(babyBab[j], "2");
                    }
                    if(babyBab[j].equals("woo")) {
                        babbling[i] = babbling[i].replaceAll(babyBab[j], "3");
                    }
                    if(babyBab[j].equals("ma")) {
                        babbling[i] = babbling[i].replaceAll(babyBab[j], "4");
                    }
                }
            }
        }
        for(int i = 0; i<babbling.length; i++) {
            if(babbling[i].contains("11") || babbling[i].contains("22") || babbling[i].contains("33") || babbling[i].contains("44") || babbling[i].matches(".*[a-zA-Z].*")) {
                continue;
            }
            else {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_63 sol = new Pro_CT_63();
        String[] babbling= {"aya", "yee", "u", "maa"};
        System.out.println(sol.solution(babbling));
    }
}
