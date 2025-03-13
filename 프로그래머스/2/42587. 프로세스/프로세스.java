import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
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