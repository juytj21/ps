import java.util.Scanner;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] sequence;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        M = s.nextInt();

        visited = new boolean[N + 1];
        sequence = new int[M];

        dfs(0);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
