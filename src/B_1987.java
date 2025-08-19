import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_1987 {
    static int r, c;
    static char [][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static HashMap<Character, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char [r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        map = new HashMap<>();
        int [][] depth = new int[r][c];
        int d = 0;
        map.put(arr[0][0], 1);
        dfs(0, 0, 0, depth, map);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (depth[i][j] > d) {
                    d = depth[i][j];
                }
            }
        }

        System.out.println(d);
    }

    static void dfs(int i, int j, int d, int[][] depth, HashMap<Character, Integer> map) {
        d++;
        if(depth[i][j] < d) {
            depth[i][j] = d;
        }
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                if (!map.containsKey(arr[nx][ny])) {
                    map.put(arr[nx][ny], 1);
                    dfs(nx, ny, d, depth, map);
                    map.remove(arr[nx][ny]);
                }
            }
        }
    }
}
