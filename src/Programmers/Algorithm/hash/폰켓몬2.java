package Programmers.Algorithm.hash;

import java.util.*;
public class 폰켓몬2 {
    public int solution(int[] nums) {
        // 중복 허용
        int N = nums.length;
        int n = N/2;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if(map.size() < n) {
            return map.size();
        } else {
            return n;
        }
    }
}