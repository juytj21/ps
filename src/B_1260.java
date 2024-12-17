import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B_1260 {
    static int n, m, v;
    static ArrayList<Integer>[] adjList;  // 인접 리스트
    static boolean[] visited;  // 방문 여부 체크

    // DFS 함수
    public static void dfs(int v) {
        visited[v] = true;  // 현재 정점 방문 표시
        System.out.print(v + " ");  // 방문한 정점 출력

        // 현재 정점에 연결된 다른 정점들을 탐색
        for (int next : adjList[v]) {
            if (!visited[next]) {
                dfs(next);  // 방문하지 않았다면 재귀적으로 탐색
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();  // 정점의 개수
        m = s.nextInt();  // 간선의 개수
        v = s.nextInt();  // 시작 정점

        adjList = new ArrayList[n + 1];  // 정점 번호는 1부터 N까지이므로 크기를 n+1로 설정
        visited = new boolean[n + 1];  // 방문 여부 배열

        // 인접 리스트 초기화
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 간선 입력받기
        for (int i = 0; i < m; i++) {
            int u = s.nextInt();
            int w = s.nextInt();
            adjList[u].add(w);
            adjList[w].add(u);  // 양방향 간선이므로 양쪽에 추가
        }

        // 정점 번호가 작은 것부터 방문하기 위해 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }

        // DFS 탐색 수행
        dfs(v);  // 시작 정점부터 DFS 수행
        System.out.println();
    }
}
