class Solution {
    int answer = -1;
    boolean [] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    public void dfs(int currK, int [][] dungeons, int count) {
        if (count > answer) answer = count;
        
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            
            int tired = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if (currK >= tired) {
                visited[i] = true;
                dfs(currK - cost, dungeons, count+1);
                visited[i] = false;
            }
        }
    }
}