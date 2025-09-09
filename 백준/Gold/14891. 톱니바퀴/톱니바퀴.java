import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] cog = new int[4][8];
    static int[] top = new int[4];

    static int tooth(int i, int pos) {
        return cog[i][(top[i] + pos) % 8];
    }

    static void rotate(int i, int y) {
        if (y == 1) top[i] = (top[i] + 7) % 8;
        else if (y == -1) top[i] = (top[i] + 1) % 8;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) cog[i][j] = s.charAt(j) - '0';
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken());

            int [] arr = new int[4];
            arr[x] = y;

            for (int j = x - 1; j >= 0; j--) {
                if (tooth(j, 2) != tooth(j+1, 6)) arr[j] = -arr[j+1];
                else break;
            }

            for (int j = x + 1; j < 4; j++) {
                if (tooth(j-1, 2) != tooth(j, 6)) arr[j] = -arr[j-1];
                else break;
            }

            for (int j = 0; j < 4; j++) if (arr[j] != 0) rotate(j, arr[j]);
        }

        int score = 0;
        if (tooth(0, 0) == 1) score += 1;
        if (tooth(1, 0) == 1) score += 2;
        if (tooth(2, 0) == 1) score += 4;
        if (tooth(3, 0) == 1) score += 8;

        System.out.println(score);
    }
}
