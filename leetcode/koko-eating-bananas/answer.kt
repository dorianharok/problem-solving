class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var l = 1
        var r = piles.max()

        while(l < r) {
            val mid = l + (r - l) / 2

            if(isPossible(piles, mid, h)) {
                r = mid
            } else {
                l = mid + 1
            }
        }

        return r
    }

    fun isPossible(piles: IntArray, speed: Int, h: Int): Boolean {
        var sum = 0
        for(pile in piles) {
            sum += ceil(pile.toDouble() / speed).toInt()
            if(sum > h) return false
        }

        return sum <= h
    }
}