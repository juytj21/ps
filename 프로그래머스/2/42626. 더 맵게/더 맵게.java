import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int n:scoville) {
            q.add(n);
        }
        if(q.peek() >= K) return 0;
        while(q.size() > 1) {
            int s1 = q.poll();
            int s2 = q.poll();
            int s = s1 + (s2 * 2);
            q.add(s);
            answer++;
            if(q.peek() >= K) {
                return answer;
            }
        }
        if (q.peek() < K) answer = -1;
        return answer;
    }
}