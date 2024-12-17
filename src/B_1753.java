import java.io.*;
import java.util.*;

public class B_1753 {
    static int V, E, K;
    static List<int[]>[] edge;
    static final int INF = Integer.MAX_VALUE;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        edge = new ArrayList[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        for (int i = 1; i <= V; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edge[u].add(new int[]{w, v});
        }

        // 시작점 초기화
        dist[K] = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        heap.add(new int[]{0, K});

        while(!heap.isEmpty()) {
            int[] current = heap.poll();
            int cw = current[0];
            int cv = current[1];

            if(dist[cv] < cw) continue;

            for (int[] next : edge[cv]) {
                int nw = next[0];
                int nv = next[1];

                if (dist[nv] > cw + nw) {
                    dist[nv] = cw + nw;
                    heap.add(new int[]{dist[nv], nv});
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if(dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}

/**
 1. 아이디어
 * 한 점 시작, 모든 거리: 다익스트라
 * 간선, 인접리스트 저장
 * 거리배열 무한대 초기화
 * 시작점 : 거리배열 0, 힙에 넣어주기
 * 립에서 빼면서 다음의 것들 수행
 *      - 최신값인지 먼저 확인
 *      - 간선을 타고 간 비용이 더 작으면 갱신

 2. 시간복잡도
 * 다익스트라: 0(ElgV)
 *      - E : 3e5
 *      - V : 2e4   lgV ~= 20
 *      - ElgV = 6e6 > 가능

 3. 변수
 * 힙: (비용, 노드번호)
 * 거리 배열: 비용: int[]
 * 간선 저장, 인접리스트: (비용, 노드번호)[]
 *
 Tip!!
 * 다익스트라 코드는 그냥 외우기!
 * 코드가 복잡하므로 연습 필요.
 * 중요한 건, 해당 문제가 다익스트라 문제인지 알아내는 능력
        * 한 점에서 다른 점으로 가는 최소 비용
 */




/**
아이디어
* 한 점에서 다른 모든 점으로의 최단경로 > 다익스트라 사용
* 모든 점 거리 초기값 무한대로 설정
* 시작점 거리 0 설정 및 힙에 추가
* 힙에서 하나씩 빼면서 수행할 것
  * 현재 거리가 새로운 간선 거칠 때보다 크다면 갱신
  * 새로운 거리 힙에 추가

시간 복잡도
* 다익스트라 시간복잡도 ElgV
  * E : 3e5, lgV = 20
* O(ElgV) = 6e6 > 가능

변수
* 다익스트라 사용 힙: (비용(int), 다음 노드(int))[]
  * 비용 최대값: 10 * 2e4 = 2e5 => INT 가능
  * 다음 노드: 2e4 => INT 가능
* 거리 배열: int[]
  * 거리 최대값: 10 * 2e4 = 2e5 => INT 가능
* 간선, 인접 리스트: (비용(int), 다음 노드(int))[]
*/