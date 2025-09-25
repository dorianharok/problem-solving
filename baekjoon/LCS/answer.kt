import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val s1 = br.readLine()
    val s2 = br.readLine()

    val dp = Array(s1.length + 1) { IntArray(s2.length + 1) }

    for(i in 1..s1.length) {
        for(j in 1..s2.length) {
            if(s1[i-1] == s2[j-1]) {
                dp[i][j] = dp[i-1][j-1] + 1
            } else {
                dp[i][j] = maxOf(dp[i-1][j], dp[i][j-1])
            }
        }
    }

    println(dp[s1.length][s2.length])
}