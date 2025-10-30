import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (_, M) = br.readLine().split(" ").map { it.toInt() }

    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    arr.sort()

    val sb = StringBuilder()
    repeat(M) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        sb.append(upperBound(b, arr) - lowerBound(a, arr)).append("\n")
    }

    println(sb)
}

fun upperBound(target: Int, arr: IntArray): Int {
    var l = 0
    var r = arr.size

    while(l < r) {
        val mid = l + (r - l) / 2

        if (arr[mid] > target) {
            r = mid
        } else {
            l = mid + 1
        }
    }

    return l
}

fun lowerBound(target: Int, arr: IntArray): Int {
    var l = 0
    var r = arr.size

    while(l < r) {
        val mid = l + (r - l) / 2

        if(arr[mid] >= target) {
            r = mid
        } else {
            l = mid + 1
        }
    }

    return l
}