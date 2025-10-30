fun main() {
    val br = System.`in`.bufferedReader()

    val N = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    arr.sort()

    val M = br.readLine().toInt()
    val targets = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    val sb = StringBuilder()
    repeat(M) { i ->
        if(binarySearch(arr, targets[i])) {
            sb.append(1)
        } else {
            sb.append(0)
        }

        sb.append(" ")
    }

    println(sb)
}

fun binarySearch(nums: Array<Int>, target: Int): Boolean {
    var l = 0
    var r = nums.size - 1

    while(l <= r) {
        val mid = l + (r - l) / 2

        if (nums[mid] == target) {
            return true
        } else if(nums[mid] > target) {
            r = mid - 1
        } else {
            l = mid + 1
        }
    }

    return false
}