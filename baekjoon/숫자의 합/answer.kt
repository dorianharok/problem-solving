import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.in))

    val N = br.readLine().toInt()
    val s = br.readLine()

    val sum = 0
    for(i in 0 until s.length) {
        sum += s[i] - '0'
    }

    println(sum)
}