class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var p = 0

        for(i in 0 until t.length) {
            if(p == s.length) return true

            if(t[i] == s[p]) {
                p++
            }
        }

        return p == s.length
    }
}