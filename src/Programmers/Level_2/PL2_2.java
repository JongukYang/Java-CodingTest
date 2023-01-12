package Programmers.Level_2;

import java.util.LinkedList;
import java.util.Locale;

//[1차] 캐시
// 순서가 보장된 LinkedHashSet 도 있음
// Queue로 풀이 방법?
//
public class PL2_2 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0; // 캐시 hit, miss 누적 값
        LinkedList<String> linkedList = new LinkedList<String>(); // queue 구현체
        for (int i = 0; i < cities.length; i++) {
            // 캐시에 들어갈 값 소문자화 시키기
            String lowercaseCity = cities[i].toLowerCase(Locale.ROOT);
            // 캐시 사이즈가 0인 경우
            if(cacheSize == 0) {
                return 5*cities.length;
            }
            // 캐시에 값이 있는 경우 hit
            if (linkedList.remove(lowercaseCity)) {
                linkedList.add(lowercaseCity);
                answer += 1;
            }
            // 캐시에 값이 없는 경우 miss
            else {
                if(linkedList.size() < cacheSize) {
                    linkedList.add(lowercaseCity);
                    answer += 5;
                    continue;
                }
                else if (linkedList.size() == cacheSize) {
                    linkedList.removeFirst();
                    linkedList.add(lowercaseCity);
                    answer += 5;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PL2_2 solution = new PL2_2();
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        System.out.println(solution.solution(cacheSize, cities));
    }
}
