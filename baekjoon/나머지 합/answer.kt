import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (_, M) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }
    val modCount = LongArray(M)
    modCount[0]++

    var sum = 0L
    for (n in arr) {
        sum += n
        val mod = (sum % M).toInt()
        modCount[mod]++
    }

    var result = 0L
    for (mod in modCount) {
        result += mod * (mod - 1) / 2
    }

    println(result)
}