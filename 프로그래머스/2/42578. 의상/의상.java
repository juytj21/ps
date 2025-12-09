import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (!map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], new ArrayList<>());
            }
            
            map.get(clothes[i][1]).add(clothes[i][0]);
        }
        
        int answer = 1;
        String[] keys = map.keySet().toArray(new String[0]);
        
        for (int i = 0; i < map.size(); i++) {
            String type = keys[i];
            int num = map.get(type).size();

            answer *= (num + 1);
        }
        
        
        return answer - 1;
    }
}