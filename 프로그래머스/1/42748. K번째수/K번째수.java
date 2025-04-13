import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int [len];
        
        for (int a = 0; a < len; a++) {
            int [] p = array.clone();
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            
            int [] arr = new int [j-i+1];
            for (int b = 0; b < j-i+1; b++) {
                arr[b] = p[b+i-1];
            }
            Arrays.sort(arr);
            
            answer[a] = arr[k-1];
        }
        
        return answer;
    }
}