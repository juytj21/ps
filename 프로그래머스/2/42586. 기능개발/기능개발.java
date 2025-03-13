import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue <Integer> answer = new LinkedList<>();
        Queue <Integer> list = new LinkedList<>();
        Queue <Integer> spd = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            list.add(progresses[i]);
            spd.add(speeds[i]);
        }
        
        while(true) {
            if (list.peek() == null) break;
            int r = (100 - list.peek() + spd.peek() - 1) / spd.peek();
            int len = list.size();
            int p = 0;
            for (int i = 0; i < len; i++) {
                if (list.peek() + spd.peek() * r >= 100) {
                    p++;
                    list.remove();
                    spd.remove();
                }
                else break;
            }
            if (p > 0) {
                answer.add(p);
            }
        }
        
        int r = answer.size();
        int[] ans = new int[r];
        for (int i = 0; i < r; i++) {
            ans[i] = answer.poll();
        }
        return ans;
    }
}