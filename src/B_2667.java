import java.util.*;

public class B_2667 {
    static int n;
    static int [][] arr;
    static boolean [][] visit;
    static int count = 0;
    static int house;

    // 방향 설정 변수
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void dfs(int i, int j) {
        visit[i][j] = true;
        house++;

        for (int d = 0; d < 4; d++) {
            int ni = i + dx[d];
            int nj = j + dy[d];

            if(ni >= 0 && ni < n && nj >= 0 && nj < n && arr[ni][nj] == 1 && !visit[ni][nj]) {
                dfs(ni, nj);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        arr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String tmp = s.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = tmp.charAt(j) - '0';
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    count++;
                    house = 0;
                    dfs(i, j);
                    list.add(house);
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for (int h : list) {
            System.out.println(h);
        }
    }
}
