package Study_CT.AnswerCode;

import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {
    public String[] solution(String[] record) {

        HashMap<String, String> nickName = new HashMap(); // uid, nickName
        HashMap<String, String> message = new HashMap<>();
        message.put("Enter", "님이 들어왔습니다.");
        message.put("Leave", "님이 나갔습니다.");

        for (String s : record) { // "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"
            String[] split = s.split(" ");
            if (split.length == 3) {
                nickName.put(split[1], split[2]);
            }
//            else {
//                nickName.put(split[0], split[1]);
//            }
            // uid1234, Muzi
            // uid4567, Prodo

            // uid1234, Prodo -> Leave -> Enter
            // uid4567, Ryan -> Change
        }

        ArrayList<String> answer = new ArrayList<>();

        for (String s : record) { // "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"
            String[] split = s.split(" ");
            if (message.containsKey(split[0])) { // O(1)
                answer.add(nickName.get(split[1]) + message.get(split[0]));
            }
        }

        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        오픈채팅방 p = new 오픈채팅방();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(p.solution(record));
    }

}
