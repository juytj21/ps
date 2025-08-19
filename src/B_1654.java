import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1654 {
    static int K, N, ans, num, max = Integer.MAX_VALUE, min = 1;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max > arr[i]) max = arr[i];
        }

        ans = max;
        cal();

        System.out.println(ans);
    }

    public static void down() {
        ans = max/2;
        cal();
    }

    public static void up() {
        min = ans;
        ans += (max - min) / 2;
        min++;
        cal();
    }

    public static void eq() {
        num = 0;
        for (int i = 0; i < K; i++) {
            num += arr[i] / (ans+1);
        }
        if (num == N) up();
    }

    public static void cal() {
        num = 0;
        for (int i = 0; i < K; i++) {
            num += arr[i] / ans;
        }

        if (num > N) {
            up();
        } else if (num < N) {
            max = ans;
            down();
        } else {
            eq();
        }
    }
}
