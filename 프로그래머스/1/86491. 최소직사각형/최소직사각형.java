class Solution {
    public int solution(int[][] sizes) {
        int len = sizes.length;
        int [][] arr = new int [len][2];
        for (int i = 0; i < len; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                arr[i][0] = sizes[i][0];
                arr[i][1] = sizes[i][1];
            } else {
                arr[i][1] = sizes[i][0];
                arr[i][0] = sizes[i][1];
            }
        }
        
        int max = 0;
        int max2 = 0;
        for (int i = 0; i < len; i++) {
            if (max < arr[i][0]) {
                max = arr[i][0];
            }
            if (max2 < arr[i][1]) {
                max2 = arr[i][1];
            }
        }
        
        int answer = max * max2;
        return answer;
    }
}