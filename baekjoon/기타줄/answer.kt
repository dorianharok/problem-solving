import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    var minBundle = Int.MAX_VALUE
    var minEach = Int.MAX_VALUE

    repeat(M) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        minBundle = min(minBundle, x)
        minEach = min(minEach, y)
    }

    val bundleCount = N / 6
    val eachCount = N % 6

    val totalCost = min(
        min(eachCount * minEach, minBundle) + bundleCount * minBundle,
        N * minEach
    )

    println(totalCost)
}