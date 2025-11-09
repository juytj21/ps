import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        Arrays.sort(results, (a, b) -> Integer.compare(a[1], b[1]));
        
        int[][] rank = new int[n+1][n+1];
        
        for (int i = 0; i < results.length; i++) {
            int x = results[i][0];
            int y = results[i][1];
            rank[x][y] = 1;
            rank[y][x] = -1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                for (int k = 1; k <= n; k++) {
                    if (i == k || j == k) continue;
                    if (rank[j][i] == 1 && rank[i][k] == 1) rank[j][k] = 1;
                    else if (rank[j][i] == -1 && rank[i][k] == -1) rank[j][k] = -1;
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int x = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j || rank[i][j] == 0) continue;
                x++;
            }
            if (x == n-1) answer++;
        }
        
        return answer;
    }
}