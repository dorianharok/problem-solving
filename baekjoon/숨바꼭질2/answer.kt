import java.util.*
import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()

    val (N, K) = br.readLine()!!.split(' ').map { it.toInt() }
    val q = ArrayDeque<IntArray>()

    q.offer(intArrayOf(N, 0))
    val visited = IntArray(100001) { Int.MAX_VALUE }
    visited[N] = 0

    var min = Int.MAX_VALUE
    var count = 0
    while (q.isNotEmpty()) {
        val (current, time) = q.removeFirst()
        if(current == K) {
            if(min > time) {
                min = time
                count = 1
            } else if (min == time) {
                count++
            } else {
                continue
            }
        }

        val arr = intArrayOf(current - 1, current + 1, current * 2)
        for(next in arr) {
            if(next < 0 || next > 100000) continue
            if(visited[next] < time + 1) continue
            visited[next] = time + 1
            q.offer(intArrayOf(next, time + 1))
        }
    }

    println(min)
    println(count)
}