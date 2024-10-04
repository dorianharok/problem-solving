import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayDeque

val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf(0, 1, 0, -1)
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val map = Array(N) { IntArray(N) }
    for(i in 0 until N) {
        map[i] = br.readLine().map { it.digitToInt() }.toIntArray()
    }

    val pq = PriorityQueue<Int>()
    for(i in 0 until N) {
        for (j in 0 until N) {
            if(map[i][j] != 1) {
                continue
            }

            val count = bfs(map, i, j)
            pq.add(count)
        }
    }

    println(pq.size)
    while(!pq.isEmpty()) {
        println(pq.poll())
    }
}

fun bfs(map:Array<IntArray>, row: Int, col: Int): Int {
    val q = ArrayDeque<Pair<Int, Int>>()
    map[row][col] = 0
    q.add(Pair(row, col))

    var count = 0
    while (q.isNotEmpty()) {
        val (x, y) = q.removeFirst()
        count++
        for(i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx < 0 || ny < 0 || nx >= map.size || ny >= map.size || map[nx][ny] != 1) {
                continue
            }

            map[nx][ny] = 0
            q.add(Pair(nx, ny))
        }
    }

    return count
}