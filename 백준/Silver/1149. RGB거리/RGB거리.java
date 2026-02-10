import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [][] cost = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][] arr = new int[n][3];
        arr[0][0] = cost[0][0];
        arr[0][1] = cost[0][1];
        arr[0][2] = cost[0][2];

        for (int i = 1; i < n; i++) {
            arr[i][0] = Integer.MAX_VALUE;
            arr[i][1] = Integer.MAX_VALUE;
            arr[i][2] = Integer.MAX_VALUE;
            for (int x = 0; x < 3; x++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < 3; j++) {
                    if (j == x) continue;
                    if (min > arr[i-1][j]) {
                        min = arr[i-1][j];
                    }
                }

                if (arr[i][x] > cost[i][x] + min) {
                    arr[i][x] = cost[i][x] + min;
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (answer > arr[n-1][i]) answer = arr[n-1][i];
        }

        System.out.println(answer);
    }
}
