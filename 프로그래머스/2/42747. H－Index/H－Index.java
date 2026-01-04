class Solution {
    public int solution(int[] citations) {
        int index = -1;
        int n = citations.length;
        int max = 0;
        for (int m : citations) {
            if (max < m) max = m;
        }
        System.out.println(max);
        
        int [][] c = new int [max+1][2];
        for (int i = 0; i <= max; i++) {
            index++;
            System.out.println(index);
            for (int j = 0; j < n; j++) {
                if (citations[j] <= index) c[i][0]++;
                if (citations[j] >= index) c[i][1]++;
            }
        }
        
        index++;
        
        for (int i = max; i >= 0; i--) {
            index--;
            if (c[i][0] <= i && c[i][1] >= i) {
                break;
            }
        }
        
        return index;
    }
}