class Solution {
    fun repeatedCharacter(s: String): Char {
        var mask = 0

        for(c in s) {
            val bit = 1 shl (c - 'a')
            if(mask and bit != 0) {
                return c
            }

            mask = mask or bit
        }

        return 'a'
    }
}