fun main(){
    val br = System.`in`.bufferedReader()

    val (n, k) = br.readLine()!!.split(" ").map { it.toInt() }
    val coin = IntArray(n)
    repeat(n) { i ->
        coin[i] = br.readLine()!!.toInt()
    }

    val dp = IntArray(k + 1)
    dp[0] = 1
    for (c in coin) {
        for(i in c .. k) {
            dp[i] += dp[i - c]
        }
    }

    println(dp[k])
}