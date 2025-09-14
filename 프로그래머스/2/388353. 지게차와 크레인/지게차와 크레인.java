import java.util.*;

class Solution {
    boolean [][] remove;
    char [][] box;
    boolean[][] crane;
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int n = storage.length; //세로
        int m = storage[0].length(); //가로
        remove = new boolean[n][m];
        box = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = storage[i].charAt(j);
            }
        }
        
        crane = new boolean[n][m];
        
        for (int x = 0; x < requests.length; x++) {
            List<int[]> list = new ArrayList<>();
            char c = requests[x].charAt(0);
            
            if (requests[x].length() == 1) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (remove[i][j] || box[i][j] != c) continue;
                        boolean out = false;
                        if (i-1 < 0 || i+1 >= n || j-1 < 0 || j+1 >= m) out = true;
                        else if (remove[i-1][j] || remove[i+1][j] || remove[i][j-1] || remove[i][j+1]) out = true;
                        if (out) {
                            list.add(new int[]{i,j});
                        }
                    }
                }
                
                int len = list.size();
                for (int i = 0; i < len; i++) {
                    int[] remove_box = list.get(0);
                    remove[remove_box[0]][remove_box[1]] = true;
                    list.remove(0);
                }
            } else if (requests[x].length() == 2) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (remove[i][j] || box[i][j] != c) continue;
                        
                        if (!crane[i][j]) crane[i][j] = true;
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!crane[i][j]) continue;
                    crane_f(i, j, n, m);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!remove[i][j] && !crane[i][j]) answer++;
                if (remove[i][j] && crane[i][j]) answer++;
            }
        }
        
        return answer;
    }
    
    public void crane_f(int i, int j, int n, int m) {
        boolean out = false;
        
        if (i-1 < 0 || i+1 >= n || j-1 < 0 || j+1 >= m) out = true;
        else if (remove[i-1][j] || remove[i+1][j] || remove[i][j-1] || remove[i][j+1]) out = true;
        if(out) {
            remove[i][j] = true;
            crane[i][j] = false;
            if (i-1 >= 0 && crane[i-1][j]) crane_f(i-1, j, n, m);
            if (i+1 < n && crane[i+1][j]) crane_f(i+1, j, n, m);
            if (j-1 >= 0 && crane[i][j-1]) crane_f(i, j-1, n, m);
            if (j+1 < m && crane[i][j+1]) crane_f(i, j+1, n, m);
        }
    }
}