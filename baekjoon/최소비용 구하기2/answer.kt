import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val graph = Array(n + 1) { mutableListOf<IntArray>() }

    repeat(m) {
        val (start, end, cost) = br.readLine().trim().split(" ").map { it.toInt() }
        graph[start].add(intArrayOf(end, cost))
    }

    val pq = PriorityQueue<IntArray>(compareBy { it[1]} )
    val distances = IntArray(n + 1) { Int.MAX_VALUE }
    val visited = BooleanArray(n + 1)

    val (start, end) = br.readLine().trim().split(" ").map { it.toInt() }
    pq.add(intArrayOf(start, 0))
    distances[start] = 0

    val parent = IntArray(n + 1) { -1 }
    while (pq.isNotEmpty()) {
        val (current, currentDist) = pq.poll()

        if(visited[current]) continue
        visited[current] = true

        for(node in graph[current]) {
            val (next, distance) = node
            val nextDistance = currentDist + distance

            if(distances[next] > nextDistance) {
                distances[next] = nextDistance
                parent[next] = current
                pq.add(intArrayOf(next, nextDistance))
            }
        }
    }

    val path = mutableListOf<Int>()
    var current = end
    while(current != -1) {
        path.add(current)
        current = parent[current]
    }
    path.reverse()

    println(distances[end])
    println(path.size)
    println(path.joinToString(" "))
}