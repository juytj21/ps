import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = 1;
        long max = (long) times[0] * n;
        long time = 0;
        
        while (min <= max) {
            long sum = 0;
            long mid = (max + min) / 2;
            
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }
            
            if (sum >= n) {
                time = mid;
                max = mid - 1;
            } else min = mid + 1;
        }
        
        return time;
    }
}