import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
        }
        
        if (nums.length/2 <= map.size()) {
            answer = nums.length/2;
        } else {
            answer = map.size();
        }
        return answer;
    }
}