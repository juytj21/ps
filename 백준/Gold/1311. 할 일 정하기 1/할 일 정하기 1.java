import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int [][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int size = 1 << n;
        int [] dp = new int[size];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int mask = 0; mask < size; mask++) {
            int num = Integer.bitCount(mask);
            if (num >= n) continue;
            for (int job = 0; job < n; job++) {
                if ((mask & (1 << job)) == 0) {
                    int nextMask = mask | (1 << job);
                    dp[nextMask] = Math.min(dp[nextMask], dp[mask] + cost[num][job]);
                }
            }
        }
        System.out.println(dp[size - 1]);
    }
}
