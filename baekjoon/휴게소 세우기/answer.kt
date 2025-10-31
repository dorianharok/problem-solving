import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val (N, M, L) = br.readLine()!!.split(' ').map { it.toInt() }
    val arr = IntArray(N + 2)
    arr[0] = 0
    arr[N + 1] = L
    val st = StringTokenizer(br.readLine())
    for (i in 1..N) {
        arr[i] = st.nextToken().toInt()
    }
    arr.sort()

    fun isPossible(n: Int): Boolean {
        var sum = 0

        for (i in 1 until N + 2) {
            val d = arr[i] - arr[i - 1]
            if(d <= n) continue

            sum += (d - 1) / n
        }

        return sum <= M
    }

    var l = 1
    var r = L
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