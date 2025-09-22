import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (V, E) = br.readLine().trim().split(" ").map { it.toInt() }
    val K = br.readLine().toInt()

    val graph = Array(V + 1) { mutableListOf<IntArray>() }
    val visited = BooleanArray(V + 1)
    val distances = IntArray(V + 1) { Int.MAX_VALUE }

    repeat(E) {
        val (u, v, w) = br.readLine().trim().split(" ").map { it.toInt() }

        graph[u].add(intArrayOf(v, w))
    }

    val pq = PriorityQueue<IntArray>(compareBy { it[1] })
    pq.add(intArrayOf(K, 0))
    distances[K] = 0

    while(pq.isNotEmpty()) {
        val (current, _) = pq.poll()

        if(visited[current]) continue
        visited[current] = true

        for(next in graph[current]) {
            val v = next[0]
            val w = next[1]

            if(distances[v] > distances[current] + w) {
                distances[v] = distances[current] + w
                pq.add(intArrayOf(next[0], distances[v]))
            }
        }
    }

    val sb = StringBuilder()
    for(i in 1..V) {
        if(distances[i] == Int.MAX_VALUE) {
            sb.append("INF\n")
        } else {
            sb.append(distances[i]).append("\n")
        }
    }

    println(sb)
}