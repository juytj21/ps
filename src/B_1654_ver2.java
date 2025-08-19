import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1654_ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        long N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];
        long hi = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            if (arr[i] > hi) hi = arr[i];
        }

        long lo = 1, ans = 0;
        while(lo <= hi) {
            long mid = (lo + hi) >>> 1;
            long cnt = 0;

            for (int i = 0; i < K; i++) cnt += (arr[i] / mid);

            if (cnt >= N) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
