class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return dfs(0, visited, adj, hasApple);
    }

    public int dfs(int n, boolean[] visited, List<ArrayList<Integer>> adj, List<Boolean> hasApple) {
        visited[n] = true;
        int cnt = 0;

        for(int next : adj.get(n)) {
            if(visited[next]) continue;

            cnt += dfs(next, visited, adj, hasApple);
        }

        if(n != 0 && (hasApple.get(n) || cnt > 0)) {
            cnt += 2;
        }

        return cnt;
    }
}