import java.util.*;

public class B_15663 {
    static int N, M;
    static int[] numbers;
    static boolean[] visited;
    static List<int[]> results;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        numbers = new int[N];
        visited = new boolean[N];
        results = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);
        generateSequence(new ArrayList<>());

        Set<String> uniqueSequences = new LinkedHashSet<>();
        for (int[] seq : results) {
            StringBuilder sb = new StringBuilder();
            for (int num : seq) {
                sb.append(num).append(" ");
            }
            uniqueSequences.add(sb.toString().trim());
        }

        for (String sequence : uniqueSequences) {
            System.out.println(sequence);
        }
    }

    static void generateSequence(List<Integer> current) {
        if (current.size() == M) {
            results.add(current.stream().mapToInt(i -> i).toArray());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(numbers[i]);
                generateSequence(current);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
}
