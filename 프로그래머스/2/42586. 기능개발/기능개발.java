import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue <Integer> q = new LinkedList<>();
        int p = 1;
        int curr = 0;
        for (int i = 0; i < progresses.length; i++) {
            if (progresses[i] + speeds[i] * p >= 100) curr++;
            else {
                if (curr > 0) {
                    q.add(curr);
                    p = (100 - progresses[i]) / speeds[i];
                    if ((100 - progresses[i]) % speeds[i] > 0) p++;
                    curr = 1;
                } else {
                    p = (100 - progresses[i]) / speeds[i];
                    if ((100 - progresses[i]) % speeds[i] > 0) p++;
                    curr++;
                }
            }
            
            if (i == progresses.length-1) q.add(curr);
        }
        
        int len = q.size();
        int [] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = q.poll();
        }
        return answer;
    }
}