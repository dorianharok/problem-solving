class Solution {
    fun isPalindrome(s: String): Boolean {
        if (s.isEmpty() || s.length == 1) {
            return true
        }

        var str = s.lowercase()

        var l = 0
        var r = str.length - 1

        while(l < r) {
            while(!str[l].isLetterOrDigit() && l < r) {
                l++
            }

            while(!str[r].isLetterOrDigit() && l < r) {
                r--
            }

            if(str[l] != str[r]) return false

            l++
            r--
        }

        return true
    }
}