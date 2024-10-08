import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val relationships: MutableList<MutableList<Int>> = mutableListOf()

    for(i in 0 .. N) {
        relationships.add(ArrayList())
    }

    repeat(M) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        relationships[a].add(b)
        relationships[b].add(a)
    }

    var min = Int.MAX_VALUE
    var minNum = Int.MIN_VALUE
    for(i in 1 .. N) {
        val result = bfs(i, relationships, N)
        if(min > result) {
            min = result
            minNum = i
        }
    }

    println(minNum)
}

fun bfs(a: Int, relationships: MutableList<MutableList<Int>>, N: Int): Int {
    val q = ArrayDeque<IntArray>()
    val visited = BooleanArray(N+1)
    q.add(intArrayOf(a, 0))
    visited[a] = true

    var sum = 0
    while(q.isNotEmpty()) {
        val (x, distance) = q.removeFirst()
        sum += distance

        val relation = relationships[x]
        for(f in relation) {
            if(visited[f]) {
                continue
            }

            q.add(intArrayOf(f, distance+1))
            visited[f] = true
        }
    }

    return sum
}