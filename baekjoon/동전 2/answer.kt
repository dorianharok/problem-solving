fun main() {
    val br = System.`in`.bufferedReader()

    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(k + 1){ k + 1 }
    dp[0] = 0

    repeat(n) {
        val coin = br.readLine().toInt()

        for(i in coin..k) {
            dp[i] = minOf(dp[i], dp[i - coin] + 1)
        }
    }

    dp[k] = if(dp[k] == k+1) -1 else dp[k]
    println(dp[k])
}