import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var N = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }

    val sum = IntArray(arr.size + 1) { 0 }
    for (i in 1..arr.size) {
        sum[i] = sum[i-1] + arr[i-1]
    }

    N = br.readLine().toInt()
    repeat(N) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        println(sum[y] - sum[x-1])
    }
}