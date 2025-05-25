class Solution {
    fun hammingWeight(n: Int): Int {
        var answer = 0

        var c = n
        while(c > 0) {
            if(c and 1 == 1) answer++
            c = c shr 1
        }

        return answer
    }
}