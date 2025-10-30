fun main() {
    val br = System.`in`.bufferedReader()

    val (n, k) = br.readLine().split(" ").map { it.toLong() }

    var l = 0L
    var r = n

    while(l <= r) {
        val mid = l + (r - l) / 2

        val row = mid
        val col = n - mid
        val paper = (row + 1) * (col + 1)

        if(paper == k) {
            println("YES")
            return
        } else if(paper < k) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }

    println("NO")
}