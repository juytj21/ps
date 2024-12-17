import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_1966 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [][] m = new int[n][2];
        int [][] list = new int[n][2];
        for(int i = 0; i < n; i++) {
            m[i][0] = s.nextInt();
            m[i][1] = s.nextInt();
            int[] priorities = new int[m[i][0]];
            for(int j = 0; j < m[i][0]; j++) {
                priorities[j] = s.nextInt();
            }
        }
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            int[] process = new int[2];
            process[0] = priorities[i];
            process[1] = i;
            queue.add(process);
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean highP = false;

            for (int[] process : queue) {
                if (process[0] > current[0]) {
                    highP = true;
                    break;
                }
            }

            if (highP) {
                queue.add(current);
            } else {
                answer++;
                if (current[1] == location) {
                    return answer;
                }
            }
        }

        return answer;
    }
}