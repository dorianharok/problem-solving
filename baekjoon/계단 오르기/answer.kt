import kotlin.math.max

fun main(){
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val stairs = IntArray(n)
    for(i in 0 until n) {
        stairs[i] = br.readLine().toInt()
    }
    if(n == 1) {
        println(stairs[0])
        return
    }

    val dp = Array(2){ IntArray(n) }
    dp[0][0] = stairs[0]
    dp[0][1] = stairs[1]
    dp[1][1] = stairs[0] + stairs[1]

    for(i in 2 until n) {
        dp[0][i] = max(dp[0][i-2], dp[1][i-2]) + stairs[i]
        dp[1][i] = dp[0][i-1] + stairs[i]
    }

    print(max(dp[0][n-1], dp[1][n-1]))
}