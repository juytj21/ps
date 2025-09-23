import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        final int INF = 1000000;
        int L = info.length;
        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < L; i++) {
            int a = info[i][0];
            int b = info[i][1];
            int[] ndp = new int[m];
            Arrays.fill(ndp, INF);

            for (int curB = 0; curB < m; curB++) {
                if (dp[curB] == INF) continue;
                if (dp[curB] + a < ndp[curB]) {
                    ndp[curB] = dp[curB] + a;
                }
                
                int nextB = curB + b;
                if (nextB < m) {
                    if (dp[curB] < ndp[nextB]) {
                        ndp[nextB] = dp[curB];
                    }
                }
            }
            
            dp = ndp;
        }

        int ans = INF;
        for (int curB = 0; curB < m; curB++) {
            if (dp[curB] < n && dp[curB] < ans) {
                ans = dp[curB];
            }
        }
        
        return (ans == INF) ? -1 : ans;
    }
}
