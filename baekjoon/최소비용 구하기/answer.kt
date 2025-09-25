import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val M = br.readLine().toInt()

    val adj = Array(N + 1) { mutableListOf<IntArray>() }

    repeat(M) {
        val (u, v, w) = br.readLine().split(" ").map { it.toInt() }
        adj[u].add(intArrayOf(v, w))
    }

    val (start, end) = br.readLine().split(" ").map { it.toInt() }

    val visited = BooleanArray(N + 1)
    val distances = IntArray(N + 1){ Int.MAX_VALUE }
    val pq = PriorityQueue<IntArray>(compareBy { it[1] })

    distances[start] = 0
    pq.add(intArrayOf(start, 0))

    while(pq.isNotEmpty()) {
        val (current, currentDis) = pq.poll()

        if(visited[current]) continue
        visited[current] = true

        for(edge in adj[current]) {
            val (next, distance) = edge
            val nextDistance = currentDis + distance

            if(distances[next] > nextDistance) {
                distances[next] = nextDistance
                pq.add(intArrayOf(next, nextDistance))
            }
        }
    }

    println(distances[end])
}