import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B_17086 {
    static int n, m;
    static int [][] r;
    static boolean [][] visit;
    static int v;

    // 방향 설정 변수
    static int [] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int [] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

    public static void dfs(int i , int j) {
        visit[i][j] = true;
        v++;

        for (int d = 0; d < 8; d++) {
            int ni = i + dx[d];
            int nj = j + dy[d];

            if (ni >= 0 && ni < n && nj >= 0 && nj < n && !visit[ni][nj]) {
                if(r[ni][nj] == 1) break;
                dfs(ni, nj);
            }
        }


    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        r = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                r[i][j] = s.nextInt();
            }
        }

        ArrayList<Integer> list = new ArrayList <Integer>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(r[i][j] == 1) {
                    v = 0;
                    dfs(i, j);
                    list.add(v);
                }
            }
        }

        Collections.sort(list);
        System.out.print(list.get(0));
    }
}
