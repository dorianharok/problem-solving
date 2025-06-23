class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = HashSet<Char>()

        var length = 0
        var l = 0
        var r = 0

        while(r < s.length) {
            if(!set.contains(s[r])) {
                set.add(s[r++])
            } else {
                while(set.contains(s[r]) && l <= r) {
                    set.remove(s[l++])
                }
            }

            length = maxOf(length, r - l)
        }

        return length
    }
}