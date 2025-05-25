import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import javax.swing.text.html.HTML.Attribute.N

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    var st = StringTokenizer(br.readLine())

    val arr = IntArray(N)
    for (i in arr.indices) {
        arr[i] = st.nextToken().toInt()
    }
    arr.sort()

    val M = br.readLine().toInt()
    st = StringTokenizer(br.readLine())
    val sb = StringBuilder()
    repeat(M) {
        val target = st.nextToken().toInt()
        if(binarySearch(arr, target)) {
            sb.append(1)
        } else {
            sb.append(0)
        }

        sb.append("\n")
    }

    println(sb)
}

fun binarySearch(nums: IntArray, target: Int): Boolean {
    var l = 0
    var r = nums.size - 1

    while(l <= r) {
        val mid = l + (r - l) / 2
        if (nums[mid] == target) {
            return true
        } else if (nums[mid] > target) {
            r = mid - 1
        } else {
            l = mid + 1
        }
    }

    return false
}