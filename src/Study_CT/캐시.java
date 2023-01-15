package Study_CT;

import java.util.ArrayDeque;

public class 캐시 {

    public static final int HIT = 1;
    public static final int MISS = 5;

    public int solution(int cacheSize, String[] citites) {
        int answer = 0;

        ArrayDeque<String> cache = new ArrayDeque<String>();
        for(String city : citites) {
            city = city.toUpperCase();
            if(cache.contains(city)) {
                answer += HIT;
                cache.remove(city);
                cache.addLast(city);
            }
            else {
                answer += MISS;
                cache.addLast(city);
                if (cache.size() > cacheSize) {
                    cache.removeFirst();
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        캐시 solution = new 캐시();
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        System.out.println(solution.solution(cacheSize, cities));
    }
}
