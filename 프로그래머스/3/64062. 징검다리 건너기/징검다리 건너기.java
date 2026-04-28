class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = 200000000;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if (can(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    public boolean can(int[] stones, int k, int people) {
        int count = 0;
        
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] < people) {
                count++;
            } else count = 0;
            
            if (count >= k) return false;
        }
        
        return true;
    }
}