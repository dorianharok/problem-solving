class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        var mask = 0L
        for(j in jewels) {
            val bit = 1L shl if(j in 'a'..'z') j - 'a' else j - 'A' + 26
            mask = mask or bit.toLong()
        }

        var count = 0
        for(s in stones) {
            val bit = 1L shl if(s in 'a'..'z') s - 'a' else s - 'A' + 26
            if((mask and bit.toLong()) != 0L) count++
        }

        return count
    }
}