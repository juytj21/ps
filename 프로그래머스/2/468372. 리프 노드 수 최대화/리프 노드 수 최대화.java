class Solution {
    long limit;

    public int solution(int dist_limit, int split_limit) {
        limit = split_limit;

        long answer = 1 + dfs(1L, (long) dist_limit, 1L);

        return (int) answer;
    }
    
    private long dfs(long nodes, long remain, long score) {
        if (remain == 0) return 0;

        boolean can2 = (score * 2L <= limit);
        boolean can3 = (score * 3L <= limit);

        if (!can2 && !can3) return 0;

        if (remain <= nodes) {
            if (can3) {
                return remain * 2L;
            } else {
                return remain;
            }
        }

        long max = 0;

        if (can2) {
            long next = nodes + dfs(nodes * 2L, remain - nodes, score * 2L);
            max = Math.max(max, next);
        }

        if (can3) {
            long next = nodes * 2L + dfs(nodes * 3L, remain - nodes, score * 3L);
            max = Math.max(max, next);
        }

        return max;
    }
}