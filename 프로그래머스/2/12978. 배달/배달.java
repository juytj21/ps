import java.util.*;

class Node {
    int idx, cost;
    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        ArrayList<ArrayList<Node>> g = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i <= N; i++) g.add(new ArrayList<>());
        
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            g.get(a).add(new Node(b, c));
            g.get(b).add(new Node(a, c));
        }
        
        boolean[] visit = new boolean[N+1];
        int[] dist = new int[N+1];
        
        final int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[1] = 0;
        
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        q.offer(new int[]{0, 1}); //거리, 노드
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int d = cur[0];
            int u = cur[1];
            if (dist[u] < d) continue;
            
            for (int i = 0; i < g.get(u).size(); i++) {
                Node nx = g.get(u).get(i);
                int x = nx.idx;
                int nd = d + nx.cost;
                if (nd < dist[x]) {
                    dist[x] = nd;
                    q.offer(new int[]{nd, x});
                }
            }
        }
        for (int i = 1; i <= N; i++) if (dist[i] <= K) answer++;
        
        return answer;
    }
}