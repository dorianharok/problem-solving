class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var l = 0
        val map = HashMap<Char, Int>()
        var maxRepeat = Int.MIN_VALUE
        var maxLen = Int.MIN_VALUE

        for(r in s.indices) {
            map[s[r]] = map.getOrDefault(s[r], 0) + 1
            maxRepeat = maxOf(maxRepeat, map[s[r]]!!)

            val len = r - l + 1
            if(len > k + maxRepeat) {
                map[s[l]] = map[s[l]]!! - 1
                l++
            }
            maxLen = maxOf(maxLen, r - l + 1)
        }

        return maxLen
    }
}