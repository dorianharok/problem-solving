import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()

    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val arr = LongArray(N)
    var max = Long.MIN_VALUE
    repeat(N) { i ->
        arr[i] = br.readLine()!!.toLong()
        max = max(max, arr[i])
    }

    fun isPossible(n: Long): Boolean {
        var count = 0L

        for (time in arr) {
            count += (n / time)

            if (count >= M) {
                return true
            }
        }

        return false
    }

    var l = 1L
    var r = max * M
    var answer = 0L

    while (l <= r) {
        val mid = l + (r - l) / 2

        if (isPossible(mid)) {
            answer = mid
            r = mid - 1
        } else {
            l = mid + 1
        }
    }

    println(answer)
}