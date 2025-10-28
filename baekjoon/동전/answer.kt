import java.io.BufferedReader

fun main() {
    val br = System.`in`.bufferedReader()

    val T = br.readLine().toInt()

    val sb = StringBuilder()
    repeat(T) {
        val N = br.readLine().toInt()
        val coins = br.readLine().split(" ").map { it.toInt() }
        val target = br.readLine().toInt()

        val dp = IntArray(target + 1)
        dp[0] = 1
        for (coin in coins) {
            for(i in coin .. target) {
                dp[i] += dp[i - coin]
            }
        }

        sb.append(dp[target]).append("\n")
    }

    println(sb)
}