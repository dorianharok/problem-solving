import java.util.*
import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()

    val (N, E) = br.readLine().split(" ").map { it.toInt() }
    val adj = Array(N + 1){ mutableListOf<IntArray>() }

    repeat(E) {
        val (u, v, w) = br.readLine().split(" ").map { it.toInt() }
        adj[u].add(intArrayOf(v, w))
        adj[v].add(intArrayOf(u, w))
    }

    val (v1, v2) = br.readLine().split(" ").map { it.toInt() }

    val arr = intArrayOf(1, v1, v2, N)
    var path1 = 0
    for(i in 0 until 3) {
        val result = dijkstra(adj, arr[i], arr[i+1])
        if(result == -1) {
            println(-1)
            return
        }

        path1 += result
    }

    val arr2 = intArrayOf(1, v2, v1, N)
    var path2 = 0
    for(i in 0 until 3) {
        val result = dijkstra(adj, arr2[i], arr2[i + 1])
        if(result == -1) {
            println(-1)
            return
        }

        path2 += result
    }

    println(min(path1, path2))
}

fun dijkstra(adj: Array<MutableList<IntArray>>, start: Int, end: Int): Int {
    val pq = PriorityQueue<IntArray>(compareBy { it[1] })
    val distances = IntArray(adj.size) { Int.MAX_VALUE }
    val visited = BooleanArray(adj.size)
    distances[start] = 0

    pq.add(intArrayOf(start, 0))
    while (pq.isNotEmpty()) {
        val (current, currentDis) = pq.poll()
        if(current == end) return currentDis

        if(visited[current]) continue
        visited[current] = true

        for((next, nextDistance) in adj[current]) {
            if(distances[next] > currentDis + nextDistance) {
                distances[next] = currentDis + nextDistance
                pq.add(intArrayOf(next, distances[next]))
            }
        }
    }

    return -1
}