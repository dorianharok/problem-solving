class Solution {
    var min = Int.MAX_VALUE
    lateinit var visited: BooleanArray
    lateinit var adj: Array<MutableList<IntArray>>

    fun minScore(n: Int, roads: Array<IntArray>): Int {
        visited = BooleanArray(n + 1)
        adj = Array(n + 1) { mutableListOf() }

        for((u, v, w) in roads) {
            adj[u].add(intArrayOf(v, w))
            adj[v].add(intArrayOf(u, w))
        }

        dfs(1)

        return min
    }

    fun dfs(n: Int) {
        if(visited[n]) return
        visited[n] = true

        for((next, weight) in adj[n]) {
            min = min(min, weight)

            if(visited[next]) continue
            dfs(next)
        }
    }
}