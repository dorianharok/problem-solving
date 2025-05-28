class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) {
            return false
        }

        val arr = IntArray(26)
        for (i in 0..<s.length) {
            arr[s[i] - 'a']++
            arr[t[i] - 'a']--
        }

        return arr.all { it == 0 }
    }
}