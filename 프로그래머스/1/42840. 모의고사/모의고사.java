import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int [] n1 = {1, 2, 3, 4, 5};
        int [] n2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int [] n3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int m[] = new int [3];
        m[0] = 0;
        m[1] = 0;
        m[2] = 0;
        int p1 = 0, p2 = 0, p3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == n1[p1]) {
                m[0]++;
            }
            if (answers[i] == n2[p2]) {
                m[1]++;
            }
            if (answers[i] == n3[p3]) {
                m[2]++;
            }
            p1++; p2++; p3++;
            if(p1 == 5) p1 = 0;
            if(p2 == 8) p2 = 0;
            if(p3 == 10) p3 = 0;
        }
        
        ArrayList <Integer> answer = new ArrayList<>();
        int max = Math.max(m[0], Math.max(m[1], m[2]));
        
        for (int i = 0; i < 3; i++) {
            if (max == m[i]) {
                answer.add(i+1);
            }
        }
        
        int[] result = new int[answer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}