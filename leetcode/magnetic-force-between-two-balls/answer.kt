class Solution {
    fun maxDistance(position: IntArray, m: Int): Int {
        position.sort()

        var l = 1
        var r = position[position.size - 1]
        var result = 0

        while(l <= r) {
            val mid = l + (r - l) / 2

            if(isPossible(position, mid, m)) {
                result = mid
                l = mid + 1
            } else {
                r = mid - 1
            }
        }

        return result
    }

    fun isPossible(position: IntArray, d: Int, m: Int): Boolean {
        var count = 1
        var cur = position[0]

        for(i in 1 until position.size) {
            val distance = position[i] - cur
            if(distance < d) continue

            cur = position[i]
            count++
        }

        return count >= m
    }
}