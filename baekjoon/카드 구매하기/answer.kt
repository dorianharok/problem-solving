import java.util.*
import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()

    val N = br.readLine().toInt()
    val P = br.readLine().split(" ").map { it.toInt() }

    val D = IntArray(N + 1)

    for (i in 1 .. N) {
        for(j in 1 .. i) {
            D[i] = max(D[i], D[i-j] + P[j-1])
        }
    }

    println(D[N])
}