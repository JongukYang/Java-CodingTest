package Programmers.Algorithm.hash;

import java.util.HashMap;

public class 전화번호목록2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        // Arrays.sort(phone_book);

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], 0);
        }

        for (int i = 0; i < phone_book.length; i++) {
            System.out.println("#####################");
            System.out.println("phone_book = " + phone_book[i]);
            for (int j = 1; j < phone_book[i].length(); j++) {
                String s = phone_book[i].substring(0, j);
                System.out.println("s = " + s);
                if (map.containsKey(s)) {
                    return false;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        전화번호목록2 p = new 전화번호목록2();
        String[] phone_book = new String[]{"119", "97674223", "1195524421"};
//        String[] phone_book = new String[]{"123", "456", "789"};

        System.out.println(p.solution(phone_book));
    }
}
