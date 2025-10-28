import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()

    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val memory = br.readLine().split(" ").map { it.toInt() }
    val costs = br.readLine().split(" ").map { it.toInt() }
    val max = costs.sum()

    val dp = IntArray(max + 1)

    for(i in 0 until N) {
        for(j in max downTo costs[i]) {
            dp[j] = max(dp[j], dp[j - costs[i]] + memory[i])
        }
    }

    for(i in 0 .. max) {
        if(dp[i] >= M) {
            println(i)
            return
        }
    }
}