import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, C) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val sumA = mutableListOf<Long>()
    val sumB = mutableListOf<Long>()

    combi(0, N / 2, 0, arr, sumA)
    combi(N / 2, N, 0, arr, sumB)

    sumB.sort()
    var sum = 0L
    for (i in sumA.indices) {
        val target = C - sumA[i]
        sum += upperBound(sumB, target)
    }

    println(sum)
}

fun upperBound(list: MutableList<Long>, target: Long): Int {
    var l = 0
    var r = list.size

    while (l < r) {
        val mid = l + (r - l) / 2

        if (list[mid] > target) {
            r = mid
        } else {
            l = mid + 1
        }
    }

    return l
}

fun combi(idx: Int, end: Int, sum: Long, arr: IntArray, list: MutableList<Long>) {
    if (idx == end) {
        list.add(sum)
        return
    }

    combi(idx + 1, end, sum, arr, list)
    combi(idx + 1, end, sum + arr[idx], arr, list)
}