class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int h = (int) Math.ceil((double) n / w);
        int [][] p = new int [h][w];
        
        int box = 1;
        
        for (int i = 0; i < h; i++) {
            if (i % 2 == 0){
                for (int j = 0; j < w && box <= n; j++) {
                    p[i][j] = box++;
                }
            } else {
                for (int j = w - 1; j >= 0 && box <= n; j--) {
                    p[i][j] = box++;
                }
            }
        }
        
        int r = -1, c = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (p[i][j] == num) {
                    r = i;
                    c = j;
                    break;
                }
            }
            if (r != -1) break;
        }
        
        for (int i = r; i < h; i++) {
            if (p[i][c] != 0) {
                answer++;
            }
        }
        
        return answer;
    }
}