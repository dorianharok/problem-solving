import java.util.*

var node = 0
var max = 0
lateinit var visited: BooleanArray
lateinit var adj: Array<MutableList<IntArray>>

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    adj = Array(n + 1) { mutableListOf() }
    repeat(n-1) {
        val (u, v, w) = br.readLine()!!.split(" ").map { it.toInt() }
        adj[u].add(intArrayOf(v, w))
        adj[v].add(intArrayOf(u, w))
    }

    visited = BooleanArray(n + 1)
    visited[1] = true

    dfs(1, 0)

    visited = BooleanArray(n + 1)
    visited[node] = true
    max = 0
    dfs(node, 0)

    println(max)
}

fun dfs(n: Int, sum: Int) {
    if(sum > max) {
        node = n
        max = sum
    }

    for((next, w) in adj[n]) {
        if(visited[next]) continue

        visited[next] = true
        dfs(next, sum + w)
    }
}