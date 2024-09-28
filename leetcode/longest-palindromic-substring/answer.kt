class Solution {
    var left: Int = 0
    var right: Int = 0
    var maxLeng: Int = 0
    fun longestPalindrome(s: String): String {
        if(s.length == 1) {
            return s
        }

        for(i in 0..s.length-1) {
            expandPalindrome(s, i, i+1)
            expandPalindrome(s, i, i+2)
        }

        return s.substring(left, right)
    }

    fun expandPalindrome(s: String, i:Int, j: Int) {
        var l = i
        var r = j

        while(l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }

        var length = r - l + 1
        if(length > maxLeng) {
            maxLeng = length
            left = l + 1
            right = r
        }
    }
}