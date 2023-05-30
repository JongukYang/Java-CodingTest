package Programmers.Algorithm.hash;

import java.util.*;
public class 폰켓몬 {
    public int solution(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }

        return hashSet.size() > (nums.length / 2) ? nums.length / 2 : hashSet.size();
    }

    public static void main(String[] args) {
        폰켓몬 p = new 폰켓몬();
        int[] nums = new int[]{3, 3, 3, 2, 2, 2};
        System.out.println(p.solution(nums));
    }
}