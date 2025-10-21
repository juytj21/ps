import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] m = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m[i][0] = Integer.parseInt(st.nextToken());
            m[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(m, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int count = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            if (m[i][0] >= end) {
                end = m[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
