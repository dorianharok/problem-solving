import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (a, b) = br.readLine().split(" ").map { it.toLong() }

    val q = ArrayDeque<LongArray>()
    q.add(longArrayOf(a, 1))

    while(q.isNotEmpty()) {
        val (current, count) = q.removeFirst()

        if(current > b) {
            continue
        }

        if(current == b) {
            println(count)
            return
        }

        q.add(longArrayOf(current * 2, count+1))
        q.add(longArrayOf(current * 10 + 1, count+1))
    }

    println(-1)
}