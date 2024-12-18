import java.io.*;
import java.util.*;

public class B_1504 {
    static int N, E, v1, v2;
    static List<int[]>[] edge;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edge = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edge[a].add(new int[]{b, c});
            edge[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        long sum_v1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        long sum_v2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        if (dijkstra(1, v1) == INF || dijkstra(v1, v2) == INF || dijkstra(v2, N) == INF ||
                dijkstra(1, v2) == INF || dijkstra(v2, v1) == INF || dijkstra(v1, N) == INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(sum_v1, sum_v2));
        }
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        heap.add(new int[]{0, start});

        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int cc = curr[0];
            int cb = curr[1];

            if(dist[cb] < cc) continue;

            for (int[] next : edge[cb]) {
                int nb = next[0];
                int nc = next[1];

                if (dist[nb] > cc + nc) {
                    dist[nb] = cc + nc;
                    heap.add(new int[]{dist[nb], nb});
                }
            }
        }

        return dist[end];
    }
}

/**
 * 특정한 최단 경로
 1. 아이디어
 * 1번 정점에서 특정 정점까지의 최단경로: 다익스트라
 * 간선, 인접리스트에 저장
 * 거리배열 무한대 초기화
 * 시작 점 : 거리 배열 0, 힙에 넣어주기
 * 힙에서 빼면서 다음 것들 수행
 *      - 최신 값인지 먼저 확인
 *      - 간선을 타고 간 비용이 더 작으면 갱신
 *      - 마지막에 주어진 정점 거쳐야 함 -> 1차 정점 / N번 정점 -> 2차 정점

 2. 시간 복잡도
 *
 *
 3. 변수
 * 1 -> v1 : 힙: (비용, 노드 번호)
 * 1 -> v2 : 힙: (비용, 노드 번호)
 * 1_v1 vs 1_v2 최소비용 찾기
 * v1 -> v2 : 힙: (비용, 노드 번호)
 * v2 -> N : 힙: (비용, 노드 번호)
 *
 */
