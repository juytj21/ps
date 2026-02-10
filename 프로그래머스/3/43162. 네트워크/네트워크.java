import java.util.*;

class Solution {
    boolean [] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, computers, n);
            }
        }
        
        return answer;
    }
    
    void dfs(int curr, int [][] computers, int n) {
        visited[curr] = true;

        for (int next = 0; next < n; next++) {
            if (computers[curr][next] == 1 && !visited[next]) dfs(next, computers, n);
        }
    }
}