fun main() {
    val br = System.`in`.bufferedReader()

    val T = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(T) {
        val n = br.readLine().toLong()
        sb.append(binarySearch(n) - 1).append("\n")
    }

    println(sb)
}

fun binarySearch(n: Long): Long {
    var l = 1L
    var r = 1000000000L

    while(l < r) {
        val mid = l + (r - l) / 2

        if(mid * (mid + 1) / 2 > n) {
            r = mid
        } else {
            l = mid + 1
        }
    }

    return l
}