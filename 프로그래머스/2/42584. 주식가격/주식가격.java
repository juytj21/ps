class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            int time = 0;
            if(i == prices.length-1) {time = 0;}
            else {
                for(int j = i+1; j < prices.length; j++) {
                    if(prices[i] <= prices[j]) {
                        time++;
                    } else {
                        time++;
                        break;
                    }
                }
            }
            answer[i] = time;
        }
        return answer;
    }
}