import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println("0");
            return;
        } else if (n == 2 || n == 3) {
            System.out.println("1");
            return;
        }

        int [] result = new int[n+1];
        result[1] = 0;
        result[2] = 1;
        result[3] = 1;

        for (int i = 4; i <= n; i++) {
            int m, min = 0;
            if (i % 3 == 0) {
                m = result[i/3];
                min = m;
            }
            if (i % 2 == 0) {
                m = result[i/2];
                if (min == 0 || min > m) min = m;
            }
            if (min == 0 || min > result[i-1]) min = result[i-1];

            result[i] = min + 1;
        }

        System.out.println(result[n]);
    }
}
