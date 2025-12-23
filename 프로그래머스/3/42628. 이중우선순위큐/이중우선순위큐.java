import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minDel = new PriorityQueue<>();
        PriorityQueue<Integer> maxDel = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < operations.length; i++) {
            String str = operations[i];
            String [] st = str.split(" ");
            int n = Integer.parseInt(st[1]);
            
            if (st[0].equals("I")) {
                min.offer(n);
                max.offer(n);
            } else {
                if (n == 1 && !max.isEmpty()) {
                    int num = max.poll();
                    minDel.offer(num);
                } else if (n == -1 && !min.isEmpty()) {
                    int num = min.poll();
                    maxDel.offer(num);
                }
                
                while(!min.isEmpty() && !minDel.isEmpty() && minDel.peek() == min.peek()) {
                    int m = min.poll();
                    minDel.poll();
                }
                while(!max.isEmpty() && !maxDel.isEmpty() && maxDel.peek() == max.peek()) {
                    int m = max.poll();
                    maxDel.poll();
                }
            }
        }
        
        int[] answer = new int[2];
        if (min.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = max.poll();
            answer[1] = min.poll();
        }
        
        return answer;
    }
}