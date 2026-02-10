class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        int home1 = steal(money, 0, n-2);
        int home2 = steal(money, 1, n-1);
        
        return Math.max(home1, home2);
    }
    
    public int steal(int[] money, int start, int end) {
        int pre2 = 0;
        int pre1 = 0;
        
        for (int i = start; i <= end; i++) {
            int curr = Math.max(pre1, pre2 + money[i]);
            pre2 = pre1;
            pre1 = curr;
        }
        
        return pre1;
    }
}