import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    static boolean[][] visited;
    static TreeSet<Integer> result = new TreeSet<>();
    static int A, B, C;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        A = s.nextInt();
        B = s.nextInt();
        C = s.nextInt();

        visited = new boolean[A+1][B+1];
        bfs();

        for (int water : result) {
            System.out.print(water + " ");
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, C});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int a = cur[0], b = cur[1], c = cur[2];

            if (visited[a][b]) continue;
            visited[a][b] = true;

            if(a==0) result.add(c);

            pour(q, a, b, c, A, B, C);
        }
    }

    public static void pour(Queue<int[]> q, int a, int b, int c, int A, int B, int C) {
        int [] capacities = {A, B, C};
        int [] current = {a, b, c};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    int [] next = current.clone();
                    int amount = Math.min(next[i], capacities[j] - next[j]);
                    next[i] -= amount;
                    next[j] += amount;
                    if (!visited[next[0]][next[1]]) {
                        q.add(next);
                    }
                }
            }
        }
    }
}
