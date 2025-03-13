import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        List <int []> list = new ArrayList<>();        
        Queue <Integer> truck = new LinkedList<>();
        
        for (int i = 0; i < truck_weights.length; i++) {
            truck.add(truck_weights[i]);
        }
        
        int time = 0;
        int w = 0;
        
        while(true) {
            if (truck.size() == 0) {
                if (list.isEmpty() == true) break;
            }
            
            time++;
            
            if(list.isEmpty() == false) {
                int ls = list.size();
                for (int i = 0; i < ls; i++) {
                    // if (list.get())
                    int [] we = list.get(i);
                    we[1]++;
                }
                int [] we = list.get(0);
                if (we[1] > bridge_length) {
                    w -= we[0];
                    list.remove(0);
                }
            }
            
            if (truck.isEmpty() == false) {
                if (w + truck.peek() <= weight) {
                    w += truck.peek();
                    list.add(new int [] {truck.poll(), 1});
                }
            }
        }
        
        return time;
    }
}