import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            if (map.containsKey(participant[i])) {
                map.put(participant[i], map.get(participant[i])+1);
            } else {
                map.put(participant[i], 1);
            }
        }
        
        String answer = "";
        
        for (int i = 0; i < completion.length; i++) {
            if (map.containsKey(completion[i])) {
                if(map.get(completion[i]) > 1) {
                    map.put(completion[i], map.get(completion[i])-1);
                } else {
                    map.remove(completion[i]);
                }
            }
        }
        
        for (String s : map.keySet()) {
            answer = s;
        }
        
        return answer;
    }
}