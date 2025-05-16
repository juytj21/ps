import java.util.*;

class Solution {
    int dx[] = {0, 1, 0, -1};
    int dy[] = {-1, 0, 1, 0};
    boolean [][] visit;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (maps[nx][ny] != 1) continue;
                
                maps[nx][ny] = maps[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        
        int answer = maps[n-1][m-1];
        return (answer == 1) ? -1 : answer;
    }
    
}