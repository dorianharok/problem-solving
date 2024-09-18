class Solution {
    fun isPalindrome(s: String): Boolean {
        var str = s.replace("[^A-Za-z0-9]".toRegex(), "").lowercase()

        return str == str.reversed()
    }
}