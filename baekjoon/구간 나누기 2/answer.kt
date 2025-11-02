import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    fun isPossible(n: Int): Boolean {
        var sum = 1
        var curMax = arr[0]
        var curMin = arr[0]

        for(i in 1 until N) {
            val cur = arr[i]
            val tempMax = max(curMax, cur)
            val tempMin = min(curMin, cur)

            if(tempMax - tempMin > n) {
                sum++
                curMax = cur
                curMin = cur
            } else {
                curMax = tempMax
                curMin = tempMin
            }
        }

        return sum <= M
    }

    var l = 0
    var r = arr.max()
    var ans = 0

    while (l <= r) {
        val mid = l + (r - l) / 2

        if(isPossible(mid)) {
            ans = mid
            r = mid - 1
        } else {
            l = mid + 1
        }
    }

    println(ans)
}