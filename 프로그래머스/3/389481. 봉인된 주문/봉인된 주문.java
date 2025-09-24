import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        
        int l = bans.length;
        
        long[] bans_int = new long[l];
        for (int i = 0; i < l; i++) {
            int len = bans[i].length();
            long sum = 0;
            int k = 0;
            for (int j = len-1; j >= 0; j--) {
                if (j == 0) {
                    sum += bans[i].charAt(k)-96;
                } else {
                    sum += (bans[i].charAt(k)-96) * (Math.pow(26, j));
                }
                k++;
            }
            bans_int[i] = sum;
            // System.out.println(bans[i] + " = " + sum);
        }
        
        // 순서대로 정렬시켜서, 몇 번인지 확인시키고 그만큼 빼기.
        long [] bans_len = new long[l];
        Arrays.sort(bans_int);
        for (int i = 0; i < l; i++) {
            bans_len[i] = bans_int[i] - i;
        }
        // System.out.println(bans_len[0]);
        
        long r_n = n;
        for (int i = 0; i < l; i++) {
            if (bans_len[i] <= n) r_n++;
            if (bans_len[i] > n) break;
        }
        
        long r = r_n;
        while(r >= 1) {
            long s = r / 26;
            long alpha = r - (s * 26);
            if (alpha == 0) {
                alpha = 26;
                s--;
            }
            
            answer = (char)(alpha + 96) + answer;
            // System.out.println(answer);
            r = s;
        }
        
        return answer;
    }
}