package Programmers.Algorithm.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 전화번호목록 {
    private boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            hashMap.put(phone_book[i], 0);
        }
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (hashMap.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < phone_book.length; i++) {
            hashSet.add(phone_book[i]);
        }
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (hashSet.contains(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        전화번호목록 p = new 전화번호목록();
        String[] phone_book = new String[]{"119", "97674223", "1195524421"};
        System.out.println(p.solution(phone_book));
    }
}


// 첫 풀이
//package Programmers.Algorithm.hash;
//
//import java.util.Arrays;
//import java.util.HashMap;
//
//public class 전화번호목록 {
//    public boolean solution(String[] phone_book) {
//        boolean answer = true;
//        Arrays.sort(phone_book);
//        System.out.println(Arrays.toString(phone_book));
//        for (int i = 0; i < phone_book.length; i++) {
//            int length = phone_book[i].length();
//            HashMap<String, String> hashMap = new HashMap<>();
//            for (int j = i + 1; j < phone_book.length; j++) {
//                String s = phone_book[j].substring(0, length);
//                hashMap.put(s, phone_book[j]);
//            }
//            if (hashMap.containsKey(phone_book[i])) {
//                return false;
//            }
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        전화번호목록 p = new 전화번호목록();
//        String[] phone_book = new String[]{"119", "97674223", "1195524421"};
//        System.out.println(p.solution(phone_book));
//    }
//}