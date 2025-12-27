class Solution {
    fun sumSubarrayMins(arr: IntArray): Int {
        val mod = 1000000007

        var sum = 0L
        val stack = Stack<Int>()
        for (i in 0..arr.size) {
            val cur = if (i == arr.size) 0 else arr[i]

            while (stack.isNotEmpty() && arr[stack.peek()] > cur) {
                val mid = stack.pop()
                val left = if (stack.isEmpty()) -1 else stack.peek()
                val right = i

                sum += ((mid - left) * (right - mid) * arr[mid].toLong()) % mod
                sum %= mod
            }

            stack.push(i)
        }

        return sum.toInt()
    }
}
