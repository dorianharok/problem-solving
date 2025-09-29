class Solution {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val visited = BooleanArray(n)
        val adj = Array(n){ mutableListOf<Int>() }

        for((u, v) in edges) {
            adj[u].add(v)
            adj[v].add(u)
        }

        fun dfs(n: Int) {
            for(next in adj[n]) {
                if(visited[next]) continue

                visited[next] = true
                dfs(next)
            }
        }

        visited[source] = true
        dfs(source)

        return visited[destination]
    }
}