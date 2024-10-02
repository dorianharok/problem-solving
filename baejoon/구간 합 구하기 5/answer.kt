import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val arr = Array(N) { IntArray(N) }
    for (i in 0 until N) {
        arr[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val sum = Array(N + 1) { IntArray(N + 1) }
    for (i in 1..N) {
        for (j in 1..N) {
            sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + arr[i - 1][j - 1]
        }
    }

    val sb = StringBuilder()
    repeat(M) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }

        val result = sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1]

        sb.append("$result\n")
    }

    println(sb)
}
