import java.util.Scanner;

public class B_15650 {
    static int n, m;
    static boolean[] visited;
    static int[] sequence;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();

        sequence = new int[m];

        dfs(1, 0);
    }

    static void dfs(int start, int depth) {
        if (depth == m) {
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            sequence[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
