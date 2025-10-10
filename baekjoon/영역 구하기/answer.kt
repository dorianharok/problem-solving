import java.util.*
import kotlin.math.min

val dx = intArrayOf(-1, 0, 1, 0)
val dy = intArrayOf(0, 1, 0, -1)
val q = ArrayDeque<IntArray>()
lateinit var map: Array<IntArray>

fun main() {
    val br = System.`in`.bufferedReader()

    val (M, N, K) = br.readLine().split(" ").map { it.toInt() }
    map = Array(M) { IntArray(N) }
    repeat(K) {
        val (y1, x1, y2, x2) = br.readLine().split(" ").map { it.toInt() }
        for (i in x1 until x2) {
            for (j in y1 until y2) {
                map[i][j] = 1
            }
        }
    }

    val list = mutableListOf<Int>()
    var count = 0
    for (i in 0 until M) {
        for (j in 0 until N) {
            if(map[i][j] == 0) {
                count++
                q.add(intArrayOf(i, j))
                map[i][j] = 1
                list.add(bfs())
            }
        }
    }

    list.sort()
    println(count)
    println(list.joinToString(" "))
}

fun bfs(): Int {
    var count = 0
    while(q.isNotEmpty()) {
        val (x, y) = q.removeFirst()
        count++

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx < 0 || ny < 0 || nx >= map.size || ny >= map[0].size || map[nx][ny] == 1) continue
            map[nx][ny] = 1
            q.add(intArrayOf(nx, ny))
        }
    }

    return count
}