import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Pro_CT_55 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for(String p : participant) {
            hashMap.put(p, hashMap.getOrDefault(p, 0) + 1);
        }
        for(String c : completion) {
            hashMap.put(c, hashMap.get(c) - 1);
        }
        for(String key : hashMap.keySet()) {
            if(hashMap.get(key) != 0) {
                answer += key;
//                break;
            }
        }
        return answer;
//        LinkedList<String> linkedList = new LinkedList<String>();
//        for(int i = 0; i<participant.length;i++) {
//            linkedList.add(participant[i]);
//        }
//        for(int i = 0; i< completion.length; i++) {
//            if(linkedList.contains(completion[i])) {
//                linkedList.remove(completion[i]);
//            }
//        }
//
//        for(int i = 0; i< linkedList.size(); i++) {
//            answer += linkedList.get(i);
//        }
//
//        return answer;

//        String answer = "";
//        ArrayList<String> arrayList = new ArrayList<String>();
//        for(int i = 0; i<participant.length;i++) {
//            arrayList.add(participant[i]);
//        }
//
//
//        for(int i = 0; i<completion.length; i++) {
//            for(int j = 0; j<participant.length; j++){
//                if(completion[i].equals(participant[j])) {
//                    arrayList.remove(participant[j]);
//                    break;
//                }
//            }
//        }
//
//        for(int i = 0; i< arrayList.size(); i++) {
//            answer += arrayList.get(i).toString();
//        }
//
//        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_55 sol = new Pro_CT_55();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(sol.solution(participant,completion));
    }
}
