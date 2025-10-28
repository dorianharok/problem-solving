fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toLong()
    if(n == 1L) {
        println(1)
        return
    }

    var l = 1L
    var r = n

    while(l < r) {
        val mid = l + (r - l) / 2
        val sum = mid * (mid + 1) / 2

        if(sum > n) {
            r = mid
        } else {
            l = mid + 1
        }
    }

    println(l - 1)
}