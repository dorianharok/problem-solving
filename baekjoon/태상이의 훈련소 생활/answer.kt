import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val H = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val operation = IntArray(N+1)

    repeat(M) {
        val (a, b, k) = br.readLine().split(" ").map { it.toInt() }
        operation[a-1] += k
        operation[b] -= k
    }

    for (i in 1 until N) {
        operation[i] += operation[i-1]
    }

    val sb = StringBuilder()
    for (i in 0 until N) {
        H[i] += operation[i]
        sb.append("${H[i]} ")
    }

    println(sb)
}