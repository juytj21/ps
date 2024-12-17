import java.util.*;

public class B_15651 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        generateSequence(new ArrayList<>());
        System.out.print(sb.toString());
    }

    static void generateSequence(List<Integer> current) {
        if (current.size() == M) {
            for (int num : current) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            current.add(i);
            generateSequence(current);
            current.remove(current.size() - 1);
        }
    }
}
