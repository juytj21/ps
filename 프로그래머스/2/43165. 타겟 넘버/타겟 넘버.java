import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int len = numbers.length;
        int num = (int)Math.pow(2, len);
        boolean[] bool = new boolean[len];
        for (int i = 0; i < len; i++) {
            bool[i] = true;
        }
        int[] pm = new int[len];
        
        for (int i = 0; i < num; i++) {
            int number = 0;
            for (int j = 0; j < len; j++) {
                if (pm[j] == 1) {
                    number -= numbers[j];
                } else {
                    number += numbers[j];
                }
            }
            
            if (number == target) answer++;
            
            //이진수 계산해주기. 2 만나면 다음수, 1만나면 종료
            for (int j = len-1; j >= 0; j--) {
                pm[j]++;
                if (pm[j] != 2) {
                    break;
                } else {
                    pm[j] = 0;
                }
            }
        }
        return answer;
    }
}