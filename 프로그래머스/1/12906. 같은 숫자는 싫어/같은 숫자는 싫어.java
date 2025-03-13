import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue <Integer> q = new LinkedList<>();
        q.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] == arr[i]) continue;
            else q.add(arr[i]);
        }
        
        int s = q.size();
        int [] answer = new int[s];
        for (int i = 0; i < s; i++) {
            answer[i] = q.poll();
        }

        return answer;
    }
}