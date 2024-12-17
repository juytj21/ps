import sys
import heapq
input = sys.stdin.readline
INF = sys.maxsize

V, E = map(int, input().split())
K = int(input())
edge = [ [] for _ int range(V+1)]
dist = [INF] * (V+1)

for i in range(E):
    u, v, w = map(int, input().split())
    edge[u].append([w, v])

# 시작점 초기화
dist[K] = 0;
heap = [[0, K]]

while heap:
    curr_w, curr_v = heapq.heappop(heap)
    if dist[curr_v] != curr_w: continue

    for nw, nv in edge[curr_v]:
        if dist[nv] = curr_w + nw:
            dist[nv] = curr_w + nw;
            heapq.heappush(heap, [dist[nv], nv])

for i in range(1, V+1):
    if dist[i] == INF: print("INF")
    else: print(dist[i])