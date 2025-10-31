import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        double last = Double.NEGATIVE_INFINITY;

        for (int[] t : targets) {
            int s = t[0];
            int e = t[1];

            if (s < last && last < e) {
                continue;
            }

            count++;
            last = e - 0.5;
        }

        return count;
    }
}
