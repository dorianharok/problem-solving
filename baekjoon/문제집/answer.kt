import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()

    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val indegree = IntArray(N + 1)
    val adj = Array(N + 1) { mutableListOf<Int>() }

    repeat(M) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        adj[a].add(b)
        indegree[b]++
    }

    val q = PriorityQueue<Int>()
    for (i in 1..N) {
        if(indegree[i] == 0) {
            q.add(i)
        }
    }

    val sb = StringBuilder()
    while(q.isNotEmpty()) {
        val cur = q.poll()
        sb.append(cur).append(" ")

        for(next in adj[cur]) {
            indegree[next]--
            if(indegree[next] == 0) {
                q.add(next)
            }
        }
    }

    println(sb)
}