class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int s_cnt = 0;
        int [][] curr_s = new int[24][2];
        
        for (int i = 0; i < 24; i++) {
            for (int j = i-1; j > i-(k+1); j--) {
                if (j < 0) break;
                if (curr_s[j][0] > 0) curr_s[j][1]++; // [][1] 몇 시간 째 사용 중인지
                if (curr_s[j][1] > k) s_cnt -= curr_s[j][0]; 
            }
            
            if (players[i] >= m) {
                int p = players[i] / m;
                if (p > s_cnt) {
                    curr_s[i][0] = p - s_cnt;
                    curr_s[i][1] = 1;
                    answer += (p - s_cnt);
                    s_cnt = p;
                }
            }
        }
        
        return answer;
    }
}