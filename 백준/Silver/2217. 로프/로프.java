import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] x = new Integer[n];
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(x, (a, b) -> b-a);

        int max = 0;
        for (int i = 0; i < n; i++) {
            int w = x[i] * (i + 1);
            if (w > max) {
                max = w;
            }
        }

        System.out.println(max);
    }
}
