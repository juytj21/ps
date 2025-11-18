class Solution {
    public int solution(String word) {
        int answer = 0;
        
        int len = word.length();
        int [] weight = {781, 156, 31, 6, 1};
        
        for (int i = 0; i < len; i++) {
            char w = word.charAt(i);
            int idx = 0;
            if (w == 'A') idx = 0;
            else if (w == 'E') idx = 1;
            else if (w == 'I') idx = 2;
            else if (w == 'O') idx = 3;
            else if (w == 'U') idx = 4;
            
            answer += idx * weight[i] + 1;
        }
        
        
        
        return answer;
    }
}