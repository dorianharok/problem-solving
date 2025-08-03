import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import javax.swing.text.html.HTML.Attribute.N

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().trim().toInt()
    val sb = StringBuilder()

    repeat(t) {
        val n = br.readLine().trim().toLong()
        sb.append(trickySum(n)).append("\n")
    }

    println(sb)
}

fun trickySum(n: Long): Long {
    var sum = n * (n + 1) / 2
    var i = 1

    while(i <= n) {
        sum -= i * 2
        i *= 2
    }

    return sum
}