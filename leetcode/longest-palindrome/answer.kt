class Solution {
    fun longestPalindrome(s: String): Int {
        var odd = false

        val lowerCase = IntArray(26)
        val upperCase = IntArray(26)
        for (c in s.toCharArray()) {
            if(c.isUpperCase()) {
                upperCase[c - 'A']++
            } else {
                lowerCase[c - 'a']++
            }
        }

        var answer = 0
        for(i in 0..25) {
            answer += lowerCase[i] / 2
            answer += upperCase[i] / 2

            if(lowerCase[i] % 2 == 1 || upperCase[i] % 2 == 1) {
                odd = true
            }
        }

        if(odd) {
            return answer * 2 + 1
        } else {
            return answer * 2
        }
    }
}