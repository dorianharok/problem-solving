fun main() {
    val br = System.`in`.bufferedReader()

    val (N, M) = br.readLine()!!.split(' ').map { it.toInt() }
    val arr = IntArray(N)
    repeat(N) { i ->
        arr[i] = br.readLine().toInt()
    }
    val sum = arr.sum()

    fun isPossible(n: Int): Boolean {
        if (arr.any { it > n }) return false

        var cnt = 1
        var current = n

        for(a in arr) {
            current -= a

            if(current < 0) {
                cnt++
                current = n
                current -= a
            }
        }

        return cnt <= M
    }

    var l = 1
    var r = sum
    var ans = 0

    while(l <= r) {
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