import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int [] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = n-2; i >= 0; i--) {
            int max = 1;
            for (int j = i+1; j < n; j++) {
                if (A[i] < A[j]) {
                    if (max < dp[j]+1) max = dp[j]+1;
                }
            }
            
            dp[i] = max;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (answer < dp[i]) {
                answer = dp[i];
            }
        }

        System.out.println(answer);
    }
}