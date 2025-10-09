import java.util.*
import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()

    val (N, M, X) = br.readLine()!!.split(' ').map { it.toInt() }
    val adj = Array(N + 1) { mutableListOf<IntArray>() }
    val reverse = Array(N + 1) { mutableListOf<IntArray>() }
    repeat(M) {
        val (u, v, w) = br.readLine()!!.split(' ').map { it.toInt() }
        adj[u].add(intArrayOf(v, w))
        reverse[v].add(intArrayOf(u, w))
    }

    val first = dijkstra(adj, X)
    val second = dijkstra(reverse, X)

    var max = Int.MIN_VALUE
    for(i in 1 ..N) {
        max = max(max, first[i] + second[i])
    }

    println(max)
}

fun dijkstra(adj: Array<MutableList<IntArray>>, x: Int): IntArray {
    val pq = PriorityQueue<IntArray>(compareBy { it[1] })
    val distances = IntArray(adj.size) { Int.MAX_VALUE }
    val visited = BooleanArray(adj.size)
    distances[x] = 0

    pq.add(intArrayOf(x, 0))
    while (pq.isNotEmpty()) {
        val (current, currentDis) = pq.poll()

        if(visited[current]) continue
        visited[current] = true

        for((next, nextDistance) in adj[current]) {
            if(distances[next] > currentDis + nextDistance) {
                distances[next] = currentDis + nextDistance
                pq.add(intArrayOf(next, distances[next]))
            }
        }
    }

    return distances
}