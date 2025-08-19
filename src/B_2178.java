import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2178 {
    static int[] dx = {-1, 0, 1, 0}; //좌상우하
    static int[] dy = {0, -1, 0, 1};

    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[n][m];
        int [][] answer = new int[n][m];

        q.add(new int[] {0, 0});
        visited[0][0] = true;
        answer[0][0] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (arr[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                answer[nx][ny] = answer[x][y] + 1;
                q.add(new int[] {nx, ny});
            }
        }

        System.out.println(answer[n-1][m-1]);
    }
}
