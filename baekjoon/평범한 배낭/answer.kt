import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()

    val (N, K) = br.readLine()!!.split(" ").map { it.toInt() }
    val dp = IntArray(K + 1)
    repeat(N) {
        val (w, v) = br.readLine()!!.split(" ").map { it.toInt() }

        for(i in K downTo w) {
            dp[i] = max(dp[i], dp[i - w] + v)
        }
    }

    println(dp[K])
}