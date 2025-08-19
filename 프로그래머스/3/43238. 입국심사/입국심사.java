import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long hi = 0;
        for (int m : times) if (hi < m) hi = m;
        hi *= n;
        
        long lo = 0;
        
        while (lo <= hi) {
            long mid = (lo + hi) >>> 1;
            if (count(mid, n, times)) {
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return answer;
    }
    
    boolean count (long mid, int n, int[] times) {
        long cnt = 0;
        for (int i = 0; i < times.length; i++) {
            cnt += mid / times[i];
            if (cnt >= n) return true;
        }
        
        return cnt >= n;
    }
}