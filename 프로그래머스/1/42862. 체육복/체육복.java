import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        boolean [] use = new boolean[reserve.length];
        boolean [] get = new boolean[lost.length];
        
        for (int i = 0; i < reserve.length; i++) {
            if (!use[i]) {
                for (int j = 0; j < lost.length; j++) {
                    if (!get[j] && reserve[i] == lost[j]) {
                        answer++;
                        use[i] = true;
                        get[j] = true;
                    }
                }
            }
        }
        
        for (int i = 0; i < lost.length; i++) {
            boolean tf = false;
            int num = -1;
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] > lost[i]+1) break;
                
                if (lost[i]-1 == reserve[j] && !use[j] && !get[i]) {
                    tf = true;
                    num = j;
                }
                if (lost[i]+1 == reserve[j] && !use[j] && !get[i]) {
                    if (tf && num != -1) {
                        use[num] = true;
                        get[i] = true;
                        answer++;
                    } else if (!use[j]) {
                        use[j] = true;
                        get[i] = true;
                        answer++;
                    }
                    tf = false;
                    break;
                }
            }
            if (tf && num != -1) {
                answer++;
                use[num] = true;
                get[i] = true;
            }
        }
        
        return answer;
    }
}