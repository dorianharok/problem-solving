import java.io.BufferedReader
import java.io.InputStreamReader
import javax.swing.text.html.HTML.Attribute.N

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var t = br.readLine().toInt()

    val dp = IntArray(11)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for (i in 4..10) {
        dp[i] = dp[i-3] + dp[i-2] + dp[i-1]
    }

    val sb = StringBuilder()

    repeat(t) {
        val n = br.readLine().toInt()
        sb.append(dp[n]).append("\n")
    }

    println(sb)
}