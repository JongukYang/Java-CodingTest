package Programmers.Algorithm.hash;

import java.util.*;
public class 베스트앨범 {
    static class Solution {
        private static class Node {
            int idx;
            String genre;
            int play;

            public Node(int idx, String genre, int play) {
                this.idx = idx;
                this.genre = genre;
                this.play = play;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "idx=" + idx +
                        ", genre='" + genre + '\'' +
                        ", play=" + play +
                        '}';
            }
        }

        public int[] solution(String[] genres, int[] plays) {
            // 가장 많이 들은 장르 선정
            HashMap<String, Integer> hashMap = new HashMap<>();
            HashMap<Integer, HashMap<String, Integer>> idxMap = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                hashMap.put(genres[i], hashMap.getOrDefault(genres[i], 0) + plays[i]);
                HashMap<String, Integer> temp = new HashMap<>();
                temp.put(genres[i], plays[i]);
                idxMap.put(i, temp);
            }
            System.out.println(hashMap.entrySet());
            System.out.println(idxMap.entrySet());

            // 장르 순서 결정
            ArrayList<String> genreRank = new ArrayList<>();
            while (hashMap.size() > 0) {
                int max = Integer.MIN_VALUE;
                String maxGenre = "";
                for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                    if (max < entry.getValue()) {
                        max = entry.getValue();
                        maxGenre = entry.getKey();
                    }
                }
                genreRank.add(maxGenre);
                hashMap.remove(maxGenre);
            }
            System.out.println(hashMap.entrySet());
            System.out.println(genreRank);

            // 장르 안에서 많이 들은 곡 2개 선정, 1개라면 1개만 선정
            ArrayList<Integer> finalRank = new ArrayList<>();
            for (int i = 0; i < genreRank.size(); i++) {
                String genre = genreRank.get(i);
                ArrayList<Node> nodes = new ArrayList<>();
                for (int j = 0; j < plays.length; j++) {
                    if (idxMap.get(j).containsKey(genre)) {
                        System.out.println("j: " + j);
                        nodes.add(new Node(j, genre, plays[j]));
                    }
                }
                for (int j = 0; j < nodes.size(); j++) {
                    System.out.println(nodes.get(j).toString());
                }
                Collections.sort(nodes, (o1, o2) -> {
                    return o2.play - o1.play;
                });
                for (int j = 0; j < nodes.size(); j++) {
                    System.out.println(nodes.get(j).toString());
                }
                if (nodes.size() > 1) {
                    for (int j = 0; j < 2; j++) {
                        finalRank.add(nodes.get(j).idx);
                    }
                } else {
                    finalRank.add(nodes.get(0).idx);
                }
            }
            System.out.println(finalRank);

            // 배열로 변환하기
            int[] answer = new int[finalRank.size()];
            for (int i = 0; i < finalRank.size(); i++) {
                answer[i] = finalRank.get(i);
            }
            return answer;
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            String[] genres = {"classic", "pop", "classic", "classic", "pop"};
            int[] plays = {500, 600, 150, 800, 2500};
            System.out.println(s.solution(genres, plays));
        }
    }
}
