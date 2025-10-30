import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (K, N) = br.readLine().split(" ").map { it.toInt() }

    val arr = LongArray(K)
    for(i in arr.indices) {
        arr[i] = br.readLine()!!.toLong()
    }

    fun isPossible(len: Long): Boolean {
        return arr.sumOf { it / len } >= N
    }

    fun binarySearch(): Long {
        var l = 1L
        var r = arr.max()
        var len = 0L

        while(l <= r) {
            val mid = l + (r - l) / 2

            if(isPossible(mid)) {
                len = mid
                l = mid + 1
            } else {
                r = mid - 1
            }
        }

        return len
    }

    println(binarySearch())
}